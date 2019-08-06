package pers.emery.enums;

import lombok.Getter;
import pers.emery.util.BaseInfo;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author emery
 */
@Getter
public enum WindowInstallPathEnum {

    /**
     * windows 用户安装路径
     */
    USER_INSTALL_PATH(getAdminPath()),

    /**
     * windows 管理员安装路径
     */
    ADMIN_INSTALL_PATH(getUserPath()),
    ;

    private Path path;

    WindowInstallPathEnum(Path path) {
        this.path = path;
    }

    private static Path getAdminPath() {
        return Paths.get("C:\\Program Files (x86)\\Google\\Chrome\\Application");
    }

    private static Path getUserPath() {
        String user = BaseInfo.USER_NAME;
        return Paths.get("C:\\Users", user, "AppData\\Local\\Google\\Chrome\\Application");
    }

}
