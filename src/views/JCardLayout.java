package views;

import controllers.Command;
import views.states.JContainerStates;
import views.home.JContainerHome;
import views.statistic.JContainerStatistic;
import views.table.JContainerTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class JCardLayout extends JPanel implements Language {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JContainerHome jContainerHome;
    private JContainerTable jContainerTable;
    private JContainerStatistic jContainerStatistic;
    private JContainerStates jContainerStates;
    private CardLayout cardLayout;

    public JCardLayout(ActionListener actionListener,MouseListener mouseL) {
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        this.setBackground(Constant.COLOR_WHITE);
        initComponents(actionListener,mouseL);
    }

    private void initComponents(ActionListener actionListener,MouseListener mouseL) {
        jContainerHome = new JContainerHome(actionListener);
        JScrollPane jspPanelHome = new JScrollPane(jContainerHome);
        jspPanelHome.setViewportView(jContainerHome);
        jspPanelHome.setOpaque(false);
        jspPanelHome.getVerticalScrollBar().setUnitIncrement(10);
        this.add(jspPanelHome,Command.C_MENU_HOME.toString());

        jContainerTable = new JContainerTable(actionListener);
        this.add(jContainerTable, Command.C_MENU_TABLE.toString());

        jContainerStatistic = new JContainerStatistic(actionListener);
        this.add(jContainerStatistic,Command.C_MENU_STATISTIC.toString());

        jContainerStates = new JContainerStates(actionListener,mouseL);
        JScrollPane jspPanelStates = new JScrollPane(jContainerStates);
        jspPanelStates.setViewportView(jContainerStates);
        jspPanelStates.setOpaque(false);
        jspPanelStates.getVerticalScrollBar().setUnitIncrement(20);
        this.add(jspPanelStates,Command.C_MENU_LOCATION.toString());
    }

    public int getSelectRow() {
        return jContainerTable.getSelectRow();
    }

    public int getSelectedRow() {
        return jContainerTable.getSelectedRow();
    }

    public void deleteRowIndex(int index) {
        jContainerTable.deleteRowIndex(index);
    }

    public void setDatas(int[] datasx,int[] datasy){
        jContainerStatistic.setDatas(datasx,datasy);
    }

    public void setDatasPie(double[] datas,String[] labels) {
    	jContainerStatistic.setDatasPie(datas,labels);
    }
    
    public void setDatasBar(int[] datas,String[] labelsDt) {
    	jContainerStatistic.setDatasBar(datas, labelsDt);
    }
    
    public void showPanels(String command){
        cardLayout.show(this,command);
    }

    public void addElementToTable(ArrayList<Object[]> matrix) {
        jContainerTable.addElementToTable(matrix);
    }

    public void addElementToTable(Object[] objects) {
        jContainerTable.addElementToTable(objects);
    }

    public void showCardGraphics(String command){
        jContainerStatistic.showCardGraphics(command);
    }

    public void addElementToTable(ArrayList<Object[]> matrix,String[] header){
        jContainerTable.addElementToTable(matrix,header);
    }
    
    public void setValues(int cases,int casesDeath,int casesRecuperated) {
    	jContainerHome.setValues(cases, casesDeath, casesRecuperated);
    }
    
    public void setCounts(int...cases) {
    	jContainerStatistic.setCounts( cases);
    }
    
    public void setCountsDpt(String location,int...values) {
    	this.jContainerStates.setCountsDep(location,values);
    }

    @Override
    public void changeLanguage() {
        jContainerTable.changeLanguage();
        jContainerStatistic.changeLanguage();
        jContainerStates.changeLanguage();
        jContainerHome.changeLanguage();
    }
}
