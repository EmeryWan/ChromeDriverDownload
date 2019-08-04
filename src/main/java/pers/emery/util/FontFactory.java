package pers.emery.util;


import pers.emery.enums.FontEnum;

import java.awt.*;

/**
 * 同一生成字体样式工厂
 *
 *
 * 获得一个字体大小为 20 的字体对象
 * Font font = FontFactory.getFontBySize(20);
 *
 *
 * 获得一个  粗体  大小为 20  的字体对象
 * Font font = FontFactory.getFontByStyleAndSize(Font.BOLD, 20);
 *
 * @author emery
 */
public class FontFactory {

    private static final String FONT_NAME;

    static {
        if ("linux".equals(BaseInfo.OS_NAME)) {
            FONT_NAME = FontEnum.LINUX_FONT.getFontName();
        } else if ("windows".equals(BaseInfo.OS_NAME)) {
            FONT_NAME = FontEnum.WINDOWS_FONT.getFontName();
        } else {
            FONT_NAME = FontEnum.MAC_FONT.getFontName();
            // macOS
        }
    }

    public static Font getFontBySize(int size) {
        return new Font(FONT_NAME, Font.PLAIN, size);
    }

    public static Font getFontByStyleAndSize(int style, int size) {
        return new Font(FONT_NAME, style, size);
    }

}
