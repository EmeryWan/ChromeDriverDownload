package pers.emery.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import pers.emery.dto.VersionDto;

import java.io.FileOutputStream;
import java.io.IOException;

public class DownloadThread implements Runnable {

    private VersionDto info;

    public DownloadThread(VersionDto info) {
        this.info = info;
    }

    @Override
    public void run() {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {

            HttpGet httpGet = new HttpGet(info.getUrl());

            try (CloseableHttpResponse httpResponse = httpClient.execute(httpGet)) {
                if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    try (FileOutputStream fileOut = new FileOutputStream(info.getPath())) {
                        HttpEntity entity = httpResponse.getEntity();
                        entity.writeTo(fileOut);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
