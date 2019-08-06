package pers.emery.service;

import pers.emery.dto.VersionDto;
import pers.emery.enums.MirrorEnum;
import pers.emery.enums.SystemEnum;
import pers.emery.util.BaseInfo;
import pers.emery.util.Version;
import pers.emery.vo.ChromeInfoVO;

public class VersionService {

    /**
     * chrome 版本分割线
     * < 70 chromedriver 为旧版命名
     * >= 70 chromedirver 为新版命名
     */
    private static final int VERSION_LINE = 70;

    /**
     * 发送 get 请求 url 的版本前缀
     */
    private static final String VERSION_PREFIX = "LATEST_RELEASE_";

    private static final String FAIL_INFO = "未能识别";

    // -----

    private Version version;

    public VersionService() {
        version = new Version();
    }

    // -----

    /**
     * 初始化时尝试加载本地安装的 chrome 信息
     */
    public ChromeInfoVO initVersionLoad() {
        ChromeInfoVO info = new ChromeInfoVO();

        String chromeVersion = recognitionChromeVersion();
        String driverVersion = recognitionDriverVersion(chromeVersion);

        info.setChromeVersion(chromeVersion);
        info.setDriverVersion(driverVersion);
        return info;
    }

    /**
     * 自动获取 本地 chrome 版本
     */
    public String recognitionChromeVersion() {

        if (SystemEnum.WINDOWS.getName().equals(BaseInfo.OS_NAME)) {
            return version.windowLocalChromeVersion();
        }

        if (SystemEnum.LINUX.getName().equals(BaseInfo.OS_NAME)) {
            return version.linuxLocalChromeVersion();
        }

        return FAIL_INFO;
    }

    /**
     * 76.0.3809.87
     */
    public String recognitionDriverVersion(String v) {

        if (!v.matches("[0-9|.]+")) {
            return FAIL_INFO;
        }

        // 76.0.3809.87
        v = v.split("[.]")[0];

        String driver;
        if (Integer.parseInt(v) < VERSION_LINE) {
            driver = version.getDriverVersionLegacy(v);
        } else {
            String url = MirrorEnum.TAOBAO_MIRROR.getUrl() + VERSION_PREFIX + v;
            // get 获得版本
            driver = version.getDriverVersion(v, url);
        }

        return driver;
    }

    public String getDriverVersion(VersionDto versionDto) {
        String chromeVersion = versionDto.getChromeVersion();
        String driverVersion;
        // 两种格式 75.5.5.55   75
        if (chromeVersion.matches("[0-9|.]+")) {
            chromeVersion = chromeVersion.split("[.]")[0];
        }

        if (Integer.parseInt(chromeVersion) < VERSION_LINE) {
            // 旧版本 json 信息中查找
            driverVersion = version.getDriverVersionLegacy(chromeVersion);
        } else {
            // https://npm.taobao.org/mirrors/chromedriver/
            // https://npm.taobao.org/mirrors/chromedriver/LATEST_RELEASE_70
            driverVersion = version.getDriverVersion(chromeVersion, versionDto.getMirrorEnum().getUrl() + VERSION_PREFIX + chromeVersion);
        }

        return driverVersion;
    }

}
