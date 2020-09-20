package views.dialogs;

import com.toedter.calendar.JDateChooser;
import controllers.Command;
import models.*;
import utilities.Utilities;
import views.Constant;
import views.JFWindowsMain;
import views.Language;
import views.models.JModelButton;
import views.models.JModelComboBox;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatter;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class JDialogAddPatient extends JPanel implements Language {
    private JPanel jPSouth,jPCenter;

    private JModelButton diagnostic,recovered,death;

    private JModelComboBox<Gender> jCBGender;
    private JSpinner jsAge;
    private JModelComboBox<Attention> jCBAttention;
    private JModelComboBox<Departments> jCBDepartments;
    private JModelComboBox<HealthCondition> jCBHEalth;
    private JDateChooser jDatediagnostic,jDateDeath,jDateRecovered;
    private JButton jBCreate,jBCancel;


    public JDialogAddPatient(ActionListener actionListener) {
        this.setBackground(Constant.COLOR_WHITE);
        this.setLayout(new BorderLayout());
        initComponents(actionListener);
    }


    private void initComponents(ActionListener actionListener) {
        jPCenter = new JPanel();
        GridLayout gridLayout = new GridLayout(10,1);
        jPCenter.setLayout(gridLayout);
        gridLayout.setVgap(15);
        jPCenter.setBorder(new EmptyBorder(10,20,10,20));
        jPCenter.setBackground(Constant.COLOR_WHITE);
        initCenter(actionListener);
        jPSouth = new JPanel();
        jPSouth.setLayout(new FlowLayout(FlowLayout.CENTER));
        jPSouth.setBackground(Constant.COLOR_BLUE_LIGHT_G);
        initSouth(actionListener);
    }

    public void showDialogAdd() {
        jDateRecovered.setDate(null);
        jDateDeath.setDate(null);
        jDatediagnostic.setDate(null);
    }

    private  void initCenter(ActionListener actionListener){
        jCBGender = new JModelComboBox<Gender>(Utilities.getKeys(Gender.values()),Utilities.getKey(Constant.L_GENDER),Constant.FONT_HELVETICA_17);
        jPCenter.add(jCBGender);

        jsAge = new JSpinner(new SpinnerNumberModel(1, 0, 130, 1));
        ((DefaultFormatter) ((JSpinner.NumberEditor)jsAge.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        jsAge.setBorder(BorderFactory.createTitledBorder(Utilities.getKey(Constant.L_AGE)));
        jsAge.setBackground(Constant.COLOR_WHITE);
        jPCenter.add(jsAge);

        jCBAttention = new JModelComboBox<Attention>(Utilities.getKeys(Attention.values()),Utilities.getKey(Constant.L_ATTENTION),Constant.FONT_HELVETICA_17);
        jPCenter.add(jCBAttention);

        jCBDepartments = new JModelComboBox<Departments>(Departments.values(),Utilities.getKey(Constant.L_LOCATION),Constant.FONT_HELVETICA_17);
        jPCenter.add(jCBDepartments);

        jCBHEalth = new JModelComboBox<HealthCondition>(Utilities.getKeys(HealthCondition.values()),Utilities.getKey(Constant.L_HEALTH),Constant.FONT_HELVETICA_17);
        jPCenter.add(jCBHEalth);

        jDatediagnostic = new JDateChooser();
        jDatediagnostic.setBorder(BorderFactory.createTitledBorder(Utilities.getKey(Constant.L_DATE_DIAGNOSTIC)));
        jPCenter.add(jDatediagnostic);

        jDateRecovered = new JDateChooser();
        jDateRecovered.setBorder(BorderFactory.createTitledBorder(Utilities.getKey(Constant.L_DATE_RECOVERED)));
        jPCenter.add(jDateRecovered);

        jDateDeath = new JDateChooser();
        jDateDeath.setBorder(BorderFactory.createTitledBorder(Utilities.getKey(Constant.L_DATE_DEATH)));
        jPCenter.add(jDateDeath);

        jBCreate = new JModelButton(5, 5,Utilities.getKey(Constant.L_CREATE),Constant.COLOR_BLUE_RIGHT, Constant.COLOR_WHITE,
                Constant.FONT_ARIAL_ROUNDER_25, Command.C_CREATE_NEW_PATIENT.toString(), actionListener );
        jPCenter.add(jBCreate);

        jBCancel = new JModelButton( 5, 5,Utilities.getKey(Constant.L_CANCEL), Constant.COLOR_RED_LIGHT, Constant.COLOR_WHITE,
                Constant.FONT_ARIAL_ROUNDER_25, Command.C_CANCEL_NEW_PATIENT.toString(), actionListener );
        jPCenter.add( jBCancel );
        this.add(jPCenter,BorderLayout.CENTER);
    }

    public Diagnostic createPatient(ManagePatients managePatients, JFWindowsMain jfWindowsMain) {
        if (jCBGender.getSelectedIndex() == 0 || jCBDepartments.getSelectedIndex() == 0 ||
        jCBAttention.getSelectedIndex() == 0 || jCBHEalth.getSelectedIndex() == 0){
            showMessageDialog(null, "Debes Selecionar todos los Espacios");
            return  null;
        }else {
            if (!Utilities.isValidateDatasOfAdd(jDatediagnostic.getDate(), jDateRecovered.getDate(), jDateDeath.getDate())) {
                return managePatients.createDiagnostic((Departments) jCBDepartments.getSelectedItem(),
                        Utilities.getAttention(jCBAttention.getSelectedIndex()),
                        (int) jsAge.getValue(),
                        Utilities.getGender(jCBGender.getSelectedIndex()),
                        Utilities.getHealthCondition(jCBHEalth.getSelectedIndex()),
                        Utilities.parseDateToLocalDate(jDatediagnostic.getDate()),
                        Utilities.parseDateToLocalDate(jDateDeath.getDate()),
                        Utilities.parseDateToLocalDate(jDateRecovered.getDate()));
            } else {
                showMessageDialog(null, "Debes Selecionar todos los Espacios");
                return null;
            }
        }
    }

    private void initSouth(ActionListener actionListener) {

        diagnostic = new JModelButton(Utilities.getKey(Constant.M_DIAGNOSTIC),Constant.FONT_HELVETICA_13,Constant.COLOR_BLUE_LIGHT_G,Constant.COLOR_WHITE);
        diagnostic.setActionCommand(Command.C_ACTIVE_CASES_ADD.toString());
        diagnostic.addActionListener(actionListener);
        jPSouth.add(diagnostic);

        recovered = new JModelButton(Utilities.getKey(Constant.M_RECOVERED),Constant.FONT_HELVETICA_13,Constant.COLOR_BLUE_LIGHT_G,Constant.COLOR_WHITE);
        recovered.setActionCommand(Command.C_RECOVERED_CASES_ADD.toString());
        recovered.addActionListener(actionListener);
        jPSouth.add(recovered);

        death = new JModelButton(Utilities.getKey(Constant.M_DEATH),Constant.FONT_HELVETICA_13,Constant.COLOR_BLUE_LIGHT_G,Constant.COLOR_WHITE);
        death.setActionCommand(Command.C_DEATH_CASES_ADD.toString());
        death.addActionListener(actionListener);
        jPSouth.add(death);

        this.add(jPSouth,BorderLayout.SOUTH);
    }

    @Override
    public void changeLanguage() {

        diagnostic.setText(Utilities.getKey(Constant.M_DIAGNOSTIC));
        recovered.setText(Utilities.getKey(Constant.M_RECOVERED));
        death.setText(Utilities.getKey(Constant.M_DEATH));

        jCBGender.setTitleBor(Utilities.getKey(Constant.L_GENDER));
        jCBGender.setItems(Utilities.getKeys(Gender.values()));
        jsAge.setBorder(BorderFactory.createTitledBorder(Utilities.getKey(Constant.L_AGE)));
        jCBAttention.setItems(Utilities.getKeys(Attention.values()));
        jCBAttention.setTitleBor(Utilities.getKey(Constant.L_ATTENTION));
        jCBDepartments.setTitleBor(Utilities.getKey(Constant.L_LOCATION));
        jCBHEalth.setItems(Utilities.getKeys(HealthCondition.values()));
        jCBHEalth.setTitleBor(Utilities.getKey(Constant.L_HEALTH));
        jDatediagnostic.setBorder(BorderFactory.createTitledBorder(Utilities.getKey(Constant.L_DATE_DIAGNOSTIC)));
        jDateRecovered.setBorder(BorderFactory.createTitledBorder(Utilities.getKey(Constant.L_DATE_RECOVERED)));
        jDateDeath.setBorder(BorderFactory.createTitledBorder(Utilities.getKey(Constant.L_DATE_DEATH)));
        jBCreate.setText(Utilities.getKey(Constant.L_CREATE));
        jBCancel.setText(Utilities.getKey(Constant.L_CANCEL));
    }
}
