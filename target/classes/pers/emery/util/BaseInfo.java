package pers.emery.util;

/**
 * @author emery
 */
public class BaseInfo {

    public static final String OS_NAME;
    public static final String USER_NAME;


    static {
        String win = "windows";
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains(win)) {
            OS_NAME = win;
        } else {
            OS_NAME = os;
        }

        USER_NAME = System.getProperty("user.name");
    }

}
