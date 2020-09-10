package views;

import utilities.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JFWindowsMain extends JFrame implements Language{

    JMainPanel jMainPanel;

    public JFWindowsMain (ActionListener actionListener){
        this.getContentPane().setBackground(Constant.COLOR_WHITE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setTitle(Utilities.getKey(Constant.APP_TITLE));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon(getClass().getResource(Constant.IMG_ICON_APP)).getImage());
        initComponents(actionListener);
        this.setVisible(true);
    }

    private void initComponents(ActionListener actionListener) {
        jMainPanel = new JMainPanel(actionListener);
        this.getContentPane().add(jMainPanel, BorderLayout.CENTER);
    }


    @Override
    public void changeLanguage() {
        this.setTitle(Utilities.getKey(Constant.APP_TITLE));
    }
}
