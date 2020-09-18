package views.dialogs;

import com.toedter.calendar.JDateChooser;
import models.*;
import utilities.Utilities;
import views.Constant;
import views.JFWindowsMain;
import views.Language;
import views.models.JModelComboBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JContainerDialog extends JDialog implements Language {

    private JPanel jPanel;
    private JPNorthdialog jpNorthdialog;
    private JCardDialogs jCardDialogs;


    public JContainerDialog(ActionListener actionListener, JFWindowsMain jfWindowsMain) {
        this.setModal(true);
        setTitle(Utilities.getKey(Constant.L_DIALOG));
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setIconImage( new ImageIcon(getClass().getResource( Constant.IMG_DIALOG)).getImage());
        this.getContentPane().setBackground(Constant.COLOR_WHITE);
        this.setSize(new Dimension(450, 700));
        this.setResizable(false);
        this.setLocationRelativeTo(jfWindowsMain);
        initComponents(actionListener);
    }



    private void initComponents(ActionListener actionListener) {
        jPanel = new JPanel();
        jPanel.setBackground(Constant.COLOR_WHITE);
        jPanel.setLayout(new BorderLayout(0,0));

        jpNorthdialog = new JPNorthdialog(actionListener);
        jPanel.add(jpNorthdialog,BorderLayout.NORTH);

        jCardDialogs = new JCardDialogs(actionListener);
        jPanel.add(jCardDialogs,BorderLayout.CENTER);

        this.add(jPanel);
    }

    public void showDialogs(String command){
        jCardDialogs.showDialogs(command);
    }

    public void showDialogAdd() {
        jCardDialogs.showDialogAdd();
    }

    public Diagnostic createPatient(ManagePatients managePatients, JFWindowsMain jfWindowsMain) {
        this.setVisible(false);
        return jCardDialogs.createPatient(managePatients,jfWindowsMain);
    }

    @Override
    public void changeLanguage() {
        this.setTitle(Utilities.getKey(Constant.L_DIALOG));
        jCardDialogs.changeLanguage();
    }
}
