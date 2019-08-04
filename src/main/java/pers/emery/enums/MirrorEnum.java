package pers.emery.enums;

import lombok.Getter;

@Getter
public enum MirrorEnum {

    GOOGLE_MIRROR(""),

    TAOBAO_MIRROR("https://npm.taobao.org/mirrors/chromedriver/"),

    ;

    private String url;

    MirrorEnum(String url) {
        this.url = url;
    }
}
