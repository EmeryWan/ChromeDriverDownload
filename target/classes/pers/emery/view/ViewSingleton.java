package pers.emery.view;

/**
 * @author emery
 */
public class ViewSingleton {

    private ViewSingleton() { }

    private static volatile MainView mainViewInstance;

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

    private static class AboutViewInstanceHolder {
         private static final AboutView ABOUT_VIEW_INSTANCE = new AboutView();
    }

    public static AboutView getAboutViewInstance() {
        return AboutViewInstanceHolder.ABOUT_VIEW_INSTANCE;
    }

}
