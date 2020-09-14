package views.home;

import views.Constant;

import javax.swing.*;
import java.awt.event.ActionListener;

public class JContainerHome extends JPanel {

    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    public JContainerHome(ActionListener actionListener) {
        this.setBackground(Constant.COLOR_WHITE);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {

    }


}
