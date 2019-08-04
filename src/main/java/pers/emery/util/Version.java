package pers.emery.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import pers.emery.enums.WindowInstallPathEnum;
import pers.emery.exception.DriverVersionException;
import pers.emery.exception.LocalVersionException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Version {

    private static Map<String, String> OLD_VERSION_MAP;
    private static Map<String, String> NEW_VERSION_MAP;

    static {
        NEW_VERSION_MAP = new HashMap<>();

        ClassLoader classLoader = Version.class.getClassLoader();
        try (InputStream resourceIn = classLoader.getResourceAsStream("chromedriver.json")) {
            if (resourceIn != null) {
                ObjectMapper mapper = new ObjectMapper();
                OLD_VERSION_MAP = mapper.readValue(resourceIn, new TypeReference<Map<String, String>>(){});
            } else {
                OLD_VERSION_MAP = new HashMap<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * windows 下获取本地安装的 chrome 版本
     * @return
     */
    public String windowLocalChromeVersion() {

        Path installPath = Files.exists(WindowInstallPathEnum.USER_INSTALL_PATH.getPath()) ?
                WindowInstallPathEnum.USER_INSTALL_PATH.getPath() :
                WindowInstallPathEnum.ADMIN_INSTALL_PATH.getPath();

        if (!Files.exists(installPath)) {
            throw new LocalVersionException("无法识别本地安装的Chrome");
        }

        Optional<String> version;
        try {
            version = Files.list(installPath).filter(Files::isDirectory)
                    .filter(f -> f.getFileName().toString().matches("[0-9|.]+"))
                    .map(f -> f.getFileName().toString()).findFirst();
        } catch (IOException e) {
            throw new LocalVersionException("没有权限查看本地信息");
        }

        return version.orElseThrow(() -> new LocalVersionException("无法识别本地安装的Chrome"));
    }

    public String linuxLocalChromeVersion() {

        String[] cmd = new String[]{"/bin/bash", "-c", "/opt/google/chrome/google-chrome --version"};
        // zsh
        // String[] cmd = new String[]{"sh", "-c", "echo $SHELL"};
        StringBuilder sb = new StringBuilder();
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (process != null) {
            try (LineNumberReader lnr = new LineNumberReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = lnr.readLine()) != null) {
                    sb.append(line).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Optional<String> version = Arrays.stream(sb.toString().split(" "))
                .filter(s -> s.trim().matches("[0-9|.]+")).findFirst();

        return version.orElseThrow(() -> new LocalVersionException("无法识别本地安装的Chrome"));
    }

    /**
     * 获取 某个新版 chrome 版本 的 driver 版本
     * 发送 get 请求获取
     * @param chromeVersion
     * @param url
     * @return
     */
    public String getDriverVersion(String chromeVersion, String url) {

        // 先从 Map 中查看是否有 ‘缓存’
        String driverVersion = NEW_VERSION_MAP.get(chromeVersion);
        if (driverVersion != null) {
            return driverVersion;
        }

        // https://npm.taobao.org/mirrors/chromedriver/LATEST_RELEASE_70
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(url);
            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    driverVersion = EntityUtils.toString(response.getEntity(), "UTF-8").trim();
                }
            }
        } catch (IOException e) {
            throw new DriverVersionException("无法从网络获取驱动版本信息");
        }

        if (driverVersion != null && driverVersion.length() > 0) {
            NEW_VERSION_MAP.put(chromeVersion, driverVersion);
        }
        return driverVersion;
    }

    /**
     * 获取某个旧版 chrome 的 driver 版本
     * 记录保存在本地 json 信息中
     * @param version
     * @return
     */
    public String getDriverVersionLegacy(String version) {

        Optional<String> v = Optional.ofNullable(OLD_VERSION_MAP.get(version));
        return v.orElseThrow(() -> new DriverVersionException("无法获取相应的 Driver 版本。请检查输入是否有误"));
    }

}
