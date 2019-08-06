package pers.emery.enums;

import lombok.Getter;

/**
 * @author emery
 */
@Getter
public enum MirrorEnum {

    /**
     * 淘宝镜像站
     */
    TAOBAO_MIRROR("https://npm.taobao.org/mirrors/chromedriver/"),

    /**
     * 国内需要使用代理
     * Google 可能需要更改下载 url
     */
    GOOGLE_MIRROR("https://chromedriver.storage.googleapis.com/"),

    /**
     * 华为镜像站
     */
    HUAWEI_MIRROR("https://mirrors.huaweicloud.com/chromedriver/"),

    ;

    private String url;

    MirrorEnum(String url) {
        this.url = url;
    }
}
