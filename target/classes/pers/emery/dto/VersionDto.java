package pers.emery.dto;

import lombok.Data;
import pers.emery.enums.MirrorEnum;

/**
 * @author emery
 */
@Data
public class VersionDto {

    /**
     * 镜像源
     */
    private MirrorEnum mirrorEnum;

    private String chromeVersion;

    /**
     * 是否使用代理
     */
    private boolean proxy;


}
