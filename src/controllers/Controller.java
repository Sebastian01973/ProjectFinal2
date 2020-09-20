package controllers;

import models.*;
import persistence.BinaryFileManager;
import persistence.ConstantsPersistence;
import persistence.FileManagerJson;
import persistence.XMLFileManager;
import persistence.TextFileManager;
import utilities.Utilities;
import views.Constant;
import views.JFWindowsMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showMessageDialog;


public class Controller implements ActionListener {

    ManagePatients managePatients;
    ConfigLanguage configLanguage;
    JFWindowsMain jfWindowsMain;
    FileManagerJson fileManagerJson;
    XMLFileManager xmlFileManager;
    TextFileManager textFileManager;
    BinaryFileManager binaryFileManager;

    private static final String LOCAL_HOST_NAUSAN = "http://localhost/Uptc/Archivo%20json/SurtidoMix.json";
    private static final String LOCAL_HOST_PACHO = "http://localhost/Json/SurtidoMix.json";


    public Controller() {
        configLanguage = new ConfigLanguage();
        configLanguage.loadConfiguration();
        managePatients = new ManagePatients();
        jfWindowsMain = new JFWindowsMain(this);
        configLanguage.setJfWindowsMain(jfWindowsMain);
        fileManagerJson = new FileManagerJson();
        this.xmlFileManager = new XMLFileManager();
        textFileManager = new TextFileManager();
        binaryFileManager = new BinaryFileManager();
        readFileWebServicesJson();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Command.valueOf(e.getActionCommand())){
            case C_ES_LANGUAGE: this.manageChangeLanguageES(); break;
            case C_US_LANGUAGE: this.manageChangeLanguageUS(); break;
            case C_MENU_HOME: showPanels(Command.C_MENU_HOME.toString());break;
            case C_MENU_TABLE: showPanels(Command.C_MENU_TABLE.toString());break;
            case C_MENU_STATISTIC:showPanels(Command.C_MENU_STATISTIC.toString());
            this.setDatasLine(); break;
            case C_MENU_LOCATION: showPanels(Command.C_MENU_LOCATION.toString());break;
            case C_GRAPHICS_LINE:
                this.setDatasLine();
                showGraphics(Command.C_GRAPHICS_LINE.toString());
                break;
            case C_GRAPHICS_BAR: showGraphics(Command.C_GRAPHICS_BAR.toString()); break;
            case C_GRAPHICS_TORTE: 
            showGraphics(Command.C_GRAPHICS_TORTE.toString()); break;
            case C_TABLE_LOCATION: this.tableLocation(); break;
            case SAVE_FILE: this.saveFile(); break;
            case ADD_PATIENT: this.showDialogs(Command.ADD_PATIENT.toString()); break;
            case SEARCH_PATIENT: this.showDialogs(Command.SEARCH_PATIENT.toString()); break;
            case MODIFY_PATIENT: this.showDialogs(Command.MODIFY_PATIENT.toString()); break;
            case DELETE_PATIENT:  break;
            case EXIT_APP: this.exitApp(); break;
            case REFRESH_DATA: this.refreshData(); break;
            case C_CREATE_NEW_PATIENT: this.createDiagnostic(); break;
            case C_FILTER_SEARCH: this.searchFilter(); break;
            case C_CANCEL_NEW_PATIENT: jfWindowsMain.makeInvisibleDialogAddCost(); break;
            case C_ACTIVE_CASES_ADD: break;
            case C_RECOVERED_CASES_ADD:  break;
            case C_DEATH_CASES_ADD:  break;
        }
    }

    private void searchFilter() {
        String auxString = Utilities.getKeyLanguage(jfWindowsMain.getSearchFilter());
        System.out.println(auxString);
        if (auxString != null){
            jfWindowsMain.addElementToTable(managePatients.getMatrixSearchDeps(auxString));
        }else{
            showDialogs(Command.SEARCH_PATIENT.toString());
        }
    }

    private void createDiagnostic() {
        Diagnostic auxDiagnostic = jfWindowsMain.createPatient(managePatients);
        if (auxDiagnostic != null) {
            managePatients.addDiagnostic(auxDiagnostic);
            ArrayList<Object[]> ok = managePatients.getMatrixList();
            jfWindowsMain.addElementToTable(auxDiagnostic.toObjectVector());
        }else {
            showDialogs(Command.ADD_PATIENT.toString());
        }
    }

    public void readFileWebServicesJson(){
        ArrayList<Object[]> arrayObjects = fileManagerJson.readWebService(LOCAL_HOST_NAUSAN);
        Utilities.readDatasJson(arrayObjects,managePatients);
        refreshData();
        Departments[] deps = managePatients.filterPercentages(managePatients.getPercentagesCases());
        for (int i = 0; i < deps.length; i++) {
			System.out.println(deps[i].getKeys() + managePatients.calCases(deps[i]));
		}
    }

    public void setDatasLine(){
    	int[] months = managePatients.getMonths();
    	int[] cases = managePatients.getCasesMonth();
        jfWindowsMain.setDatas(months,cases);
    }
    
    public void setDatasPie() {
    	int[] datas = managePatients.getPercentagesAges();
    	jfWindowsMain.setDatasPie( datas);
    }

    public void setDatas(int[] datasX,int[] datasy){
        jfWindowsMain.setDatas(datasX,datasy);
    }

    private void showDialogs(String command){
        jfWindowsMain.showDialogs(command);
    }

    private void showGraphics(String command){
        jfWindowsMain.showCardGraphics(command);
    }

    private void showPanels(String command) {
        jfWindowsMain.showPanels(command);
        setDatasLine();
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

    private void tableLocation() {
        ArrayList<Object[]> tableDepar = managePatients.getDatasDepartaments();
       jfWindowsMain.addElementToTable(tableDepar, Constant.TABLE_DEPS);
    }

    private void saveFile(){
        fileManagerJson.writeFile(ConstantsPersistence.PATH_OUT+"ArchivoJson."+ConstantsPersistence.E_JSON,managePatients);
        textFileManager.writeFile(ConstantsPersistence.PATH_OUT+"ArchivoPlano."+ConstantsPersistence.E_TXT,managePatients);
        binaryFileManager.writeFile(ConstantsPersistence.PATH_OUT+"ArchivoBynario."+ConstantsPersistence.E_BIN,managePatients);
    }



    private void exitApp() {
        int option = showConfirmDialog(null, "Deseas salir");
        if (option == 0) {
            System.exit(0);
        }
    }

}
