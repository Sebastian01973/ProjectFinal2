package views.body;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JContainerBody extends JPanel {

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
}
