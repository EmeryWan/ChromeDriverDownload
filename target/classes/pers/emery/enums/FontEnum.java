package pers.emery.enums;

import lombok.Getter;

/**
 * @author emery
 */
@Getter
public enum FontEnum {

    WINDOWS_FONT("Microsoft YaHei"),

    LINUX_FONT("Noto Sans CJK SC"),

    MAC_FONT("Menlo"),
    ;

    FontEnum(String fontName) {
        this.fontName = fontName;
    }

    String fontName;

}
