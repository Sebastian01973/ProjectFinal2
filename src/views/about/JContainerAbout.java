package views.about;

import views.Constant;

import javax.swing.*;
import java.awt.event.ActionListener;

public class JContainerAbout extends JPanel {

    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    public JContainerAbout(ActionListener actionListener) {
        this.setBackground(Constant.COLOR_GREEN_SOFT);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
    }
}
