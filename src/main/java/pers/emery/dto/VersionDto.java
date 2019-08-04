package pers.emery.dto;

import lombok.Data;
import pers.emery.enums.MirrorEnum;

@Data
public class VersionDto {

    /**
     * 下载位置
     */
    private String path;

    /**
     * 下载地址
     */
    private String url;

    /**
     * 是否使用代理
     */
    private boolean proxy;

    /**
     * 镜像源
     */
    private MirrorEnum mirrorEnum;

    private String chromeVersion;

    private String driverVersion;
}
