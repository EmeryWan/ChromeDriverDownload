package pers.emery.enums;

import lombok.Getter;

@Getter
public enum SystemEnum {

    WINDOWS("windows"),

    LINUX("linux"),

    MAC_OS_X("mac os x"),

    ;

    private String name;

    SystemEnum(String name) {
        this.name = name;
    }

}
