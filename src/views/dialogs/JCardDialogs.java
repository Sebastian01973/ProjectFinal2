package views.dialogs;

import controllers.Command;
import models.Diagnostic;
import models.ManagePatients;
import views.Constant;
import views.JCardLayout;
import views.JFWindowsMain;
import views.Language;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JCardDialogs extends JPanel implements Language {

    private CardLayout cardLayout;
    private JDialogAddPatient jDialogAddPatient;
    private JDialogModifyPatient jDialogModifyPatient;

    public JCardDialogs(ActionListener actionListener) {
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        this.setBackground(Constant.COLOR_PURPLE);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        jDialogAddPatient = new JDialogAddPatient(actionListener);
        this.add(jDialogAddPatient, Command.ADD_PATIENT.toString());

        jDialogModifyPatient = new JDialogModifyPatient(actionListener);
        this.add(jDialogModifyPatient,Command.MODIFY_PATIENT.toString());
    }

    public void showDialogs(String command){
        cardLayout.show(this,command);
    }

    public void showDialogAdd() {
        jDialogAddPatient.showDialogAdd();
    }

    public Diagnostic createPatient(ManagePatients managePatients, JFWindowsMain jfWindowsMain) {
        return jDialogAddPatient.createPatient(managePatients,jfWindowsMain);
    }

    @Override
    public void changeLanguage() {
        jDialogAddPatient.changeLanguage();
        jDialogModifyPatient.changeLanguage();
    }
}
