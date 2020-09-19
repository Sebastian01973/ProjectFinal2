package views;

import models.Diagnostic;
import models.ManagePatients;
import utilities.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import views.dialogs.JContainerDialog;

public class JFWindowsMain extends JFrame implements Language{

    private JMainPanel jMainPanel;
    private JContainerDialog jContainerDialog;


    public JFWindowsMain (ActionListener actionListener){
        jContainerDialog = new JContainerDialog(actionListener,this);
        this.getContentPane().setBackground(Constant.COLOR_WHITE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setTitle(Utilities.getKey(Constant.APP_TITLE));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon(getClass().getResource(Constant.IMG_ICON_APP)).getImage());
        initComponents(actionListener);
        this.setVisible(true);
    }

    private void initComponents(ActionListener actionListener) {

        jMainPanel = new JMainPanel(actionListener);
        this.getContentPane().add(jMainPanel,BorderLayout.CENTER);
        this.getContentPane().setForeground(Constant.COLOR_WHITE);
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

    public Diagnostic createPatient(ManagePatients managePatients) {
        return jContainerDialog.createPatient(managePatients,this);
    }

    public void setDatas(int[] datasx,int[] datasy){
        jMainPanel.setDatas(datasx,datasy);
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
