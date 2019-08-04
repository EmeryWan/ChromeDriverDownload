package pers.emery.enums;

public enum FontEnum {

    WINDOWS_FONT("微软雅黑"),
    LINUX_FONT("文泉驿微米黑"),
    MAC_FONT(""),
    ;

    FontEnum(String fontName) {
        this.fontName = fontName;
    }

    String fontName;

    public String getFontName() {
        return fontName;
    }

}
