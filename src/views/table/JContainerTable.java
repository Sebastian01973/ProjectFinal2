package views.table;

import views.Language;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JContainerTable extends JPanel implements Language {

    JPanelTable jPanelTable;
    JTableEast jTableEast;

    public JContainerTable(ActionListener actionListener) {
        this.setLayout(new BorderLayout(0,0));
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        jPanelTable = new JPanelTable(actionListener);
        this.add(jPanelTable,BorderLayout.CENTER);

        jTableEast = new JTableEast(actionListener);
        this.add(jTableEast,BorderLayout.EAST);
    }

    public void addElementToTable(Object[] objects){
        jPanelTable.addElementToTable(objects,true);
    }

    public void addElementToTable(ArrayList<Object[]> matrix){
        jPanelTable.addElementToTable(matrix);
    }

    public void addElementToTable(ArrayList<Object[]> matrix,String[] header){
        jPanelTable.addElementToTable(matrix,header);
    }

    @Override
    public void changeLanguage() {
        jPanelTable.changeLanguage();
        jTableEast.changeLanguage();
    }
}
