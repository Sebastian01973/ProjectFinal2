package controllers;

import models.*;
import persistence.FileManagerJson;
import persistence.FilesManager;
import utilities.Utilities;
import views.Constant;
import views.JFWindowsMain;
import utilities.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;

import static javax.swing.JOptionPane.*;


public class Controller implements ActionListener,MouseListener{

    ManagePatients managePatients;
    ConfigLanguage configLanguage;
    JFWindowsMain jfWindowsMain;
    FileManagerJson fileManagerJson;

    private static final String LOCAL_HOST_NAUSAN = "http://localhost/Uptc/Archivo%20json/SurtidoMix.json";
    private static final String LOCAL_HOST_PACHO = "http://localhost/Json/SurtidoMix.json";


    public Controller() {
        configLanguage = new ConfigLanguage();
        configLanguage.loadConfiguration();
        managePatients = new ManagePatients();
        jfWindowsMain = new JFWindowsMain(this,this);
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
            case C_MENU_STATISTIC:showPanels(Command.C_MENU_STATISTIC.toString());
            this.setDatasLine(); break;
            case C_MENU_LOCATION: showPanels(Command.C_MENU_LOCATION.toString());break;
            case C_GRAPHICS_LINE:
                this.setDatasLine();
                showGraphics(Command.C_GRAPHICS_LINE.toString());
                break;
            case C_GRAPHICS_BAR: 
            	this.setDatasBar();
            	showGraphics(Command.C_GRAPHICS_BAR.toString()); break;
            case C_GRAPHICS_TORTE: this.setDatasBar();
                this.setDatasPie();
                this.showGraphics(Command.C_GRAPHICS_TORTE.toString());
                break;
            case C_TABLE_LOCATION: this.tableLocation(); break;
            case SAVE_FILE: this.showDialogFile(true);; break;
            case ADD_PATIENT: this.showDialogs(Command.ADD_PATIENT.toString()); break;
            case SEARCH_PATIENT: this.showDialogs(Command.SEARCH_PATIENT.toString()); break;
            case MODIFY_PATIENT: this.showDialogs(Command.MODIFY_PATIENT.toString()); break;
            case DELETE_PATIENT: this.deletePatient(); break;
            case EXIT_APP: this.exitApp(); break;
            case REFRESH_DATA: this.refreshData(); break;
            case C_CREATE_NEW_PATIENT: this.createDiagnostic(); break;
            case C_FILTER_SEARCH: this.searchFilter(); break;
            case C_CANCEL_NEW_PATIENT: jfWindowsMain.makeInvisibleDialogAddCost(); break;
            case C_ACTIVE_CASES_ADD: break;
            case C_RECOVERED_CASES_ADD:  break;
            case C_DEATH_CASES_ADD:  break;
            case CancelSelection: showDialogFile(false); break;
            case ApproveSelection: saveFile(); break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    	JButton buttonClicked = (JButton) e.getComponent();
    	Departments department = UtilitiesViews.getDptClicked(buttonClicked);
    	int[] count = managePatients.countTotalCases(department);
    	jfWindowsMain.setCountsDpt(department.getKeys(),count);
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
    	// TODO Auto-generated method stub
    	
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
    	// TODO Auto-generated method stub
    	
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
    	// TODO Auto-generated method stub
    	
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
    	// TODO Auto-generated method stub
    	
    }
    
    public void deletePatient() {
        int select = jfWindowsMain.getSelectedRow();
        if (select == -3){
            refreshData();
        }else{
            int option = showConfirmDialog(jfWindowsMain,"Seguro que lo quieres Eliminar");
            if (option == YES_OPTION){
                jfWindowsMain.deleteRowIndex(jfWindowsMain.getSelectRow());
                managePatients.deleteRegister(select);
            }
        }

    }

    private void searchFilter() {
        String auxString = Utilities.getKeyLanguage(jfWindowsMain.getSearchFilter());
        System.out.println(auxString);
        if (auxString != null){
            jfWindowsMain.addElementToTable(managePatients.getMatrixSearchFilter(auxString));
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
        ArrayList<Object[]> arrayObjects = fileManagerJson.readWebService(LOCAL_HOST_PACHO);
        Utilities.readDatasJson(arrayObjects,managePatients);
        refreshData();
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
    
    public void setDatasBar() {
    	int[] datas = managePatients.filterPercentages(managePatients.getPercentagesCases());
    	String[] departments = managePatients.ordenateArray(datas);
    	int[] filterdatas = managePatients.getLimitDatas(datas, 8); 
    	jfWindowsMain.setDatasBar(filterdatas, departments);
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
        int[] values = managePatients.countTotal();
        int cases = values[0];
        int casesRecuperated = values[1];
        int casesDeath = values[2];
        jfWindowsMain.setValues(cases, casesDeath, casesRecuperated);
        jfWindowsMain.setCounts(values);
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
    
    private void showDialogFile(boolean value) {
    	jfWindowsMain.showDialogFiles(value);
    }

    private void saveFile(){
    	showDialogFile(false);
    	String fileName = jfWindowsMain.getFileName();
    	FilesManager.createTypeFile(fileName).writeFile(fileName, managePatients);
    }



    private void exitApp() {
        int option = showConfirmDialog(null, "Deseas salir");
        if (option == 0) {
            System.exit(0);
        }
    }



}
