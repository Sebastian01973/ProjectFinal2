package views;

import utilities.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import com.toedter.calendar.JDateChooser;

public class JFWindowsMain extends JFrame implements Language{

    private JMainPanel jMainPanel;


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
        JScrollPane jspPanel = new JScrollPane(jMainPanel);
        jspPanel.setViewportView(jMainPanel);
        jspPanel.setOpaque(false);
        jspPanel.getVerticalScrollBar().setUnitIncrement(10);
        this.getContentPane().add(jspPanel,BorderLayout.CENTER);
        this.getContentPane().setForeground(Constant.COLOR_WHITE);
    }

    public void showPanels(String command){
        jMainPanel.showPanels(command);
    }

    public void showCardGraphics(String command){
        jMainPanel.showCardGraphics(command);
    }

    public void addElementToTable(Object[] objects){
        jMainPanel.addElementToTable(objects);
    }

    public void addElementToTable(ArrayList<Object[]> matrix){
        jMainPanel.addElementToTable(matrix);
    }

    @Override
    public void changeLanguage() {
        this.setTitle(Utilities.getKey(Constant.APP_TITLE));
        jMainPanel.changeLanguage();
    }
}
