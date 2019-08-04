package pers.emery.view;

import pers.emery.util.FontFactory;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Enumeration;


public abstract class AbstractView extends JFrame {

    public AbstractView() {

        // theme
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        try {
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException | IllegalAccessException e) {
            /* do nothing. use java default */
        }

        // font
        setDefaultFont();

        // default setting
        // this.setResizable(false);
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setDefaultFont() {
        Font font = FontFactory.getFontBySize(18);
        FontUIResource fontResource = new FontUIResource(font);
        Enumeration<Object> keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if(value instanceof FontUIResource) {
                UIManager.put(key, fontResource);
            }
        }
    }


    /* abstract method */

//    public abstract void initGUI();

}
