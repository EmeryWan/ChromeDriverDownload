package pers.emery.dto;

import lombok.Data;
import pers.emery.enums.MirrorEnum;
import pers.emery.enums.ZipNameEnum;

import java.nio.file.Path;

/**
 * @author emery
 */
@Data
public class DownloadDTO {

    private String chromeVersion;

    private String driverVersion;

    /**
     * 镜像源
     */
    private MirrorEnum mirrorEnum;

    /**
     * 下载系统版本
     */
    private ZipNameEnum zipNameEnum;

    /**
     * 下载地址
     */
    private Path rootPath;

}
