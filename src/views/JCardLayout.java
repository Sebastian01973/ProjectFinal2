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
        JScrollPane jspPanel = new JScrollPane(jContainerHome);
        jspPanel.setViewportView(jContainerHome);
        jspPanel.setOpaque(false);
        jspPanel.getVerticalScrollBar().setUnitIncrement(10);
        this.add(jspPanel,Command.C_MENU_HOME.toString());

        jContainerTable = new JContainerTable(actionListener);
        this.add(jContainerTable, Command.C_MENU_TABLE.toString());

        jContainerStatistic = new JContainerStatistic(actionListener);
        this.add(jContainerStatistic,Command.C_MENU_STATISTIC.toString());

        jContainerStates = new JContainerStates(actionListener);
        this.add(jContainerStates,Command.C_MENU_ABOUT.toString());
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
    }
}
