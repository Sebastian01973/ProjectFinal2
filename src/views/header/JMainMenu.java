package views.header;

import views.Constant;
import views.Language;
import views.models.JModelMenu;
import views.models.JModelMenuItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JMainMenu extends JMenuBar implements Language {

    JModelMenu menuFile,menuStadistic,menuPatient;
    JModelMenu menuLanguage;
    JModelMenuItem mILanSpanish,mILanEnglish,mIExit,mILoadFile,mISaveFile;
    JModelMenuItem mIAddPatient,mISearchPatient,mIModifyPatient
            ,mIDeletePatient;

    public JMainMenu(ActionListener actionListener) {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBackground(Constant.COLOR_WHITE);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        showMenuFile(actionListener);
        showMenuStadistic(actionListener);
        showMenuPatient(actionListener);
        showMenuLanguage(actionListener);
    }

    private void showMenuFile(ActionListener actionListener) {
        menuFile = new JModelMenu(Constant.M_FILE,Constant.COLOR_WHITE,Constant.COLOR_BLACK,Constant.FONT_HELVETICA_17);



    }

    private void showMenuStadistic(ActionListener actionListener){

    }

    private void showMenuPatient(ActionListener actionListener){

    }

    private void showMenuLanguage(ActionListener actionListener) {
    }

    @Override
    public void changeLanguage() {

    }
}