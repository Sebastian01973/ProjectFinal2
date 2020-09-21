package views.states;

import views.Constant;
import views.Language;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;

public class JContainerStates extends JPanel implements Language {

    private JNorthState jNorthState;
    private JCenterState jCenterPanel;

    public JContainerStates(ActionListener actionListener,MouseListener mouseL) {
        this.setBackground(Constant.COLOR_WHITE);
        this.setLayout(new BorderLayout());
        initComponents(actionListener, mouseL);
    }

    private void initComponents(ActionListener actionListener ,MouseListener mouseL) {
        jNorthState = new JNorthState(actionListener);
        this.add(jNorthState,BorderLayout.NORTH);

        jCenterPanel = new JCenterState(actionListener,mouseL);
        this.add(jCenterPanel,BorderLayout.CENTER);
    }

    @Override
    public void changeLanguage() {
        jNorthState.changeLanguage();
    }
    
    public void setCountsDep(String location,int...values) {
    	this.jNorthState.setValues(location,values);
    }
}
