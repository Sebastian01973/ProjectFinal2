package controllers;

import persistence.HandlerLanguage;
import views.Constant;
import views.JFWindowsMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static javax.swing.JOptionPane.showMessageDialog;

public class Controller implements ActionListener {

    //models
    ConfigLanguage configLanguage;
    JFWindowsMain jfWindowsMain;



    public Controller() {
        configLanguage = new ConfigLanguage();
        configLanguage.loadConfiguration();
        jfWindowsMain = new JFWindowsMain(this);
        configLanguage.setJfWindowsMain(jfWindowsMain);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Command.valueOf(e.getActionCommand())){
            case C_ES_LANGUAGE: this.manageChangeLanguageES(); break;
            case C_US_LANGUAGE: this.manageChangeLanguageUS(); break;
        }
    }

    private void manageChangeLanguageUS() {
        configLanguage.manageChangeLanguageUS();
    }

    private void manageChangeLanguageES() {
        configLanguage.manageChangeLanguageES();
    }


}
