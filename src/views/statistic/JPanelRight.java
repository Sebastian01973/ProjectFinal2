package views.statistic;

import utilities.Utilities;
import views.Constant;
import views.Language;
import views.models.GridModel;
import views.models.JModelLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPanelRight extends JPanel implements Language {

    private JModelLabel dateResume,dateRecuperated,dateDiagnostic,dateDeath;
    private int casesActive,casesRecuperated,casesDeath;
    private String location;

    private GridModel gridModel;

    public JPanelRight() {
        location = "Colombia";
        casesActive = 124;
        casesRecuperated = 34;
        casesDeath = 23;
        gridModel = new GridModel(this);
        this.setLayout(new GridBagLayout());
        initComponents();
        this.setBackground(Constant.COLOR_BLUE_RIGHT);
    }

    private void initComponents() {
        dateResume = new JModelLabel(Utilities.getKey(Constant.L_RESUME_CASES)+location,Constant.IMG_COV_CORONA,Constant.FONT_HELVETICA_17,Constant.COLOR_BLUE_RIGHT,Constant.COLOR_WHITE,60,60);
        this.add(dateResume,gridModel.insertComponent(0,0,1,1,new Insets(10,5,5,5)));

        dateDiagnostic = new JModelLabel(Utilities.getKey(Constant.L_NUMBER_CASES)+casesActive,Constant.IMG_COV_SICK_SNEEZE,Constant.FONT_HELVETICA_15,Constant.COLOR_PURPLE,Constant.COLOR_WHITE,60,60);
        this.add(dateDiagnostic,gridModel.insertComponent(1,0,1,1,new Insets(10,5,5,5)));

        dateRecuperated = new JModelLabel(Utilities.getKey(Constant.L_NUMBER_DIAGNOSTIC)+casesRecuperated,Constant.IMG_COV_RECOVERED,Constant.FONT_HELVETICA_15,Constant.COLOR_PURPLE,Constant.COLOR_WHITE,60,60);
        this.add(dateRecuperated,gridModel.insertComponent(2,0,1,1,new Insets(10,5,5,5)));

        dateDeath = new JModelLabel(Utilities.getKey(Constant.L_NUMBER_DEATH)+casesDeath,Constant.IMG_COV_DEATH,Constant.FONT_HELVETICA_15,Constant.COLOR_PURPLE,Constant.COLOR_WHITE,60,60);
        this.add(dateDeath,gridModel.insertComponent(3,0,1,1,new Insets(10,5,5,5)));
    }

    public void setDatesTotals(int...cases){
        this.casesActive = cases[0];
        dateDiagnostic.setText(Utilities.getKey(Constant.L_NUMBER_CASES)+casesActive);
        this.casesRecuperated = cases[1];
        dateRecuperated.setText(Utilities.getKey(Constant.L_NUMBER_DIAGNOSTIC)+casesRecuperated);
        this.casesDeath = cases[2];
        dateDeath.setText(Utilities.getKey(Constant.L_NUMBER_DEATH)+casesDeath);
    }


    @Override
    public void changeLanguage() {
        dateResume.setText(Utilities.getKey(Constant.L_RESUME_CASES)+location);
        dateDiagnostic.setText(Utilities.getKey(Constant.L_NUMBER_CASES)+casesActive);
        dateRecuperated.setText(Utilities.getKey(Constant.L_NUMBER_DIAGNOSTIC)+casesRecuperated);
        dateDeath.setText(Utilities.getKey(Constant.L_NUMBER_DEATH)+casesDeath);
    }
}
