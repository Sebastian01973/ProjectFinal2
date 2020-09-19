package views;

import controllers.Command;
import views.states.JContainerStates;
import views.home.JContainerHome;
import views.statistic.JContainerStatistic;
import views.table.JContainerTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JCardLayout extends JPanel implements Language {

    private JContainerHome jContainerHome;
    private JContainerTable jContainerTable;
    private JContainerStatistic jContainerStatistic;
    private JContainerStates jContainerStates;
    private CardLayout cardLayout;

    public JCardLayout(ActionListener actionListener) {
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        this.setBackground(Constant.COLOR_WHITE);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
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

        jContainerStates = new JContainerStates(actionListener);
        JScrollPane jspPanelStates = new JScrollPane(jContainerStates);
        jspPanelStates.setViewportView(jContainerStates);
        jspPanelStates.setOpaque(false);
        jspPanelStates.getVerticalScrollBar().setUnitIncrement(20);
        this.add(jspPanelStates,Command.C_MENU_LOCATION.toString());
    }

    public void setDatas(int[] datasx,int[] datasy){
        jContainerStatistic.setDatas(datasx,datasy);
    }

    public void setDatasPie(String[] labels,int[] datas) {
    	jContainerStatistic.setDatasPie(labels, datas);
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

    @Override
    public void changeLanguage() {
        jContainerTable.changeLanguage();
        jContainerStatistic.changeLanguage();
        jContainerStates.changeLanguage();
        jContainerHome.changeLanguage();
    }
}
