package pers.emery.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import pers.emery.dto.DownloadThreadDto;
import pers.emery.exception.DownloadException;

import java.io.*;
import java.nio.file.Files;

/**
 * @author emery
 */
@Slf4j
public class DownloadRunnable implements Runnable {

    private DownloadThreadDto info;

    public DownloadRunnable(DownloadThreadDto info) {
        this.info = info;
    }

    @Override
    public void run() {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {

            HttpGet httpGet = new HttpGet(info.getUrl());

            try (CloseableHttpResponse httpResponse = httpClient.execute(httpGet)) {
                log.debug("开始下载");
                if (httpResponse.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                    throw new DownloadException("无法连接下载 URL，请重试");
                }

                // 创建目录
                if (!Files.exists(info.getDirPath())) {
                    Files.createDirectories(info.getDirPath());
                }

                try (FileWriter txtFw = new FileWriter(info.getTxtPath().toFile(), false)) {
                    txtFw.write("Chrome Version: " + info.getChromeVersion());
                    txtFw.write("\n");
                    txtFw.write("Driver Version: " + info.getDriverVersion());
                }

                // path 最后一级为文件名
                // (当前目录)/chromedriver/(版本号)/xxx.zip
                try (FileOutputStream fileOut = new FileOutputStream(info.getZipPath().toFile())) {
                    HttpEntity entity = httpResponse.getEntity();
                    entity.writeTo(fileOut);
                    log.debug("下载完成");
                }
            }

        } catch (IOException e) {
            throw new DownloadException("网络连接错误，请重试");
        }
    }

}
