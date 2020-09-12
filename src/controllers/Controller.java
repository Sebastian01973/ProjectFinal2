package controllers;

import models.ManagePatients;
import views.JFWindowsMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showConfirmDialog;


public class Controller implements ActionListener {

    ManagePatients managePatients;
    ConfigLanguage configLanguage;
    JFWindowsMain jfWindowsMain;



    public Controller() {
        configLanguage = new ConfigLanguage();
        configLanguage.loadConfiguration();
        managePatients = new ManagePatients();
        jfWindowsMain = new JFWindowsMain(this);
        configLanguage.setJfWindowsMain(jfWindowsMain);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Command.valueOf(e.getActionCommand())){
            case C_ES_LANGUAGE: this.manageChangeLanguageES(); break;
            case C_US_LANGUAGE: this.manageChangeLanguageUS(); break;
            case LOAD_FILE: this.loadFile(); break;
            case SAVE_FILE: this.saveFile(); break;
            case ADD_PATIENT: this.addPatient(); break;
            case SEARCH_PATIENT: this.searchPatient(); break;
            case MODIFY_PATIENT: this.modifyPatient(); break;
            case DELETE_PATIENT: this.deletePatient(); break;
            case EXIT_APP: this.exitApp(); break;
            case REFRESH_DATA: this.refreshData(); break;
        }
    }

    private void refreshData() {
        jfWindowsMain.addElementToTable(managePatients.getMatrixList());
    }

    private void manageChangeLanguageUS() {
        configLanguage.manageChangeLanguageUS();
    }

    private void manageChangeLanguageES() {
        configLanguage.manageChangeLanguageES();
    }

    private void loadFile() {

    }

    private void saveFile(){

    }

    private void addPatient(){


    }

    private void searchPatient(){

    }

    private void modifyPatient(){

    }

    private void deletePatient(){

    }

    private void exitApp() {
        int option = showConfirmDialog(null, "Deseas salir");
        if (option == 0) {
            System.exit(0);
        }
    }

}
