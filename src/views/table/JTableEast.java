package views.table;

import controllers.Command;
import utilities.Utilities;
import utilities.UtilitiesViews;
import views.Constant;
import views.Language;
import views.models.JModelButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class JTableEast extends JPanel implements Language {

    JModelButton addPatient,searchPatient,modifyPatient,deletePatient;
    JModelButton load,save;

    public JTableEast(ActionListener actionListener) {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBackground(Constant.COLOR_RED_TINTE);
        this.setBorder(new EmptyBorder(5,2,0,2));
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        addPatient = new JModelButton(Utilities.getKey(Constant.M_ADD_DIAGNOSTIC),Constant.IMG_ADD_USER,Constant.FONT_NEW_ROMAN_13,25,25,Constant.COLOR_RED_LIGHT,Constant.COLOR_WHITE);
        addPatient.setActionCommand(Command.ADD_PATIENT.toString());
        addPatient.setBorder(new EmptyBorder(15,5,10,5));
        addPatient.addActionListener(actionListener);
        this.add(addPatient);

        this.add(UtilitiesViews.spaceLabel(Constant.COLOR_RED_TINTE,Constant.COLOR_RED_TINTE));

        searchPatient = new JModelButton(Utilities.getKey(Constant.M_SEARCH_DIAGNOSTIC),Constant.IMG_SEARCH_USER,Constant.FONT_NEW_ROMAN_13,25,25,Constant.COLOR_RED_LIGHT,Constant.COLOR_WHITE);
        searchPatient.setActionCommand(Command.SEARCH_PATIENT.toString());
        searchPatient.addActionListener(actionListener);
        this.add(searchPatient);

        this.add(UtilitiesViews.spaceLabel(Constant.COLOR_RED_TINTE,Constant.COLOR_RED_TINTE));

        modifyPatient = new JModelButton(Utilities.getKey(Constant.M_MODIFY_DIAGNOSTIC),Constant.IMG_MODIFY_USER,Constant.FONT_NEW_ROMAN_13,25,25,Constant.COLOR_RED_LIGHT,Constant.COLOR_WHITE);
        modifyPatient.setActionCommand(Command.MODIFY_PATIENT.toString());
        modifyPatient.addActionListener(actionListener);
        this.add(modifyPatient);

        this.add(UtilitiesViews.spaceLabel(Constant.COLOR_RED_TINTE,Constant.COLOR_RED_TINTE));

        deletePatient = new JModelButton(Utilities.getKey(Constant.M_DELETE_DIAGNOSTIC),Constant.IMG_DELETE_USER,Constant.FONT_NEW_ROMAN_13,25,25,Constant.COLOR_RED_LIGHT,Constant.COLOR_WHITE);
        deletePatient.setActionCommand(Command.DELETE_PATIENT.toString());
        deletePatient.addActionListener(actionListener);
        this.add(deletePatient);

        this.add(UtilitiesViews.spaceLabel(Constant.COLOR_RED_TINTE,Constant.COLOR_RED_TINTE));

        load = new JModelButton(Utilities.getKey(Constant.M_LOAD),Constant.IMG_DOCUMENT,Constant.FONT_NEW_ROMAN_13,30,30,Constant.COLOR_RED_LIGHT,Constant.COLOR_WHITE);
        load.setActionCommand(Command.LOAD_FILE.toString());
        load.addActionListener(actionListener);
        this.add(load);

        this.add(UtilitiesViews.spaceLabel(Constant.COLOR_RED_TINTE,Constant.COLOR_RED_TINTE));

        save = new JModelButton(Utilities.getKey(Constant.M_SAVE),Constant.IMG_SAVE,Constant.FONT_NEW_ROMAN_13,30,30,Constant.COLOR_RED_LIGHT,Constant.COLOR_WHITE);
        save.setActionCommand(Command.SAVE_FILE.toString());
        save.addActionListener(actionListener);
        this.add(save);
    }

    @Override
    public void changeLanguage() {
        addPatient.setText(Utilities.getKey(Constant.M_ADD_DIAGNOSTIC));
        searchPatient.setText(Utilities.getKey(Constant.M_SEARCH_DIAGNOSTIC));
        modifyPatient.setText(Utilities.getKey(Constant.M_MODIFY_DIAGNOSTIC));
        deletePatient.setText(Utilities.getKey(Constant.M_DELETE_DIAGNOSTIC));

        load.setText(Utilities.getKey(Constant.M_LOAD));
        save.setText(Utilities.getKey(Constant.M_SAVE));
    }
}
