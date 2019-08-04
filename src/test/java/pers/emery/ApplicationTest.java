package pers.emery;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;

public class ApplicationTest {

    String win_path1 = "C:\\Program Files (x86)\\Google\\Chrome\\Application";
    String win_path2 = "C:\\Users\\Emery\\AppData\\Local\\Google\\Chrome\\Application";

    @Test
    public void userTest() {
        System.out.println(System.getProperty("user.name"));
        // https://blog.csdn.net/isea533/article/details/8449919
        System.out.println(System.getProperty("os.name"));
    }

    @Test
    public void nameTest() {
        System.out.println("75.0.3770.142".matches("[0-9|.]+"));
    }

    @Test
    public void pathTest() {
        Path path = Paths.get(win_path2);
        System.out.println(path.getFileName());
        if (Files.exists(path)) {
            try {
                //Files.list(path).filter(Files::isDirectory).forEach(System.out::println);

                Files.list(path).filter(Files::isDirectory).peek(f -> System.out.println(f.getFileName()))
                        .filter(f -> {
                            // System.out.println(f.getFileName());
                            if (f.getFileName().startsWith("75")) {
                                System.out.println(f.getFileName());
                                return true;
                            }
                            return false;
                        }).forEach(System.out::println);
//                        .filter(f -> f.getFileName().startsWith("75")).forEach(System.out::println);


                System.out.println(" ----------------- ");

                Files.list(path).filter(Files::isDirectory).filter(f -> {
                    if (f.getFileName().toString().startsWith("75")) {
                        return true;
                    }
                    return false;
                }).forEach(System.out::println);

                System.out.println(" ---------- ");

                Files.list(path).filter(Files::isDirectory).filter(f -> f.getFileName().toString().matches("[0-9|.]+")).forEach(System.out::println);

                Set<String> paths = Files.list(path).filter(Files::isDirectory).filter(f -> f.getFileName().toString().matches("[0-9|.]+")).map(f -> f.getFileName().toString()).collect(Collectors.toSet());

                System.out.println(paths);


            } catch (IOException e) {
                // 没有权限
                e.printStackTrace();
            }
        }
    }

    @Test
    public void getTest() {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet("https://npm.taobao.org/mirrors/chromedriver/LATEST_RELEASE_70");
            CloseableHttpResponse response = httpClient.execute(httpGet);

            // 最后需要拼接 /
            // https://npm.taobao.org/mirrors/chromedriver/70.0.3538.97/

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void downTest() {
        try {

            // ./版本/zip名

            String path = "/mnt/data/down";

            // https://npm.taobao.org/mirrors/chromedriver/70.0.3538.97/chromedriver_win32.zip
            String url = "https://npm.taobao.org/mirrors/chromedriver/70.0.3538.97/chromedriver_win32.zip";
            try (CloseableHttpClient httpClient =HttpClients.createDefault()) {
                HttpGet httpGet = new HttpGet(url);
                try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                    if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                        FileOutputStream fout = new FileOutputStream(path);
                        HttpEntity entity = response.getEntity();
                        entity.writeTo(fout);
                        fout.close();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void jsonTest() throws IOException {

        // < 70
        // Path path = Paths.get("/mnt/data/Projects/IdeaProjects/ChromeDriverDownload/src/main/resources/chromedriver.json");
        Path path = Paths.get("src/chromedriver.json");

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(path.toFile());
        System.out.println(root.toString());
        System.out.println(root.get("test").asText());
        System.out.println(root.getNodeType());
    }

}