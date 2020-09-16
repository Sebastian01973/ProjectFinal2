package views.statistic;

import views.Constant;
import views.Language;

import javax.swing.*;
import java.awt.event.ActionListener;

public class JPanelRight extends JPanel implements Language {
    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    public JPanelRight(ActionListener actionListener) {
        initComponents(actionListener);
        this.setBackground(Constant.COLOR_BLACK);
    }

    private void initComponents(ActionListener actionListener) {

    }

    @Override
    public void changeLanguage() {

    }
}
