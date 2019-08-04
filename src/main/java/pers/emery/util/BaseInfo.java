package pers.emery.util;

public class BaseInfo {

    public static final String OS_NAME;
    public static final String USER_NAME;

    static {
        // os_name 可能需要更改
        OS_NAME = System.getProperty("os.name").toLowerCase();
        USER_NAME = System.getProperty("user.name");
    }

}
