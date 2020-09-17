package views.states;

import views.Constant;
import views.Language;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JContainerStates extends JPanel implements Language {

    private JNorthState jNorthState;
    private JCenterState jCenterPanel;

    public JContainerStates(ActionListener actionListener) {
        this.setBackground(Constant.COLOR_WHITE);
        this.setLayout(new BorderLayout());
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        jNorthState = new JNorthState(actionListener);
        this.add(jNorthState,BorderLayout.NORTH);

        jCenterPanel = new JCenterState(actionListener);
        this.add(jCenterPanel,BorderLayout.CENTER);
    }

    @Override
    public void changeLanguage() {
        jNorthState.changeLanguage();
    }
}
