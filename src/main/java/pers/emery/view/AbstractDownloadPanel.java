package pers.emery.view;

import javax.swing.*;

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
    protected JComboBox<String> systemComboBox;
    protected JComboBox<String> mirrorComboBox;
    protected JButton downLoadBtn;

    protected JLabel localSystemLabel;
    protected JButton switchProxyPanelBtn;
    protected JButton btnAbout;


    public AbstractDownloadPanel() {
        setLayout(null);

        init();
    }

    private void init() {
        chromeTipLabel = new JLabel("Chrome Version");
        chromeTipLabel.setBounds(50, 25, 200, 50);
        add(chromeTipLabel);

        driverTipLabel = new JLabel("Driver Version");
        driverTipLabel.setBounds(500, 25, 200, 50);
        add(driverTipLabel);

        chromeVersionLabel = new JLabel("70.0.3538.97");
        chromeVersionLabel.setBounds(280, 25, 200, 50);
        add(chromeVersionLabel);

        driverVersionLabel = new JLabel("70.0.3538.97");
        driverVersionLabel.setBounds(730, 25, 200, 50);
        add(driverVersionLabel);

        tipInfoLabel = new JLabel("TipLabel");
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
        chromeVersionText.setText("请输入版本号");
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

        systemComboBox = new JComboBox<>();
        systemComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"win32", "linux64", "mac64"}));
        systemComboBox.setToolTipText("");
        systemComboBox.setBounds(50, 350, 150, 45);
        add(systemComboBox);

        mirrorComboBox = new JComboBox<>();
        mirrorComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"taobao", "google"}));
        mirrorComboBox.setBounds(330, 350, 150, 45);
        add(mirrorComboBox);

        downLoadBtn = new JButton("Download");
        downLoadBtn.setBounds(660, 350, 120, 45);
        add(downLoadBtn);

        localSystemLabel = new JLabel("当前系统：");
        localSystemLabel.setBounds(50, 480, 230, 50);
        add(localSystemLabel);

        switchProxyPanelBtn = new JButton("Proxy");
        switchProxyPanelBtn.setBounds(550, 490, 120, 30);
        add(switchProxyPanelBtn);

        btnAbout = new JButton("About");
        btnAbout.setBounds(730, 490, 120, 30);
        add(btnAbout);
    }


}
