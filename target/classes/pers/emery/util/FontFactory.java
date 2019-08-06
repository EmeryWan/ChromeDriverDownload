package pers.emery.util;


import pers.emery.enums.FontEnum;
import pers.emery.enums.SystemEnum;

import java.awt.*;

/**
 * @author emery
 */
public class FontFactory {

    private static final String FONT_NAME;

    static {
        if (SystemEnum.LINUX.getName().equals(BaseInfo.OS_NAME)) {
            FONT_NAME = FontEnum.LINUX_FONT.getFontName();
        } else if (SystemEnum.WINDOWS.getName().equals(BaseInfo.OS_NAME)) {
            FONT_NAME = FontEnum.WINDOWS_FONT.getFontName();
        } else {
            FONT_NAME = FontEnum.MAC_FONT.getFontName();
        }
    }

    public static Font getFontBySize(int size) {
        return new Font(FONT_NAME, Font.PLAIN, size);
    }

    public static Font getFontByStyleAndSize(int style, int size) {
        return new Font(FONT_NAME, style, size);
    }

}
