package views.statistic;

import controllers.Command;
import utilities.Utilities;
import utilities.UtilitiesViews;
import views.Constant;
import views.Language;
import views.models.JModelButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;

public class JPanelLeft extends JPanel implements Language {

    private JModelButton reportedForLocation;
    private JModelButton bgraphicsLine,bgraphicsBar,bgraphicsTorte,bReportLethality,bReportState;

    public JPanelLeft(ActionListener actionListener) {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBackground(Constant.COLOR_BLUE_DARK);
        this.setBorder(new EmptyBorder(0,1,1,0));
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {

        this.add(UtilitiesViews.spaceLabel(Constant.COLOR_BLUE_DARK,Constant.COLOR_BLUE_DARK));

       reportedForLocation = new JModelButton(Utilities.getKey(Constant.M_STA_REPORT_LOCATION),Constant.IMG_LOC,Constant.FONT_HELVETICA_13,25,25,Constant.COLOR_BLUE_LIGHT_G,Constant.COLOR_WHITE);
       reportedForLocation.setActionCommand(Command.C_CASES_LOCATION.toString());
       reportedForLocation.addActionListener(actionListener);
       this.add(reportedForLocation);

        this.add(UtilitiesViews.spaceLabel(Constant.COLOR_BLUE_DARK,Constant.COLOR_BLUE_DARK));

        bgraphicsLine = new JModelButton(Utilities.getKey(Constant.M_GRAP_REPORT_LINE),Constant.IMG_STADITICS2,Constant.FONT_HELVETICA_13,25,25,Constant.COLOR_BLUE_LIGHT_G,Constant.COLOR_WHITE);
        bgraphicsLine.setActionCommand(Command.C_GRAPHICS_LINE.toString());
        bgraphicsLine.addActionListener(actionListener);
        this.add(bgraphicsLine);

        this.add(UtilitiesViews.spaceLabel(Constant.COLOR_BLUE_DARK,Constant.COLOR_BLUE_DARK));

        bgraphicsBar = new JModelButton(Utilities.getKey(Constant.M_GRAP_BAR_REPORT),Constant.IMG_STADITICS1,Constant.FONT_HELVETICA_13,25,25,Constant.COLOR_BLUE_LIGHT_G,Constant.COLOR_WHITE);
        bgraphicsBar.setActionCommand(Command.C_GRAPHICS_BAR.toString());
        bgraphicsBar.addActionListener(actionListener);
        this.add(bgraphicsBar);

        this.add(UtilitiesViews.spaceLabel(Constant.COLOR_BLUE_DARK,Constant.COLOR_BLUE_DARK));

        bgraphicsTorte = new JModelButton(Utilities.getKey(Constant.M_GRAP_TORTE_REPORT),Constant.IMG_STADITICSTORTE,Constant.FONT_HELVETICA_13,25,25,Constant.COLOR_BLUE_LIGHT_G,Constant.COLOR_WHITE);
        bgraphicsTorte.setActionCommand(Command.C_GRAPHICS_TORTE.toString());
        bgraphicsTorte.addActionListener(actionListener);
        this.add(bgraphicsTorte);

        this.add(UtilitiesViews.spaceLabel(Constant.COLOR_BLUE_DARK,Constant.COLOR_BLUE_DARK));

        bReportLethality = new JModelButton(Utilities.getKey(Constant.M_PERCENTAGE_LETHALITY),Constant.IMG_COV_DEATH,Constant.FONT_HELVETICA_13,25,25,Constant.COLOR_BLUE_LIGHT_G,Constant.COLOR_WHITE);
        bReportLethality.setActionCommand(Command.C_REPORT_LETHAL.toString());
        bReportLethality.addActionListener(actionListener);
        this.add(bReportLethality);

        this.add(UtilitiesViews.spaceLabel(Constant.COLOR_BLUE_DARK,Constant.COLOR_BLUE_DARK));

        bReportState = new JModelButton(Utilities.getKey(Constant.M_STATE_HEALTH),Constant.IMG_COV_HEALTHY,Constant.FONT_HELVETICA_13,25,25,Constant.COLOR_BLUE_LIGHT_G,Constant.COLOR_WHITE);
        bReportState.setActionCommand(Command.C_REPORT_HEALTH.toString());
        bReportState.addActionListener(actionListener);
        this.add(bReportState);


    }

    @Override
    public void changeLanguage() {
        reportedForLocation.setText(Utilities.getKey(Constant.M_STA_REPORT_LOCATION));
        bgraphicsLine.setText(Utilities.getKey(Constant.M_GRAP_REPORT_LINE));
        bgraphicsBar.setText(Utilities.getKey(Constant.M_GRAP_BAR_REPORT));
        bgraphicsTorte.setText(Utilities.getKey(Constant.M_GRAP_TORTE_REPORT));
        bReportLethality.setText(Utilities.getKey(Constant.M_PERCENTAGE_LETHALITY));
        bReportState.setText(Utilities.getKey(Constant.M_STATE_HEALTH));
    }
}
