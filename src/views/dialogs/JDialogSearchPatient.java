package views.dialogs;

import controllers.Command;
import models.Attention;
import models.Departments;
import models.Gender;
import models.HealthCondition;
import utilities.Utilities;
import views.Constant;
import views.Language;
import views.models.GridModel;
import views.models.JModelButton;
import views.models.JModelComboBox;
import views.models.JModelLabel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatter;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class JDialogSearchPatient extends JPanel implements Language {

    private GridLayout gridLayout;
    private JSpinner jsAge;
    private JModelComboBox<Gender> jCBGender;
    private JModelComboBox<Attention> jCBAttention;
    private JModelComboBox<Departments> jCBDepartments;
    private JModelComboBox<HealthCondition> JCBHealth;
    private JButton jBSearch,jBCancel;
    private JModelLabel jModelLabel;

    public JDialogSearchPatient(ActionListener actionListener){
        gridLayout = new GridLayout(8,1);
        this.setLayout(gridLayout);
        gridLayout.setVgap(20);
        this.setBorder(new EmptyBorder(20,30,5,30));
        this.setBackground(Constant.COLOR_WHITE);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {

        jModelLabel = new JModelLabel(Utilities.getKey(Constant.M_DIALOG_SEARCH_GUIDE),Constant.COLOR_BLUE_DARK,Constant.FONT_NEW_ROMAN_25);
        this.add(jModelLabel);

        jsAge = new JSpinner(new SpinnerNumberModel(0, 0, 95, 1));
        ((DefaultFormatter) ((JSpinner.NumberEditor)jsAge.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        jsAge.setBorder(BorderFactory.createTitledBorder(Utilities.getKey(Constant.L_AGE)));
        jsAge.setBackground(Constant.COLOR_WHITE);
        this.add(jsAge);
        
        jCBGender = new JModelComboBox<Gender>(Utilities.getKeys(Gender.values()),Utilities.getKey(Constant.L_GENDER),Constant.FONT_HELVETICA_17);
//        this.add(jCBGender);

        jCBAttention = new JModelComboBox<Attention>(Utilities.getKeys(Attention.values()),Utilities.getKey(Constant.L_ATTENTION),Constant.FONT_HELVETICA_17);
        this.add(jCBAttention);

        jCBDepartments = new JModelComboBox<Departments>(Departments.values(),Utilities.getKey(Constant.L_LOCATION),Constant.FONT_HELVETICA_17);
        this.add(jCBDepartments);

        JCBHealth = new JModelComboBox<HealthCondition>(Utilities.getKeys(HealthCondition.values()),Utilities.getKey(Constant.L_HEALTH),Constant.FONT_HELVETICA_17);
        this.add(JCBHealth);

        jBSearch = new JModelButton(5, 5,Utilities.getKey(Constant.L_SEARCH),Constant.COLOR_GREEN_LIGHT, Constant.COLOR_WHITE,
                Constant.FONT_ARIAL_ROUNDER_25, Command.C_FILTER_SEARCH.toString(), actionListener );
        this.add(jBSearch);

        jBCancel = new JModelButton( 5, 5,Utilities.getKey(Constant.L_CANCEL), Constant.COLOR_RED_LIGHT, Constant.COLOR_WHITE,
                Constant.FONT_ARIAL_ROUNDER_25, Command.C_CANCEL_NEW_PATIENT.toString(), actionListener );
        this.add( jBCancel);
    }

    public String getSearchFilter(){
        if ((int)jsAge.getValue() == 0 && jCBAttention.getSelectedIndex() == 0 &&
        jCBDepartments.getSelectedIndex() == 0 && JCBHealth.getSelectedIndex() == 0){
            showMessageDialog(null, "Debes Selecionar minimo una opcion");
            return null;
        }else{
           if (Utilities.isValidateDatasSearch((int)jsAge.getValue(),jCBAttention.getSelectedIndex()
           ,jCBDepartments.getSelectedIndex(),JCBHealth.getSelectedIndex())){
               return String.valueOf(jsAge.getValue());
           }else if (Utilities.isValidateDatasSearch(jCBAttention.getSelectedIndex(),(int)jsAge.getValue()
                   ,jCBDepartments.getSelectedIndex(),JCBHealth.getSelectedIndex())){
               return jCBAttention.getSelectedItem().toString();
           }else if(Utilities.isValidateDatasSearch(jCBDepartments.getSelectedIndex(),(int)jsAge.getValue()
                   ,jCBAttention.getSelectedIndex(),JCBHealth.getSelectedIndex())){
               return jCBDepartments.getSelectedItem().toString();
           }else if (Utilities.isValidateDatasSearch(JCBHealth.getSelectedIndex(),(int)jsAge.getValue()
                   ,jCBAttention.getSelectedIndex(),jCBDepartments.getSelectedIndex())){
                return JCBHealth.getSelectedItem().toString();
           }else{
               showMessageDialog(null, "No puedes seleccionr mas de una opcion");
               return null;
           }
        }
    }

    @Override
    public void changeLanguage() {
        jModelLabel.setText(Utilities.getKey(Constant.M_DIALOG_SEARCH_GUIDE));
        jsAge.setBorder(BorderFactory.createTitledBorder(Utilities.getKey(Constant.L_AGE)));
        jCBAttention.setItems(Utilities.getKeys(Attention.values()));
        jCBAttention.setTitleBor(Utilities.getKey(Constant.L_ATTENTION));
        jCBDepartments.setTitleBor(Utilities.getKey(Constant.L_LOCATION));
        JCBHealth.setItems(Utilities.getKeys(HealthCondition.values()));
        JCBHealth.setTitleBor(Utilities.getKey(Constant.L_HEALTH));
        jBSearch.setText(Utilities.getKey(Constant.L_SEARCH));
        jBCancel.setText(Utilities.getKey(Constant.L_CANCEL));

    }
}
