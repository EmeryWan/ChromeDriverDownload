package pers.emery.enums;

import org.junit.Test;

public class WindowInstallPathEnumTest {


    @Test
    public void test() {

        System.out.println(WindowInstallPathEnum.ADMIN_INSTALL_PATH.getPath());

        System.out.println(WindowInstallPathEnum.USER_INSTALL_PATH.getPath());

    }


}