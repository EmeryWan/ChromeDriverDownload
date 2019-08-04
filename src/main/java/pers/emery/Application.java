package pers.emery;

import pers.emery.view.MainView;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Application {

    public static void main(String[] args) throws IOException {
         new MainView().setVisible(true);

//        ClassLoader classLoader = Application.class.getClassLoader();
//        URL resource = classLoader.getResource("chromedriver.json");
//        String path = resource.getPath();
//        System.out.println(path);

    }

}
