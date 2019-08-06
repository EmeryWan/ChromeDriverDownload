package pers.emery.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @author emery
 */
public abstract class AbstractMainView extends AbstractView {

    protected JPanel contentPane;

    protected DownloadPanel downloadPanel;
    protected JPanel proxyPanel;

    protected CardLayout cardLayout;

    public AbstractMainView() {
        initView();
    }

    @Override
    protected void initView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(950, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        cardLayout = new CardLayout(0, 0);
        contentPane.setLayout(cardLayout);

        downloadPanel = new DownloadPanel();
        contentPane.add(downloadPanel, "downloadPanel");
    }

    @Override
    public void showView() {
        setVisible(true);
    }

}
