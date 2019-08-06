package pers.emery.view;

import pers.emery.enums.MirrorEnum;
import pers.emery.enums.ZipNameEnum;

import javax.swing.*;

/**
 * @author emery
 */
public abstract class AbstractDownloadPanel extends JPanel {

    private JLabel chromeTipLabel;
    private JLabel driverTipLabel;
    protected JLabel chromeVersionLabel;
    protected JLabel driverVersionLabel;
    protected JLabel tipInfoLabel;

    private JLabel versionTipLabel;
    protected JButton autoRecognitionBtn;
    protected JTextField chromeVersionText;
    protected JButton updateBtn;

    private JLabel systemTipLabel;
    private JLabel mirrorTipLabel;
    protected JComboBox<ZipNameEnum> zipComboBox;
    protected JComboBox<MirrorEnum> mirrorComboBox;
    protected JButton downLoadBtn;

    protected JLabel localSystemLabel;
    protected JButton switchProxyPanelBtn;
    protected JButton aboutBtn;


    public AbstractDownloadPanel() {
        viewInit();
    }

    private void viewInit() {
        setLayout(null);
        chromeTipLabel = new JLabel("Chrome Version");
        chromeTipLabel.setBounds(50, 25, 200, 50);
        add(chromeTipLabel);

        driverTipLabel = new JLabel("Driver Version");
        driverTipLabel.setBounds(500, 25, 200, 50);
        add(driverTipLabel);

        chromeVersionLabel = new JLabel("");
        chromeVersionLabel.setBounds(280, 25, 200, 50);
        add(chromeVersionLabel);

        driverVersionLabel = new JLabel("");
        driverVersionLabel.setBounds(730, 25, 200, 50);
        add(driverVersionLabel);

        tipInfoLabel = new JLabel("请输入 Chrome 版本号");
        tipInfoLabel.setBounds(50, 100, 800, 55);
        add(tipInfoLabel);

        versionTipLabel = new JLabel("版本号");
        versionTipLabel.setBounds(330, 180, 200, 35);
        add(versionTipLabel);

        autoRecognitionBtn = new JButton("自动检测版本");
        autoRecognitionBtn.setToolTipText("部分操作系统有效");
        autoRecognitionBtn.setBounds(50, 230, 200, 45);
        add(autoRecognitionBtn);

        chromeVersionText = new JTextField();
        chromeVersionText.setToolTipText("请输入版本号");
        chromeVersionText.setBounds(330, 230, 200, 45);
        chromeVersionText.setColumns(10);
        add(chromeVersionText);

        updateBtn = new JButton("更新");
        updateBtn.setBounds(660, 230, 120, 45);
        add(updateBtn);

        systemTipLabel = new JLabel("下载版本");
        systemTipLabel.setBounds(50, 300, 150, 35);
        add(systemTipLabel);

        mirrorTipLabel = new JLabel("镜像源");
        mirrorTipLabel.setBounds(330, 300, 150, 35);
        add(mirrorTipLabel);

        zipComboBox = new JComboBox<>();
        zipComboBox.setModel(new DefaultComboBoxModel<>(ZipNameEnum.values()));
        zipComboBox.setToolTipText("");
        zipComboBox.setBounds(50, 350, 150, 45);
        add(zipComboBox);

        mirrorComboBox = new JComboBox<>();
        mirrorComboBox.setModel(new DefaultComboBoxModel<>(MirrorEnum.values()));
        mirrorComboBox.setBounds(330, 350, 150, 45);
        add(mirrorComboBox);

        downLoadBtn = new JButton("下载");
        downLoadBtn.setBounds(660, 350, 120, 45);
        add(downLoadBtn);

        localSystemLabel = new JLabel("当前系统：");
        localSystemLabel.setBounds(50, 480, 230, 50);
        add(localSystemLabel);

        switchProxyPanelBtn = new JButton("代理");
        switchProxyPanelBtn.setBounds(550, 490, 120, 30);
        add(switchProxyPanelBtn);

        aboutBtn = new JButton("关于");
        aboutBtn.setBounds(730, 490, 120, 30);
        add(aboutBtn);
    }



    /* template method */

    /**
     * 页面启动时判断
     */
    protected void initAction() {
        // 显示当前系统
        showCurrentSystem();
        // 自动识别本地安装
        // recognitionLocalSoftInfo();
    }

    /**
     * 注册事件
     */
    protected void registerAction() {
        // 自动检测
        autoAction();
        // 输入框事件
        inputAction();
        // 更新按钮事件
        updateAction();
        // 下载按钮事件
        downloadAction();
    }

    protected abstract void recognitionLocalSoftInfo();

    // ----- init method

    protected abstract void showCurrentSystem();

    // ----- action method

    /**
     * 识别本地安装的 Chrome
     */
    protected abstract void autoAction();

    /**
     * 输入框限定
     */
    protected abstract void inputAction();

    /**
     * 更新按钮
     */
    protected abstract void updateAction();

    /**
     * 下载按钮事件
     */
    protected abstract void downloadAction();

}
