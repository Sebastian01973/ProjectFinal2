package views.header;

import controllers.Command;
import utilities.Utilities;
import views.Constant;
import views.Language;
import views.models.JModelMenu;
import views.models.JModelMenuItem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class JMainMenu extends JMenuBar implements Language {

    JModelMenu menuFile,menuStadistic,menuPatient;
    JModelMenu menuLanguage;
    JModelMenuItem mILanSpanish,mILanEnglish,mIExit,mILoadFile,mISaveFile,mIRefreshData;
    JModelMenuItem mIAddPatient,mISearchPatient,mIModifyPatient
            ,mIDeletePatient;

    public JMainMenu(ActionListener actionListener) {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBorder(new EmptyBorder(15,10,5,15));
        this.setBackground(Constant.COLOR_GRAY_LIGHT);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        showMenuFile(actionListener);
        showMenuStadistic(actionListener);
        showMenuPatient(actionListener);
    }

    private void showMenuFile(ActionListener actionListener) {

        menuFile = new JModelMenu(Utilities.getKey(Constant.M_FILE),Constant.IMG_FILE,Constant.COLOR_WHITE,Constant.COLOR_BLACK,Constant.FONT_ROCWELL,25,25);

        mILoadFile = new JModelMenuItem(Utilities.getKey(Constant.M_LOAD),Constant.IMG_DOCUMENT,Constant.FONT_HELVETICA_17,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mILoadFile.setActionCommand(Command.LOAD_FILE.toString());
        mILoadFile.addActionListener(actionListener);
        menuFile.add(mILoadFile);

        mISaveFile = new JModelMenuItem(Utilities.getKey(Constant.M_SAVE),Constant.IMG_SAVE,Constant.FONT_HELVETICA_17,20,20,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mISaveFile.setActionCommand(Command.SAVE_FILE.toString());
        mISaveFile.addActionListener(actionListener);
        menuFile.add(mISaveFile);

        mIRefreshData = new JModelMenuItem(Utilities.getKey(Constant.M_REFRESH),Constant.IMG_REFRESH,Constant.FONT_HELVETICA_17,20,20,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mIRefreshData.setActionCommand(Command.REFRESH_DATA.toString());
        mIRefreshData.addActionListener(actionListener);
        menuFile.add(mIRefreshData);

        menuLanguage = new JModelMenu(Utilities.getKey(Constant.M_LANGUAGE),Constant.IMG_WORLD,Constant.COLOR_WHITE,Constant.COLOR_BLACK,Constant.FONT_HELVETICA_17,25,25);

        mILanSpanish = new JModelMenuItem(Utilities.getKey(Constant.M_LANGUAGE_ES),Constant.IMG_SPANISH,Constant.FONT_HELVETICA_17,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mILanSpanish.setActionCommand(Command.C_ES_LANGUAGE.toString());
        mILanSpanish.addActionListener(actionListener);
        menuLanguage.add(mILanSpanish);

        mILanEnglish = new JModelMenuItem(Utilities.getKey(Constant.M_LANGUAGE_US),Constant.IMG_ENGLISH,Constant.FONT_HELVETICA_17,23,23,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mILanEnglish.setActionCommand(Command.C_US_LANGUAGE.toString());
        mILanEnglish.addActionListener(actionListener);
        menuLanguage.add(mILanEnglish);

        menuFile.add(menuLanguage);

        mIExit = new JModelMenuItem(Utilities.getKey(Constant.M_EXIT),Constant.IMG_EXIT_APP,Constant.FONT_HELVETICA_17,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mIExit.setActionCommand(Command.EXIT_APP.toString());
        mIExit.addActionListener(actionListener);
        menuFile.add(mIExit);

        this.add(menuFile);

    }

    private void showMenuStadistic(ActionListener actionListener){
//        menuStadistic = new JModelMenu(Constant.M_FILE,Constant.IMG_FILE,Constant.COLOR_WHITE,Constant.COLOR_BLACK,Constant.FONT_ROCWELL,25,25);
    }

    private void showMenuPatient(ActionListener actionListener){

    }

    @Override
    public void changeLanguage() {
        menuFile.setText(Utilities.getKey(Constant.M_FILE));
        mILoadFile.setText(Utilities.getKey(Constant.M_LOAD));
        mISaveFile.setText(Utilities.getKey(Constant.M_SAVE));
        mIRefreshData.setText(Utilities.getKey(Constant.M_REFRESH));
        menuLanguage.setText(Utilities.getKey(Constant.M_LANGUAGE));
        mILanSpanish.setText(Utilities.getKey(Constant.M_LANGUAGE_ES));
        mILanEnglish.setText(Utilities.getKey(Constant.M_LANGUAGE_US));
        mIExit.setText(Utilities.getKey(Constant.M_EXIT));


    }
}
