package views.header;

import utilities.Utilities;
import views.Constant;
import views.Language;
import views.models.JModelMenu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionListener;

public class JMainMenu extends JMenuBar implements Language {

    JModelMenu menuHome, menuTable, menuStatistic,menuAbout;

    public JMainMenu(ActionListener actionListener) {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBorder(new EmptyBorder(15,10,5,15));
        this.setBackground(Constant.COLOR_GRAY_LIGHT);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {

        menuHome = new JModelMenu(Utilities.getKey(Constant.M_FILE),Constant.IMG_FILE,Constant.COLOR_WHITE,Constant.COLOR_BLACK,Constant.FONT_ROCWELL,25,25);

        menuTable = new JModelMenu(Utilities.getKey(Constant.M_STATISTICS),Constant.IMG_STADISTIC,Constant.COLOR_WHITE,Constant.COLOR_BLACK,Constant.FONT_ROCWELL,25,25);
        this.add(menuTable);

        menuStatistic = new JModelMenu(Utilities.getKey(Constant.M_PATIENT),Constant.IMG_USER,Constant.COLOR_WHITE,Constant.COLOR_BLACK,Constant.FONT_ROCWELL,25,25);
        this.add(menuStatistic);

        menuAbout = new JModelMenu(Utilities.getKey(Constant.M_ABOUT),Constant.IMG_ABOUT,Constant.COLOR_WHITE,Constant.COLOR_BLACK,Constant.FONT_ROCWELL,25,25);
        this.add(menuAbout);
    }

    @Override
    public void changeLanguage() {
        menuHome.setText(Utilities.getKey(Constant.M_FILE));

        menuTable.setText(Utilities.getKey(Constant.M_STATISTICS));

        menuStatistic.setText(Utilities.getKey(Constant.M_PATIENT));

        menuAbout.setText(Utilities.getKey(Constant.M_ABOUT));
    }
}
