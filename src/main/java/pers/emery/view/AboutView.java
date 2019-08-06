package pers.emery.view;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author emery
 */
@Slf4j
public class AboutView extends AbstractAboutView {

    private static final String GITHUB_URL = "https://github.com/EmeryWan/ChromeDriverDownload";
    private static final String SELENIUM_URL = "https://docs.seleniumhq.org/";
    private static final String CHROME_DRIVER_URL = "https://sites.google.com/a/chromium.org/chromedriver/";

    public AboutView() {
        imageLoad();
        registerAction();
    }

    @Override
    protected void imageLoad() {
        Path imgPath = Paths.get(AbstractAboutView.class.getResource("/").getPath(), "tip.png");
        ImageIcon icon = new ImageIcon(imgPath.toString());
        log.info(imgPath.toString());
        log.info(String.valueOf(Files.exists(imgPath)));
        imgLabel.setIcon(icon);
    }

    @Override
    protected void github() {
        githubBtn.addActionListener(e -> {
            urlClipboard(GITHUB_URL);
            setTipInfo("Github 项目地址 链接 URL 已复制到剪贴板");
        });
    }

    @Override
    protected void selenium() {
        seleniumBtn.addActionListener(e -> {
            urlClipboard(SELENIUM_URL);
            setTipInfo("Selenium 官网链接 URL 已复制到剪贴板");
        });
    }

    @Override
    protected void chromeDriver() {
        chromeDriverBtn.addActionListener(e -> {
            urlClipboard(CHROME_DRIVER_URL);
            setTipInfo("ChromeDriver 官网链接 URL 已复制到剪贴板");
        });
    }

    // ---

    private void urlClipboard(String url) {
        // 获取系统剪贴板
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        // 封装文本内容
        Transferable trans = new StringSelection(url);
        // 把文本内容设置到系统剪贴板
        clipboard.setContents(trans, null);
    }

    private void setTipInfo(String info) {
        tipLabel.setText(info);
    }

}
