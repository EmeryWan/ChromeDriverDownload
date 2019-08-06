package pers.emery;

import pers.emery.view.MainView;
import pers.emery.view.ViewSingleton;

import java.awt.*;

/**
 * @author emery
 */
public class Application {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MainView mainViewInstance = ViewSingleton.getMainViewInstance();
            mainViewInstance.showView();
            // mainViewInstance.recognitionLocalSoftInfo();
        });
    }
}
