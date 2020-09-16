package views.dialogs;

import com.toedter.calendar.JDateChooser;
import utilities.Utilities;
import views.Constant;
import views.JFWindowsMain;
import views.Language;
import views.models.JModelPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JDialogAddPatient extends JDialog implements Language {

    private JModelPanel jpanel;
    private JSpinner jsAge;
    private JDateChooser jDateChooser;
    private JButton jBCreate,jBCancel;


    public JDialogAddPatient(ActionListener actionListener, JFWindowsMain jfWindowsMain) {
        this.setModal(true);
        setTitle("");
        setIconImage( new ImageIcon(getClass().getResource( Constant.IMG_ADD_USER)).getImage());
        this.getContentPane().setBackground(Constant.COLOR_WHITE);
        this.setSize(new Dimension(500, 650));
        this.setLocationRelativeTo(jfWindowsMain);
        initComponents(actionListener);


    }



    private void initComponents(ActionListener actionListener) {
    }

    @Override
    public void changeLanguage() {

    }
}
