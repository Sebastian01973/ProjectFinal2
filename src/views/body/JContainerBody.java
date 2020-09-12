package views.body;

import views.Language;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JContainerBody extends JPanel implements Language {

    JContainerTable jContainerTable;
    JTableEast jTableEast;

    public JContainerBody(ActionListener actionListener) {
        this.setLayout(new BorderLayout(0,0));
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        jContainerTable = new JContainerTable(actionListener);
        this.add(jContainerTable,BorderLayout.CENTER);

    }

    public void addElementToTable(Object[] objects){
        jContainerTable.addElementToTable(objects);
    }

    public void addElementToTable(ArrayList<Object[]> matrix){
        jContainerTable.addElementToTable(matrix);
    }

    @Override
    public void changeLanguage() {
        jContainerTable.changeLanguage();
    }
}
