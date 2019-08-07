package pers.emery.view;

/**
 * @author emery
 */
public class ViewSingleton {

    private ViewSingleton() {
    }

    private static volatile MainView mainViewInstance;
    private static volatile AboutView aboutViewInstance;

    public static MainView getMainViewInstance() {
        if (mainViewInstance == null) {
            synchronized (ViewSingleton.class) {
                if (mainViewInstance == null) {
                    mainViewInstance = new MainView();
                }
            }
        }
        return mainViewInstance;
    }

    public static AboutView getAboutViewInstance() {
        if (aboutViewInstance == null) {
            synchronized (ViewSingleton.class) {
                if (aboutViewInstance == null) {
                    aboutViewInstance = new AboutView();
                }
            }
        }
        return aboutViewInstance;
    }

}
