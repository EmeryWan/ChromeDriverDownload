package pers.emery.view;

import lombok.extern.slf4j.Slf4j;
import pers.emery.dto.DownloadDTO;
import pers.emery.dto.VersionDto;
import pers.emery.enums.MirrorEnum;
import pers.emery.enums.ZipNameEnum;
import pers.emery.exception.DownloadException;
import pers.emery.exception.DriverVersionException;
import pers.emery.exception.LocalVersionException;
import pers.emery.service.DownloadService;
import pers.emery.service.VersionService;
import pers.emery.vo.ChromeInfoVO;

import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author emery
 */
@Slf4j
public class DownloadPanel extends AbstractDownloadPanel {

    private VersionService versionService = new VersionService();
    private DownloadService downloadService = new DownloadService();

    private Border normalBorder;
    private MatteBorder dangerBorder;


    public DownloadPanel() {
        normalBorder = chromeVersionText.getBorder();
        dangerBorder = new MatteBorder(2, 2, 2, 2, new Color(255, 0, 0));

        actionEvent();
    }

    private void actionEvent() {
        initAction();
        registerAction();
    }

    // ----- init method

    @Override
    public void recognitionLocalSoftInfo() {
        try {
            ChromeInfoVO chromeInfoVO = versionService.initVersionLoad();
            setVersionInfo(chromeInfoVO);
            log.debug(chromeInfoVO.toString());
            setTipInfo("自动识别本地 Chrome: " + chromeInfoVO.getChromeVersion() + "，可点击下载本地版本。稍等片刻即可下载完成。");
        } catch (LocalVersionException | DriverVersionException e) {
            log.debug(e.getMessage());
            setTipInfo(e.getMessage());
        }
    }

    @Override
    protected void showCurrentSystem() {
        String osName = System.getProperty("os.name");
        log.debug("current system: {}", osName);
        localSystemLabel.setText("Current System:  " + osName);
    }

    // ----- action method

    /**
     * 识别本地安装的 Chrome
     */
    @Override
    protected void autoAction() {
        autoRecognitionBtn.addActionListener(e -> recognitionLocalSoftInfo());
    }

    /**
     * 输入框限定
     */
    @Override
    protected void inputAction() {
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
                setNormalInput();
                setTipInfo("请输入Chrome大版本号。如：76.0.3809.87，输入 76 即可。");
            }

            @Override
            public void focusLost(FocusEvent e) {
                setTipInfo(text);
            }
        });
    }

    /**
     * 更新按钮
     */
    @Override
    protected void updateAction() {
        updateBtn.addActionListener(e -> {
            // 重新发送 get 请求
            String version = chromeVersionText.getText().trim();
            if (version.matches("[0-9]+")) {
                // 获取镜像源
                MirrorEnum selectedItem = (MirrorEnum) mirrorComboBox.getSelectedItem();
                VersionDto dto = new VersionDto();
                dto.setMirrorEnum(selectedItem);
                dto.setChromeVersion(version);
                log.debug(dto.toString());
                // 发送 get 请求
                String driverVersion = versionService.getDriverVersion(dto);

                // 更新信息
                setVersionInfo(new ChromeInfoVO(version, driverVersion));
                if (!"".equals(driverVersion)) {
                    setTipInfo("更新 Chrome 版本为：" + version + " ，点击下载后，稍等片刻即可下载完成。");
                } else {
                    setDangerInput();
                    setTipInfo("无法检测到相应版本，请检查输入");
                }
            } else {
                setDangerInput();
            }
        });
    }

    /**
     * 下载按钮事件
     */
    @Override
    protected void downloadAction() {

        downLoadBtn.addActionListener(action -> {

            // 获取 系统版本 镜像源 版本
            String chromeVersion = chromeVersionLabel.getText();
            if (chromeVersion.matches("[0-9|.]+")) {
                chromeVersion = chromeVersion.split("[.]")[0];
            }
            log.debug(chromeVersion);
            String driverVersion = driverVersionLabel.getText();
            ZipNameEnum zipNameEnum = (ZipNameEnum) zipComboBox.getSelectedItem();
            MirrorEnum mirrorEnum = (MirrorEnum) mirrorComboBox.getSelectedItem();
            Path rootPath = Paths.get(".", "chromedirver", chromeVersion).toAbsolutePath();

            DownloadDTO downloadDTO = new DownloadDTO();
            downloadDTO.setChromeVersion(chromeVersion);
            downloadDTO.setDriverVersion(driverVersion);
            downloadDTO.setZipNameEnum(zipNameEnum);
            downloadDTO.setMirrorEnum(mirrorEnum);
            downloadDTO.setRootPath(rootPath);
            log.debug(downloadDTO.toString());

            boolean sign = false;
            try {
                sign = downloadService.downloadDriver(downloadDTO);
            } catch (DownloadException e) {
                setTipInfo(e.getMessage());
            }

            log.debug(String.valueOf(sign));

            if (sign) {
                setTipInfo("下载完成！ 路径：" + rootPath);
            } else {
                setTipInfo("下载失败！请重试");
            }
        });
    }

    // ----- auxiliary method

    private void setVersionInfo(ChromeInfoVO info) {
        chromeVersionLabel.setText(info.getChromeVersion());
        driverVersionLabel.setText(info.getDriverVersion());
    }

    private void setTipInfo(String info) {
        tipInfoLabel.setText(info);
    }

    private void enableBtn() {
        autoRecognitionBtn.setEnabled(true);
        updateBtn.setEnabled(true);
        downLoadBtn.setEnabled(true);
    }

    private void disableBtn() {
        autoRecognitionBtn.setEnabled(false);
        updateBtn.setEnabled(false);
        downLoadBtn.setEnabled(false);
    }

    private void setDangerInput() {
        chromeVersionText.setBorder(dangerBorder);
    }

    private void setNormalInput() {
        chromeVersionText.setBorder(normalBorder);
    }

}
