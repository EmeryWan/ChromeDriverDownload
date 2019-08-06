package pers.emery.dto;

import lombok.Data;

import java.nio.file.Path;

/**
 * @author emery
 */
@Data
public class DownloadThreadDto {

    private String chromeVersion;

    private String driverVersion;

    /**
     * 下载链接
     */
    private String url;

    /**
     * 文件夹目录
     */
    private Path dirPath;

    /**
     * 文件信息
     */
    private Path txtPath;

    /**
     * 下载位置
     * 最后一级目录为下载文件名
     */
    private Path zipPath;

    /**
     * 代理
     */
    private boolean proxy;


}
