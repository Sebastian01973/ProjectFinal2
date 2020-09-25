package views;

import models.Diagnostic;
import models.ManagePatients;
import utilities.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import views.dialogs.JContainerDialog;

public class JFWindowsMain extends JFrame implements Language{

    private JMainPanel jMainPanel;
    private JContainerDialog jContainerDialog;


    public JFWindowsMain (ActionListener actionListener,MouseListener mouseL){
        jContainerDialog = new JContainerDialog(actionListener,this);
        this.getContentPane().setBackground(Constant.COLOR_WHITE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setTitle(Utilities.getKey(Constant.APP_TITLE));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon(getClass().getResource(Constant.IMG_ICON_APP)).getImage());
        initComponents(actionListener,mouseL);
        this.setVisible(true);
    }
    
    public void paintP(int x,int y) {
    	 Graphics g=getGraphics();
    	 g.setColor(Color.yellow);
    	 g.fillOval(x, y, 10, 10);
    }

    private void initComponents(ActionListener actionListener,MouseListener mouseL) {

        jMainPanel = new JMainPanel(actionListener,mouseL);
        this.getContentPane().add(jMainPanel,BorderLayout.CENTER);
        this.getContentPane().setForeground(Constant.COLOR_WHITE);
    }

    public String getSearchFilter(){
        return jContainerDialog.getSearchFilter();
    }

    public void deleteRowIndex(int index) {
        jMainPanel.deleteRowIndex(index);
    }

    public int getSelectRow() {
        return jMainPanel.getSelectRow();
    }

    public int getSelectedRow() {
        return jMainPanel.getSelectedRow();
    }

    public void showPanels(String command){
        jMainPanel.showPanels(command);
    }

    public void showCardGraphics(String command){
        jMainPanel.showCardGraphics(command);
    }

    public void showDialogs(String command){
        jContainerDialog.showDialogs(command);
        jContainerDialog.showDialogAdd();
        jContainerDialog.setVisible(true);
    }
    
    public void showDialogFiles(boolean isVisible) {
    	this.jMainPanel.showFileChooser(isVisible);
    }
    
    public String getFileName() {
    	return jMainPanel.getFileName();
    }

    public Diagnostic createPatient(ManagePatients managePatients) {
        return jContainerDialog.createPatient(managePatients,this);
    }

    public void setDatas(int[] datasx,int[] datasy){
        jMainPanel.setDatas(datasx,datasy);
    }

    public void setDatasPie(double[] datas,String[] labels) {
    	jMainPanel.setDatasPie( datas, labels);
    }
    
    public void setDatasBar(int[] datas,String[] labelsDt) {
    	jMainPanel.setDatasBar(datas, labelsDt);
    }
    
    public void setValues(int cases, int casesDeath,int casesRecuperated) {
    	jMainPanel.setValues(cases, casesDeath, casesRecuperated);
    }
    public void addElementToTable(ArrayList<Object[]> matrix,String[] header){
        jMainPanel.addElementToTable(matrix,header);
    }

    public void addElementToTable(Object[] objects){
        jMainPanel.addElementToTable(objects);
    }

    public void addElementToTable(ArrayList<Object[]> matrix){
        jMainPanel.addElementToTable(matrix);
    }
    
    public void setCounts(int...cases) {
    	jMainPanel.setCounts(cases);
    }
    
    public void setCountsDpt(String location,int...values) {
    	this.jMainPanel.setCountsDpt(location,values);
    }

    @Override
    public void changeLanguage() {
        this.setTitle(Utilities.getKey(Constant.APP_TITLE));
        jContainerDialog.changeLanguage();
        jMainPanel.changeLanguage();
    }

    public void makeInvisibleDialogAddCost() {
        jContainerDialog.setVisible(false);
    }
}
