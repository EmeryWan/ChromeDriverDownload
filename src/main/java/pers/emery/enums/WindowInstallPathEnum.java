package pers.emery.enums;

import lombok.Getter;
import pers.emery.util.BaseInfo;

import java.nio.file.Path;
import java.nio.file.Paths;

@Getter
public enum WindowInstallPathEnum {

    USER_INSTALL_PATH(getAdminPath()),
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
