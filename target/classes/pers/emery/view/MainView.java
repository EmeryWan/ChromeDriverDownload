package pers.emery.view;

import javax.swing.*;
import java.awt.*;

/**
 * @author emery
 */
public class MainView extends AbstractMainView {

    public MainView() {
        registerAction();
    }

    private void registerAction() {
        cardPanelSwitch();
        aboutView();
    }

    public void recognitionLocalSoftInfo() {
        downloadPanel.recognitionLocalSoftInfo();
    }

    private void cardPanelSwitch() {
        downloadPanel.switchProxyPanelBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "待开发。如需使用，请配置系统代理。", "代理", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    private void aboutView() {
        downloadPanel.aboutBtn.addActionListener(e -> EventQueue.invokeLater(() -> ViewSingleton.getAboutViewInstance().showView()));
    }
}
