package views.table;

import controllers.Command;
import utilities.Utilities;
import utilities.UtilitiesViews;
import views.Constant;
import views.Language;
import views.models.JModelButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;

public class JTableEast extends JPanel implements Language {

    JModelButton addPatient,searchPatient,modifyPatient,deletePatient;
    JModelButton location,save,refresh;

    public JTableEast(ActionListener actionListener) {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBackground(Constant.COLOR_BLUE_DARK);
        this.setBorder(new EmptyBorder(5,2,0,2));
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        addPatient = new JModelButton(Utilities.getKey(Constant.M_ADD_DIAGNOSTIC),Constant.IMG_ADD_USER,Constant.FONT_HELVETICA_13,25,25,Constant.COLOR_BLUE_LIGHT_G,Constant.COLOR_WHITE);
        addPatient.setActionCommand(Command.ADD_PATIENT.toString());
        addPatient.setBorder(new EmptyBorder(15,5,10,5));
        addPatient.addActionListener(actionListener);
        this.add(addPatient);

        this.add(UtilitiesViews.spaceLabel(Constant.COLOR_BLUE_DARK,Constant.COLOR_BLUE_DARK));

        searchPatient = new JModelButton(Utilities.getKey(Constant.M_SEARCH_DIAGNOSTIC),Constant.IMG_SEARCH_USER,Constant.FONT_HELVETICA_13,25,25,Constant.COLOR_BLUE_LIGHT_G,Constant.COLOR_WHITE);
        searchPatient.setActionCommand(Command.SEARCH_PATIENT.toString());
        searchPatient.addActionListener(actionListener);
        this.add(searchPatient);

        this.add(UtilitiesViews.spaceLabel(Constant.COLOR_BLUE_DARK,Constant.COLOR_BLUE_DARK));

        deletePatient = new JModelButton(Utilities.getKey(Constant.M_DELETE_DIAGNOSTIC),Constant.IMG_DELETE_USER,Constant.FONT_HELVETICA_13,25,25,Constant.COLOR_BLUE_LIGHT_G,Constant.COLOR_WHITE);
        deletePatient.setActionCommand(Command.DELETE_PATIENT.toString());
        deletePatient.addActionListener(actionListener);
        this.add(deletePatient);

        this.add(UtilitiesViews.spaceLabel(Constant.COLOR_BLUE_DARK,Constant.COLOR_BLUE_DARK));

        refresh = new JModelButton(Utilities.getKey(Constant.M_REFRESH),Constant.IMG_REFRESH,Constant.FONT_HELVETICA_13,25,25,Constant.COLOR_BLUE_LIGHT_G,Constant.COLOR_WHITE);
        refresh.setActionCommand(Command.REFRESH_DATA.toString());
        refresh.addActionListener(actionListener);
        this.add(refresh);

        this.add(UtilitiesViews.spaceLabel(Constant.COLOR_BLUE_DARK,Constant.COLOR_BLUE_DARK));

        location = new JModelButton(Utilities.getKey(Constant.M_LOCATION),Constant.IMG_LOC,Constant.FONT_HELVETICA_13,25,25,Constant.COLOR_BLUE_LIGHT_G,Constant.COLOR_WHITE);
        location.setActionCommand(Command.C_TABLE_LOCATION.toString());
        location.addActionListener(actionListener);
        this.add(location);

        this.add(UtilitiesViews.spaceLabel(Constant.COLOR_BLUE_DARK,Constant.COLOR_BLUE_DARK));

        save = new JModelButton(Utilities.getKey(Constant.M_SAVE),Constant.IMG_SAVE,Constant.FONT_HELVETICA_13,25,25,Constant.COLOR_BLUE_LIGHT_G,Constant.COLOR_WHITE);
        save.setActionCommand(Command.SAVE_FILE.toString());
        save.addActionListener(actionListener);
        this.add(save);
    }

    @Override
    public void changeLanguage() {
        addPatient.setText(Utilities.getKey(Constant.M_ADD_DIAGNOSTIC));
        searchPatient.setText(Utilities.getKey(Constant.M_SEARCH_DIAGNOSTIC));
        deletePatient.setText(Utilities.getKey(Constant.M_DELETE_DIAGNOSTIC));
        location.setText(Utilities.getKey(Constant.M_LOCATION));
        save.setText(Utilities.getKey(Constant.M_SAVE));
        refresh.setText(Utilities.getKey(Constant.M_REFRESH));
    }
}
