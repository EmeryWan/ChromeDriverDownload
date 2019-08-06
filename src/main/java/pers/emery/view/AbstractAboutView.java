package pers.emery.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @author emery
 */
public abstract class AbstractAboutView extends AbstractView {

    private final JPanel contentPanel;

    protected JButton githubBtn;
    protected JButton seleniumBtn;
    protected JButton chromeDriverBtn;
    protected JLabel tipLabel;
    protected JLabel authorLabel;
    protected JLabel nameLabel;
    protected JPanel imgPanel;
    protected JLabel imgLabel;

    public AbstractAboutView() {
        contentPanel = new JPanel();
        initView();
    }

    @Override
    protected void initView() {
        setSize(680, 400);
        getContentPane().setLayout(new BorderLayout());

        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        githubBtn = new JButton("Github");
        githubBtn.setBounds(493, 80, 150, 35);
        contentPanel.add(githubBtn);

        seleniumBtn = new JButton("Selenium");
        seleniumBtn.setBounds(493, 140, 150, 35);
        contentPanel.add(seleniumBtn);

        chromeDriverBtn = new JButton("Chrome Driver");
        chromeDriverBtn.setBounds(493, 200, 150, 35);
        contentPanel.add(chromeDriverBtn);

        tipLabel = new JLabel("Chrome Driver 下载程序");
        tipLabel.setBounds(30, 15, 455, 45);
        contentPanel.add(tipLabel);

        authorLabel = new JLabel("作者");
        authorLabel.setBounds(568, 268, 75, 30);
        contentPanel.add(authorLabel);

        nameLabel = new JLabel("万义晨");
        nameLabel.setBounds(568, 310, 75, 30);
        contentPanel.add(nameLabel);

        imgPanel = new JPanel();
        imgPanel.setBounds(12, 79, 450, 260);
        contentPanel.add(imgPanel);
        imgPanel.setLayout(new GridLayout(0, 1, 0, 0));

        imgLabel = new JLabel();
        imgPanel.add(imgLabel);
    }

    @Override
    public void showView() {
        setVisible(true);
    }

    /* template method */

    protected void registerAction() {
        github();
        selenium();
        chromeDriver();
    }

    protected abstract void imageLoad();

    protected abstract void github();

    protected abstract void selenium();

    protected abstract void chromeDriver();

}
