package pers.emery.view;

import lombok.extern.slf4j.Slf4j;
import pers.emery.exception.DriverVersionException;
import pers.emery.exception.LocalVersionException;
import pers.emery.service.VersionService;
import pers.emery.vo.ChromeInfoVO;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@Slf4j
public class DownloadPanel extends AbstractDownloadPanel {

    private VersionService versionService = new VersionService();

    public DownloadPanel() {
        initAction();

        registerAction();
    }

    /**
     * 页面启动时判断
     */
    private void initAction() {
        // 显示当前系统
        showCurrentSystem();
        // 自动识别本地安装
        showLocalSoftInfo();
    }

    /**
     * 注册事件
     */
    private void registerAction() {
        // 输入框事件
        inputAction();
        // 更新按钮事件
        updateAction();
        // 下载按钮事件
        downloadAction();
        // 下部跳转按钮
        proxyAction();
        aboutAction();
    }

    // ----- init method

    private void showCurrentSystem() {
        String osName = System.getProperty("os.name");
        log.info("current system: {}", osName);
        localSystemLabel.setText("Current System:  " + osName);
    }

    private void showLocalSoftInfo() {
        try {
            ChromeInfoVO chromeInfoVO = versionService.initVersionLoad();
            setVersionInfo(chromeInfoVO);
            setTipInfo("已自动识别本地安装的Chrome信息，可直接点击下载。");
        } catch (LocalVersionException | DriverVersionException e) {
            setTipInfo(e.getMessage());
        }
    }

    // ----- action method

    private void inputAction() {
        // 只能输入数字
        chromeVersionText.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                int keyChar = e.getKeyChar();
                if (keyChar < KeyEvent.VK_0 || keyChar > KeyEvent.VK_9) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        chromeVersionText.addFocusListener(new FocusListener() {
            String text = tipInfoLabel.getText();

            @Override
            public void focusGained(FocusEvent e) {
                setTipInfo("请输入Chrome大版本号。如：76.0.3809.87，输入 76 即可。");
            }

            @Override
            public void focusLost(FocusEvent e) {
                setTipInfo(text);
            }
        });
    }

    private void updateAction() {
        // 重新发送 get 请求
        String version = chromeVersionText.getText().trim();
        if (version.matches("[0-9]+")) {
            // 发送 get 请求
        } else {
            // 设置边框颜色为红色
        }
    }

    private void downloadAction() {
        // 获取 系统版本 镜像源 版本
        // 下载
    }

    private void proxyAction() {

    }

    private void aboutAction() {

    }

    // ----- auxiliary method

    private void setVersionInfo(ChromeInfoVO info) {
        chromeVersionLabel.setText(info.getChromeVersion());
        driverVersionLabel.setText(info.getDriverVersion());
    }

    private void setTipInfo(String info) {
        tipInfoLabel.setText(info);
    }

}
