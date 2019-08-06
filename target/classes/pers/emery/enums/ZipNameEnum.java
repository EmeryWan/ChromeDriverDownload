package pers.emery.enums;

import lombok.Getter;

/**
 * @author emery
 */
@Getter
public enum ZipNameEnum {

    WIN32("chromedriver_win32.zip"),

    /**
     * 早期提供 linux32 版本
     * 现在已经不提供
     */
    LINUX64("chromedriver_linux64.zip"),

    MAC64("chromedriver_mac64.zip"),
    ;

    private String name;

    ZipNameEnum(String name) {
        this.name = name;
    }

}
