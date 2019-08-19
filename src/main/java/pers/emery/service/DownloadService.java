package pers.emery.service;

import lombok.extern.slf4j.Slf4j;
import pers.emery.dto.DownloadDTO;
import pers.emery.dto.DownloadThreadDto;
import pers.emery.util.DownloadRunnable;

import java.awt.*;
import java.nio.file.Paths;

@Slf4j
public class DownloadService {

    public void downloadDriver(DownloadDTO dto) {

        DownloadThreadDto downloadThreadDto = new DownloadThreadDto();

        String rootPath = Paths.get(".", "chromedriver", dto.getChromeVersion()).toString();
        String txtName = "info.txt";

        if (dto.getChromeVersion().matches("[0-9|.]+")) {
            downloadThreadDto.setChromeVersion(dto.getChromeVersion().split("[.]")[0]);
        } else {
            downloadThreadDto.setChromeVersion(dto.getChromeVersion());
        }
        downloadThreadDto.setDriverVersion(dto.getDriverVersion());
        downloadThreadDto.setDirPath(Paths.get(rootPath));
        downloadThreadDto.setTxtPath(Paths.get(rootPath, txtName));
        downloadThreadDto.setZipPath(Paths.get(rootPath, dto.getZipNameEnum().getName()));
        downloadThreadDto.setUrl(dto.getMirrorEnum().getUrl() + dto.getDriverVersion() + "/" + dto.getZipNameEnum().getName());

        log.info(downloadThreadDto.toString());

        EventQueue.invokeLater(new DownloadRunnable(downloadThreadDto));
    }

}
