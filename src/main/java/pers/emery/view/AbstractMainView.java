package pers.emery.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public abstract class AbstractMainView extends AbstractView {

    private JPanel contentPane;
    private JPanel downloadPanel;

    public AbstractMainView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 950, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout(0, 0));

        init();
    }

    private void init() {
        downloadPanel = new DownloadPanel();
        contentPane.add(downloadPanel, "downloadPanel");
    }

}
