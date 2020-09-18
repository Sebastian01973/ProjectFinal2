package views.dialogs;

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

public class JPNorthdialog extends JToolBar{

    private JModelButton addPatient,searchPatient,modifyPatient,deletePatient;

    public JPNorthdialog(ActionListener actionListener) {
        this.setBackground(Constant.COLOR_BLUE_DIALOG);
        this.setLayout(new FlowLayout());
        this.setBorder(new EmptyBorder(2,10,2,10));
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        addPatient = new JModelButton(Constant.IMG_ADD_USER,30,30, Command.ADD_PATIENT.toString(),actionListener);
        this.add(addPatient);

        this.add(UtilitiesViews.spaceLabel(Constant.COLOR_BLUE_DIALOG,Constant.COLOR_BLUE_DIALOG));

        searchPatient = new JModelButton(Constant.IMG_SEARCH_USER,30,30, Command.SEARCH_PATIENT.toString(),actionListener);
        this.add(searchPatient);

        this.add(UtilitiesViews.spaceLabel(Constant.COLOR_BLUE_DIALOG,Constant.COLOR_BLUE_DIALOG));

        modifyPatient = new JModelButton(Constant.IMG_MODIFY_USER,30,30, Command.MODIFY_PATIENT.toString(),actionListener);
        this.add(modifyPatient);

        this.add(UtilitiesViews.spaceLabel(Constant.COLOR_BLUE_DIALOG,Constant.COLOR_BLUE_DIALOG));

        deletePatient = new JModelButton(Constant.IMG_DELETE_USER,30,30, Command.DELETE_PATIENT.toString(),actionListener);
        this.add(deletePatient);
    }
}
