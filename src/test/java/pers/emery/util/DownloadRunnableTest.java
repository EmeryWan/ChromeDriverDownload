package pers.emery.util;

import org.junit.Test;
import pers.emery.dto.DownloadThreadDto;

import java.nio.file.Paths;

public class DownloadRunnableTest {

    @Test
    public void test() {
        DownloadThreadDto dto = new DownloadThreadDto();

        dto.setChromeVersion("70");
        dto.setDriverVersion("70.0.3538.97");
        dto.setDirPath(Paths.get("/home/emery/chromedriver/70/"));
        dto.setTxtPath(Paths.get("/home/emery/chromedriver/70/info.txt"));
        dto.setZipPath(Paths.get("/home/emery/chromedriver/70/chromedriver_win32.zip"));
        dto.setUrl("https://npm.taobao.org/mirrors/chromedriver/70.0.3538.97/chromedriver_win32.zip");

        new Thread(new DownloadRunnable(dto)).start();

    }

}