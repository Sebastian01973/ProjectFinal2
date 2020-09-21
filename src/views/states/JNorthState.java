package views.states;

import utilities.Utilities;
import utilities.UtilitiesViews;
import views.Constant;
import views.JMainPanel;
import views.Language;
import views.models.GridModel;
import views.models.JModelLabel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import models.Departments;

import java.awt.*;
import java.awt.event.ActionListener;

public class JNorthState extends JPanel implements Language {

    private JModelLabel title,content;
    private JModelLabel jMLbanderCol;
    private int casesActive,casesRecuperated,casesDeath;
    String location;
    private JModelLabel dateResume,dateRecuperated,dateDiagnostic,dateDeath;
    private GridModel grid;

    public JNorthState(ActionListener actionListener) {
    	this.grid = new GridModel(this);
        this.setLayout(new GridBagLayout());
        this.setBackground(Constant.COLOR_BLUE_LIGHT_G);
        casesActive = 0;
        casesRecuperated = 0;
        casesDeath = 0;
        location = "";
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        jMLbanderCol = new JModelLabel(Constant.IMG_BANDERA, (int)JMainPanel.SCREEN_SIZE.getWidth()-100,200);
        this.add(jMLbanderCol,grid.insertComponent(0, 0, 4, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.NONE));

        title = new JModelLabel(Utilities.getKey(Constant.M_TITLTE_STATES),Constant.COLOR_WHITE,Constant.FONT_ARIAL_ROUNDER_30);
        this.add(title,grid.insertComponent(1, 0, 4, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.NONE));
        this.add(UtilitiesViews.spaceLabel(Constant.COLOR_BLUE_LIGHT_G,Constant.COLOR_BLUE_LIGHT_G));

        content = new JModelLabel(Utilities.getKey(Constant.M_DIALOG_STATES),Constant.COLOR_WHITE,Constant.FONT_HELVETICA_17);
        this.add(content,grid.insertComponent(2, 0, 4, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.NONE));
        
        dateResume = new JModelLabel(Utilities.getKey(Constant.L_RESUME_CASES)+location,Constant.IMG_COV_CORONA,Constant.FONT_HELVETICA_17,Constant.COLOR_BLUE_RIGHT,Constant.COLOR_WHITE,60,60);
        this.add(dateResume,grid.insertComponent(3, 0, 1, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.NONE));

        dateDiagnostic = new JModelLabel(Utilities.getKey(Constant.L_NUMBER_CASES)+casesActive,Constant.IMG_COV_SICK_SNEEZE,Constant.FONT_HELVETICA_15,Constant.COLOR_PURPLE,Constant.COLOR_WHITE,60,60);
        this.add(dateDiagnostic,grid.insertComponent(3, 1, 1, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.NONE));

        dateRecuperated = new JModelLabel(Utilities.getKey(Constant.L_NUMBER_DIAGNOSTIC)+casesRecuperated,Constant.IMG_COV_RECOVERED,Constant.FONT_HELVETICA_15,Constant.COLOR_PURPLE,Constant.COLOR_WHITE,60,60);
        this.add(dateRecuperated,grid.insertComponent(3, 2, 1, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.NONE));

        dateDeath = new JModelLabel(Utilities.getKey(Constant.L_NUMBER_DEATH)+casesDeath,Constant.IMG_COV_DEATH,Constant.FONT_HELVETICA_15,Constant.COLOR_PURPLE,Constant.COLOR_WHITE,60,60);
        this.add(dateDeath,grid.insertComponent(3, 3, 1, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.NONE));
    }

    @Override
    public void changeLanguage() {
        title.setText(Utilities.getKey(Constant.M_TITLTE_STATES));
        content.setText(Utilities.getKey(Constant.M_DIALOG_STATES));
        dateResume.setText(Utilities.getKey(Constant.L_RESUME_CASES)+location);
        dateDiagnostic.setText(Utilities.getKey(Constant.L_NUMBER_CASES)+casesActive);
        dateRecuperated.setText(Utilities.getKey(Constant.L_NUMBER_DIAGNOSTIC)+casesRecuperated);
        dateDeath.setText(Utilities.getKey(Constant.L_NUMBER_DEATH)+casesDeath);
    }
  
    public void setValues(String location,int...values) {
    	this.location = location;
    	dateResume.setText(Utilities.getKey(Constant.L_RESUME_CASES)+location);
    	this.casesActive = values[0];
    	this.casesRecuperated = values[1];
    	this.casesDeath = values[2];
    	dateDiagnostic.setText(Utilities.getKey(Constant.L_NUMBER_CASES)+casesActive);
    	dateRecuperated.setText(Utilities.getKey(Constant.L_NUMBER_DIAGNOSTIC)+casesRecuperated);
    	dateDeath.setText(Utilities.getKey(Constant.L_NUMBER_DEATH)+casesDeath);
    }
}
