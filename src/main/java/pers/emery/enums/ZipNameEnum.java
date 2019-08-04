package pers.emery.enums;

import lombok.Getter;

@Getter
public enum ZipNameEnum {

    WINDOWS("chromedriver_win32.zip"),
    LINUX("chromedriver_linux64.zip"),
    MAC("chromedriver_mac64.zip"),
    ;

    private String name;

    ZipNameEnum(String name) {
        this.name = name;
    }

}
