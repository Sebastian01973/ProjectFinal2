package views.header;

import controllers.Command;
import utilities.Utilities;
import views.Constant;
import views.Language;
import views.models.JModelMenuItem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionListener;

public class JMainMenu extends JMenuBar implements Language {

    JModelMenuItem menuHome, menuTable, menuStatistic,menuAbout;
    public JMainMenu(ActionListener actionListener) {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBorder(new EmptyBorder(15,10,5,15));
        this.setBackground(Constant.COLOR_WHITE);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {

        menuHome = new JModelMenuItem(Utilities.getKey(Constant.M_HOME),Constant.IMG_HOME,Constant.FONT_ROCWELL,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        menuHome.setActionCommand(Command.C_MENU_HOME.toString());
        menuHome.addActionListener(actionListener);
        this.add(menuHome);

        menuTable = new JModelMenuItem(Utilities.getKey(Constant.M_TABLE),Constant.IMG_TABLE1,Constant.FONT_ROCWELL,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        menuTable.setActionCommand(Command.C_MENU_TABLE.toString());
        menuTable.addActionListener(actionListener);
        this.add(menuTable);

        menuStatistic = new JModelMenuItem(Utilities.getKey(Constant.M_STATISTICS),Constant.IMG_STADISTIC,Constant.FONT_ROCWELL,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        menuStatistic.setActionCommand(Command.C_MENU_STATISTIC.toString());
        menuStatistic.addActionListener(actionListener);
        this.add(menuStatistic);

        menuAbout = new JModelMenuItem(Utilities.getKey(Constant.M_ABOUT),Constant.IMG_ABOUT,Constant.FONT_ROCWELL,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        menuAbout.setActionCommand(Command.C_MENU_ABOUT.toString());
        menuAbout.addActionListener(actionListener);
        this.add(menuAbout);

    }

    @Override
    public void changeLanguage() {
        menuHome.setText(Utilities.getKey(Constant.M_HOME));

        menuTable.setText(Utilities.getKey(Constant.M_TABLE));

        menuStatistic.setText(Utilities.getKey(Constant.M_STATISTICS));

        menuAbout.setText(Utilities.getKey(Constant.M_ABOUT));
    }
}
