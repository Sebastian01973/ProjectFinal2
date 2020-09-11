package views;

import views.body.JContainerBody;
import views.footer.JContainerFooter;
import views.header.JContainerHeader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JMainPanel extends JPanel implements Language{

    private JContainerBody jContainerBody;
    private JContainerHeader jContainerHeater;
    private JContainerFooter jContainerFooter;

    public JMainPanel(ActionListener actionListener) {
        this.setLayout(new BorderLayout(0,0));
        this.setBackground(Constant.COLOR_WHITE);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        jContainerHeater = new JContainerHeader(actionListener);
        this.add(jContainerHeater,BorderLayout.NORTH);

        jContainerBody = new JContainerBody(actionListener);
        this.add(jContainerBody,BorderLayout.CENTER);

        jContainerFooter = new JContainerFooter(actionListener);
        this.add(jContainerFooter,BorderLayout.SOUTH);
    }


    @Override
    public void changeLanguage() {
        jContainerHeater.changeLanguage();
        jContainerBody.changeLanguage();
    }
}
