package controllers;

import models.*;
import persistence.FileManagerJson;
import utilities.Utilities;
import utilities.UtilitiesViews;
import views.Constant;
import views.JFWindowsMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showMessageDialog;


public class Controller implements ActionListener {

    ManagePatients managePatients;
    ConfigLanguage configLanguage;
    JFWindowsMain jfWindowsMain;
    FileManagerJson fileManagerJson;

    private static final String LOCAL_HOST = "http://localhost/Uptc/Archivo%20json/SurtidoMix.json";


    public Controller() {
        configLanguage = new ConfigLanguage();
        configLanguage.loadConfiguration();
        managePatients = new ManagePatients();
        jfWindowsMain = new JFWindowsMain(this);
        configLanguage.setJfWindowsMain(jfWindowsMain);
        fileManagerJson = new FileManagerJson();
        readFileWebServicesJson();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Command.valueOf(e.getActionCommand())){
            case C_ES_LANGUAGE: this.manageChangeLanguageES(); break;
            case C_US_LANGUAGE: this.manageChangeLanguageUS(); break;
            case C_MENU_HOME: showPanels(Command.C_MENU_HOME.toString());break;
            case C_MENU_TABLE: showPanels(Command.C_MENU_TABLE.toString());break;
            case C_MENU_STATISTIC: showPanels(Command.C_MENU_STATISTIC.toString());break;
            case C_MENU_LOCATION: showPanels(Command.C_MENU_LOCATION.toString());break;
            case C_GRAPHICS_LINE: showGraphics(Command.C_GRAPHICS_LINE.toString()); break;
            case C_GRAPHICS_BAR: showGraphics(Command.C_GRAPHICS_BAR.toString()); break;
            case C_GRAPHICS_TORTE: showGraphics(Command.C_GRAPHICS_TORTE.toString()); break;
            case LOAD_FILE: this.loadFile(); break;
            case SAVE_FILE: this.saveFile(); break;
            case ADD_PATIENT: this.showDialogs(Command.ADD_PATIENT.toString()); break;
            case SEARCH_PATIENT: this.showDialogs(Command.SEARCH_PATIENT.toString()); break;
            case MODIFY_PATIENT: this.showDialogs(Command.MODIFY_PATIENT.toString()); break;
            case DELETE_PATIENT:  break;
            case EXIT_APP: this.exitApp(); break;
            case REFRESH_DATA: this.refreshData(); break;
            case C_CREATE_NEW_PATIENT: this.createDiagnostic(); break;
            case C_CANCEL_NEW_PATIENT: jfWindowsMain.makeInvisibleDialogAddCost(); break;
            case C_ACTIVE_CASES_ADD: break;
            case C_RECOVERED_CASES_ADD:  break;
            case C_DEATH_CASES_ADD:  break;
        }
    }

    private void createDiagnostic() {
        Diagnostic auxDiagnostic = jfWindowsMain.createPatient(managePatients);
        if (auxDiagnostic != null) {
            managePatients.addDiagnostic(auxDiagnostic);
            ArrayList<Object[]> ok = managePatients.getMatrixList();
            jfWindowsMain.addElementToTable(auxDiagnostic.toObjectVector());
        }else {
            showMessageDialog(null, "Hay datos Vacios por favor llenarlos todos");
            showDialogs(Command.ADD_PATIENT.toString());
        }
    }

    public void readFileWebServicesJson(){
        ArrayList<Object[]> arrayObjects = fileManagerJson.readWebService(LOCAL_HOST);
        Utilities.readDatasJson(arrayObjects,managePatients);
    }

    private void showDialogs(String command){
        jfWindowsMain.showDialogs(command);
    }

    private void showGraphics(String command){
        jfWindowsMain.showCardGraphics(command);
    }

    private void showPanels(String command) {
        jfWindowsMain.showPanels(command);
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



    private void exitApp() {
        int option = showConfirmDialog(null, "Deseas salir");
        if (option == 0) {
            System.exit(0);
        }
    }

}
