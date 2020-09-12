package views.header;

import controllers.Command;
import utilities.Utilities;
import views.Constant;
import views.Language;
import views.models.JModelMenu;
import views.models.JModelMenuItem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class JMainMenu extends JMenuBar implements Language {

    JModelMenu menuFile,menuStadistic,menuPatient,menuAbout;
    JModelMenuItem mILanSpanish,mILanEnglish,mIExit,mILoadFile,mISaveFile,mIRefreshData;

    JModelMenu menuLanguage,menuReportCol,menuReportLocation,menuGraphics;

    JModelMenu mReportDeathCol,mReportRecoveredCol,mReportDiagnosticCol;
    JModelMenuItem mIrepRanAgeColDiag, mIrepAgeColDiag;
    JModelMenuItem mIrepMonthColDeath,mIPerLethalityCol;
    JModelMenuItem mIrepRanAgeColReco,mIrepAgeColReco, mIrepMonthColReco;

    JModelMenu mReportDeathLoc,mReportRecoveredLoc,mReportDiagnosticLoc;
    JModelMenuItem mIrepRanAgeLocDiag, mIrepAgeLocDiag;
    JModelMenuItem mIrepMonthLocDeath,mIPerLethalityLoc;
    JModelMenuItem mIrepRanAgeLocReco,mIrepAgeLocReco, mIrepMonthLocReco;

    JModelMenuItem mITableLocation,mIGraphicsTorte,mIGraphicsBar,mIGraphicsMonths;

    JModelMenuItem mIAddPatient,mISearchPatient,mIModifyPatient,mIDeletePatient;

    JModelMenuItem mIAboutCreator,mIAboutApp;

    public JMainMenu(ActionListener actionListener) {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBorder(new EmptyBorder(15,10,5,15));
        this.setBackground(Constant.COLOR_GRAY_LIGHT);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        showMenuFile(actionListener);
        showMenuStadisticCol(actionListener);
        showMenuStadisticLoc(actionListener);
        showMenuStadisticGraphics(actionListener);
        showMenuPatient(actionListener);
        showMenuContactUs(actionListener);
    }

    private void showMenuFile(ActionListener actionListener) {

        menuFile = new JModelMenu(Utilities.getKey(Constant.M_FILE),Constant.IMG_FILE,Constant.COLOR_WHITE,Constant.COLOR_BLACK,Constant.FONT_ROCWELL,25,25);

        mILoadFile = new JModelMenuItem(Utilities.getKey(Constant.M_LOAD),Constant.IMG_DOCUMENT,Constant.FONT_HELVETICA_17,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mILoadFile.setActionCommand(Command.LOAD_FILE.toString());
        mILoadFile.addActionListener(actionListener);
        menuFile.add(mILoadFile);

        mISaveFile = new JModelMenuItem(Utilities.getKey(Constant.M_SAVE),Constant.IMG_SAVE,Constant.FONT_HELVETICA_17,20,20,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mISaveFile.setActionCommand(Command.SAVE_FILE.toString());
        mISaveFile.addActionListener(actionListener);
        menuFile.add(mISaveFile);

        mIRefreshData = new JModelMenuItem(Utilities.getKey(Constant.M_REFRESH),Constant.IMG_REFRESH,Constant.FONT_HELVETICA_17,20,20,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mIRefreshData.setActionCommand(Command.REFRESH_DATA.toString());
        mIRefreshData.addActionListener(actionListener);
        menuFile.add(mIRefreshData);

        menuLanguage = new JModelMenu(Utilities.getKey(Constant.M_LANGUAGE),Constant.IMG_WORLD,Constant.COLOR_WHITE,Constant.COLOR_BLACK,Constant.FONT_HELVETICA_17,25,25);

        mILanSpanish = new JModelMenuItem(Utilities.getKey(Constant.M_LANGUAGE_ES),Constant.IMG_SPANISH,Constant.FONT_HELVETICA_17,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mILanSpanish.setActionCommand(Command.C_ES_LANGUAGE.toString());
        mILanSpanish.addActionListener(actionListener);
        menuLanguage.add(mILanSpanish);

        mILanEnglish = new JModelMenuItem(Utilities.getKey(Constant.M_LANGUAGE_US),Constant.IMG_ENGLISH,Constant.FONT_HELVETICA_17,23,23,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mILanEnglish.setActionCommand(Command.C_US_LANGUAGE.toString());
        mILanEnglish.addActionListener(actionListener);
        menuLanguage.add(mILanEnglish);

        menuFile.add(menuLanguage);

        mIExit = new JModelMenuItem(Utilities.getKey(Constant.M_EXIT),Constant.IMG_EXIT_APP,Constant.FONT_HELVETICA_17,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mIExit.setActionCommand(Command.EXIT_APP.toString());
        mIExit.addActionListener(actionListener);
        menuFile.add(mIExit);

        this.add(menuFile);

    }

    private void showMenuStadisticCol(ActionListener actionListener){
        menuStadistic = new JModelMenu(Utilities.getKey(Constant.M_STATISTICS),Constant.IMG_STADISTIC,Constant.COLOR_WHITE,Constant.COLOR_BLACK,Constant.FONT_ROCWELL,25,25);

        menuReportCol = new JModelMenu(Utilities.getKey(Constant.M_STA_REPORT_COL),Constant.IMG_COl,Constant.COLOR_WHITE,Constant.COLOR_BLACK,Constant.FONT_ROCWELL,25,25);

        mReportDiagnosticCol =new JModelMenu(Utilities.getKey(Constant.M_STA_REPORT_DIAGNOSTIC),Constant.IMG_COV_PATIENT,Constant.COLOR_WHITE,Constant.COLOR_BLACK,Constant.FONT_ROCWELL,25,25);

        mIrepRanAgeColDiag = new JModelMenuItem(Utilities.getKey(Constant.M_REPORT_RANGE_AGE),Constant.IMG_RANGE_AGE,Constant.FONT_HELVETICA_17,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mIrepRanAgeColDiag.setActionCommand(Command.C_RANGE_AGE_COL_DIAG.toString());
        mIrepRanAgeColDiag.addActionListener(actionListener);
        mReportDiagnosticCol.add(mIrepRanAgeColDiag);

        mIrepAgeColDiag = new JModelMenuItem(Utilities.getKey(Constant.M_REPORT_AGE),Constant.IMG_AGE,Constant.FONT_HELVETICA_17,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mIrepAgeColDiag.setActionCommand(Command.C_AGE_COL_DIAG.toString());
        mIrepAgeColDiag.addActionListener(actionListener);
        mReportDiagnosticCol.add(mIrepAgeColDiag);
        menuReportCol.add(mReportDiagnosticCol);

        mReportDeathCol =new JModelMenu(Utilities.getKey(Constant.M_STA_REPORT_DEATH),Constant.IMG_DEATH,Constant.COLOR_WHITE,Constant.COLOR_BLACK,Constant.FONT_ROCWELL,25,25);

        mIPerLethalityCol = new JModelMenuItem(Utilities.getKey(Constant.M_PERCENTAGE_LETHALITY),Constant.IMG_COV_DEATH,Constant.FONT_HELVETICA_17,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mIPerLethalityCol.setActionCommand(Command.C_LETHALITY_COL_DEATH.toString());
        mIPerLethalityCol.addActionListener(actionListener);
        mReportDeathCol.add(mIPerLethalityCol);

        mIrepMonthColDeath = new JModelMenuItem(Utilities.getKey(Constant.M_REPORT_MONTHS),Constant.IMG_COV_CALENDAR,Constant.FONT_HELVETICA_17,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mIrepMonthColDeath.setActionCommand(Command.C_MONTHS_COL_DEATH.toString());
        mIrepMonthColDeath.addActionListener(actionListener);
        mReportDeathCol.add(mIrepMonthColDeath);
        menuReportCol.add(mReportDeathCol);

        mReportRecoveredCol =new JModelMenu(Utilities.getKey(Constant.M_STA_REPORT_RECOVERED),Constant.IMG_COV_RECOVERED,Constant.COLOR_WHITE,Constant.COLOR_BLACK,Constant.FONT_ROCWELL,25,25);

        mIrepRanAgeColReco = new JModelMenuItem(Utilities.getKey(Constant.M_REPORT_RANGE_AGE),Constant.IMG_RANGE_AGE,Constant.FONT_HELVETICA_17,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mIrepRanAgeColReco.setActionCommand(Command.C_RANGE_AGE_COL_RECO.toString());
        mIrepRanAgeColReco.addActionListener(actionListener);
        mReportRecoveredCol.add(mIrepRanAgeColReco);

        mIrepAgeColReco = new JModelMenuItem(Utilities.getKey(Constant.M_REPORT_AGE),Constant.IMG_AGE,Constant.FONT_HELVETICA_17,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mIrepAgeColReco.setActionCommand(Command.C_AGE_COL_RECO.toString());
        mIrepAgeColReco.addActionListener(actionListener);
        mReportRecoveredCol.add(mIrepAgeColReco);

        mIrepMonthColReco = new JModelMenuItem(Utilities.getKey(Constant.M_REPORT_MONTHS),Constant.IMG_COV_CALENDAR,Constant.FONT_HELVETICA_17,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mIrepMonthColReco.setActionCommand(Command.C_MONTHS_COL_RECO.toString());
        mIrepMonthColReco.addActionListener(actionListener);
        mReportRecoveredCol.add(mIrepMonthColReco);
        menuReportCol.add(mReportRecoveredCol);

        menuStadistic.add(menuReportCol);

        this.add(menuStadistic);
    }

    private void showMenuStadisticLoc(ActionListener actionListener) {
        menuReportLocation = new JModelMenu(Utilities.getKey(Constant.M_STA_REPORT_LOCATION),Constant.IMG_LOC,Constant.COLOR_WHITE,Constant.COLOR_BLACK,Constant.FONT_ROCWELL,25,25);

        mITableLocation = new JModelMenuItem(Utilities.getKey(Constant.M_STA_TABLE_FOR_LOCATION),Constant.IMG_TABLE,Constant.FONT_ROCWELL,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mITableLocation.setActionCommand(Command.C_TABLE_LOC.toString());
        mITableLocation.addActionListener(actionListener);
        menuReportLocation.add(mITableLocation);

        mReportDiagnosticLoc =new JModelMenu(Utilities.getKey(Constant.M_STA_REPORT_DIAGNOSTIC),Constant.IMG_COV_PATIENT,Constant.COLOR_WHITE,Constant.COLOR_BLACK,Constant.FONT_ROCWELL,25,25);

        mIrepRanAgeLocDiag = new JModelMenuItem(Utilities.getKey(Constant.M_REPORT_RANGE_AGE),Constant.IMG_RANGE_AGE,Constant.FONT_HELVETICA_17,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mIrepRanAgeLocDiag.setActionCommand(Command.C_RANGE_AGE_LOC_DIAG.toString());
        mIrepRanAgeLocDiag.addActionListener(actionListener);
        mReportDiagnosticLoc.add(mIrepRanAgeLocDiag);

        mIrepAgeLocDiag = new JModelMenuItem(Utilities.getKey(Constant.M_REPORT_AGE),Constant.IMG_AGE,Constant.FONT_HELVETICA_17,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mIrepAgeLocDiag.setActionCommand(Command.C_AGE_LOC_DIAG.toString());
        mIrepAgeLocDiag.addActionListener(actionListener);
        mReportDiagnosticLoc.add(mIrepAgeLocDiag);
        menuReportLocation.add(mReportDiagnosticLoc);

        mReportDeathLoc =new JModelMenu(Utilities.getKey(Constant.M_STA_REPORT_DEATH),Constant.IMG_DEATH,Constant.COLOR_WHITE,Constant.COLOR_BLACK,Constant.FONT_ROCWELL,25,25);

        mIPerLethalityLoc = new JModelMenuItem(Utilities.getKey(Constant.M_PERCENTAGE_LETHALITY),Constant.IMG_COV_DEATH,Constant.FONT_HELVETICA_17,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mIPerLethalityLoc.setActionCommand(Command.C_LETHALITY_LOC_DEATH.toString());
        mIPerLethalityLoc.addActionListener(actionListener);
        mReportDeathLoc.add(mIPerLethalityLoc);

        mIrepMonthLocDeath = new JModelMenuItem(Utilities.getKey(Constant.M_REPORT_MONTHS),Constant.IMG_COV_CALENDAR,Constant.FONT_HELVETICA_17,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mIrepMonthLocDeath.setActionCommand(Command.C_MONTHS_LOC_DEATH.toString());
        mIrepMonthLocDeath.addActionListener(actionListener);
        mReportDeathLoc.add(mIrepMonthLocDeath);
        menuReportLocation.add(mReportDeathLoc);

        mReportRecoveredLoc =new JModelMenu(Utilities.getKey(Constant.M_STA_REPORT_RECOVERED),Constant.IMG_COV_RECOVERED,Constant.COLOR_WHITE,Constant.COLOR_BLACK,Constant.FONT_ROCWELL,25,25);

        mIrepRanAgeLocReco = new JModelMenuItem(Utilities.getKey(Constant.M_REPORT_RANGE_AGE),Constant.IMG_RANGE_AGE,Constant.FONT_HELVETICA_17,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mIrepRanAgeLocReco.setActionCommand(Command.C_RANGE_AGE_LOC_RECO.toString());
        mIrepRanAgeLocReco.addActionListener(actionListener);
        mReportRecoveredLoc.add(mIrepRanAgeLocReco);

        mIrepAgeLocReco = new JModelMenuItem(Utilities.getKey(Constant.M_REPORT_AGE),Constant.IMG_AGE,Constant.FONT_HELVETICA_17,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mIrepAgeLocReco.setActionCommand(Command.C_AGE_LOC_RECO.toString());
        mIrepAgeLocReco.addActionListener(actionListener);
        mReportRecoveredLoc.add(mIrepAgeLocReco);

        mIrepMonthLocReco = new JModelMenuItem(Utilities.getKey(Constant.M_REPORT_MONTHS),Constant.IMG_COV_CALENDAR,Constant.FONT_HELVETICA_17,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mIrepMonthLocReco.setActionCommand(Command.C_MONTHS_LOC_RECO.toString());
        mIrepMonthLocReco.addActionListener(actionListener);
        mReportRecoveredLoc.add(mIrepMonthLocReco);
        menuReportLocation.add(mReportRecoveredLoc);

        menuStadistic.add(menuReportLocation);
    }

    private void showMenuStadisticGraphics(ActionListener actionListener){
        menuGraphics = new JModelMenu(Utilities.getKey(Constant.M_GRAP_REPORT),Constant.IMG_GRAPHICS,Constant.COLOR_WHITE,Constant.COLOR_BLACK,Constant.FONT_ROCWELL,25,25);

        mIGraphicsMonths = new JModelMenuItem(Utilities.getKey(Constant.M_GRAP_FOR_MONTHS),Constant.IMG_STADITICS2,Constant.FONT_ROCWELL,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mIGraphicsMonths.setActionCommand(Command.C_GRAPHICS_MONTHS.toString());
        mIGraphicsMonths.addActionListener(actionListener);
        menuGraphics.add(mIGraphicsMonths);

        mIGraphicsBar = new JModelMenuItem(Utilities.getKey(Constant.M_GRAP_BAR_REPORT),Constant.IMG_STADITICS1,Constant.FONT_ROCWELL,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mIGraphicsBar.setActionCommand(Command.C_GRAPHICS_BAR.toString());
        mIGraphicsBar.addActionListener(actionListener);
        menuGraphics.add(mIGraphicsBar);

        mIGraphicsTorte = new JModelMenuItem(Utilities.getKey(Constant.M_GRAP_TORTE_REPORT),Constant.IMG_STADITICSTORTE,Constant.FONT_ROCWELL,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mIGraphicsTorte.setActionCommand(Command.C_GRAPHICS_TORTE.toString());
        mIGraphicsTorte.addActionListener(actionListener);
        menuGraphics.add(mIGraphicsTorte);

        menuStadistic.add(menuGraphics);
    }

    private void showMenuPatient(ActionListener actionListener){
        menuPatient = new JModelMenu(Utilities.getKey(Constant.M_PATIENT),Constant.IMG_USER,Constant.COLOR_WHITE,Constant.COLOR_BLACK,Constant.FONT_ROCWELL,25,25);

        mIAddPatient = new JModelMenuItem(Utilities.getKey(Constant.M_ADD_DIAGNOSTIC),Constant.IMG_ADD_USER,Constant.FONT_ROCWELL,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mIAddPatient.setActionCommand(Command.ADD_PATIENT.toString());
        mIAddPatient.addActionListener(actionListener);
        menuPatient.add(mIAddPatient);

        mISearchPatient = new JModelMenuItem(Utilities.getKey(Constant.M_SEARCH_DIAGNOSTIC),Constant.IMG_SEARCH_USER,Constant.FONT_ROCWELL,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mISearchPatient.setActionCommand(Command.SEARCH_PATIENT.toString());
        mISearchPatient.addActionListener(actionListener);
        menuPatient.add(mISearchPatient);

        mIModifyPatient = new JModelMenuItem(Utilities.getKey(Constant.M_MODIFY_DIAGNOSTIC),Constant.IMG_MODIFY_USER,Constant.FONT_ROCWELL,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mIModifyPatient.setActionCommand(Command.MODIFY_PATIENT.toString());
        mIModifyPatient.addActionListener(actionListener);
        menuPatient.add(mIModifyPatient);

        mIDeletePatient = new JModelMenuItem(Utilities.getKey(Constant.M_DELETE_DIAGNOSTIC),Constant.IMG_DELETE_USER,Constant.FONT_ROCWELL,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mIDeletePatient.setActionCommand(Command.DELETE_PATIENT.toString());
        mIDeletePatient.addActionListener(actionListener);
        menuPatient.add(mIDeletePatient);

        this.add(menuPatient);
    }
    //Hola

    private void showMenuContactUs(ActionListener actionListener){
        menuAbout = new JModelMenu(Utilities.getKey(Constant.M_ABOUT),Constant.IMG_ABOUT,Constant.COLOR_WHITE,Constant.COLOR_BLACK,Constant.FONT_ROCWELL,25,25);

        mIAboutCreator = new JModelMenuItem(Utilities.getKey(Constant.M_CREATORS),Constant.IMG_ABOUT_US,Constant.FONT_ROCWELL,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mIAboutCreator.setActionCommand(Command.ABOUT_US.toString());
        mIAboutCreator.addActionListener(actionListener);
        menuAbout.add(mIAboutCreator);

        mIAboutApp = new JModelMenuItem(Utilities.getKey(Constant.M_APPLICATION),Constant.IMG_ABOUT_APP,Constant.FONT_ROCWELL,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        mIAboutApp.setActionCommand(Command.ABOUT_APP.toString());
        mIAboutApp.addActionListener(actionListener);
        menuAbout.add(mIAboutApp);

        this.add(menuAbout);
    }

    @Override
    public void changeLanguage() {
        menuFile.setText(Utilities.getKey(Constant.M_FILE));
        mILoadFile.setText(Utilities.getKey(Constant.M_LOAD));
        mISaveFile.setText(Utilities.getKey(Constant.M_SAVE));
        mIRefreshData.setText(Utilities.getKey(Constant.M_REFRESH));
        menuLanguage.setText(Utilities.getKey(Constant.M_LANGUAGE));
        mILanSpanish.setText(Utilities.getKey(Constant.M_LANGUAGE_ES));
        mILanEnglish.setText(Utilities.getKey(Constant.M_LANGUAGE_US));
        mIExit.setText(Utilities.getKey(Constant.M_EXIT));

        menuStadistic.setText(Utilities.getKey(Constant.M_STATISTICS));
        menuReportCol.setText(Utilities.getKey(Constant.M_STA_REPORT_COL));

        mITableLocation.setText(Utilities.getKey(Constant.M_STA_TABLE_FOR_LOCATION));

        mReportDiagnosticCol.setText(Utilities.getKey(Constant.M_STA_REPORT_DIAGNOSTIC));
        mIrepRanAgeColDiag.setText(Utilities.getKey(Constant.M_REPORT_RANGE_AGE));
        mIrepAgeColDiag.setText(Utilities.getKey(Constant.M_REPORT_AGE));

        mReportDeathCol.setText(Utilities.getKey(Constant.M_STA_REPORT_DEATH));
        mIPerLethalityCol.setText(Utilities.getKey(Constant.M_PERCENTAGE_LETHALITY));
        mIrepMonthColDeath.setText(Utilities.getKey(Constant.M_REPORT_MONTHS));

        mReportRecoveredCol.setText(Utilities.getKey(Constant.M_STA_REPORT_RECOVERED));
        mIrepRanAgeColReco.setText(Utilities.getKey(Constant.M_REPORT_RANGE_AGE));
        mIrepAgeColReco.setText(Utilities.getKey(Constant.M_REPORT_AGE));
        mIrepMonthColReco.setText(Utilities.getKey(Constant.M_REPORT_MONTHS));

        menuReportLocation.setText(Utilities.getKey(Constant.M_STA_REPORT_LOCATION));

        mReportDiagnosticLoc.setText(Utilities.getKey(Constant.M_STA_REPORT_DIAGNOSTIC));
        mIrepRanAgeLocDiag.setText(Utilities.getKey(Constant.M_REPORT_RANGE_AGE));
        mIrepAgeLocDiag.setText(Utilities.getKey(Constant.M_REPORT_AGE));

        mReportDeathLoc.setText(Utilities.getKey(Constant.M_STA_REPORT_DEATH));
        mIPerLethalityLoc.setText(Utilities.getKey(Constant.M_PERCENTAGE_LETHALITY));
        mIrepMonthLocDeath.setText(Utilities.getKey(Constant.M_REPORT_MONTHS));

        mReportRecoveredLoc.setText(Utilities.getKey(Constant.M_STA_REPORT_RECOVERED));
        mIrepRanAgeLocReco.setText(Utilities.getKey(Constant.M_REPORT_RANGE_AGE));
        mIrepAgeLocReco.setText(Utilities.getKey(Constant.M_REPORT_AGE));
        mIrepMonthLocReco.setText(Utilities.getKey(Constant.M_REPORT_MONTHS));

        menuGraphics.setText(Utilities.getKey(Constant.M_GRAP_REPORT));
        mIGraphicsMonths.setText(Utilities.getKey(Constant.M_GRAP_FOR_MONTHS));
        mIGraphicsBar.setText(Utilities.getKey(Constant.M_GRAP_BAR_REPORT));
        mIGraphicsTorte.setText(Utilities.getKey(Constant.M_GRAP_TORTE_REPORT));

        menuPatient.setText(Utilities.getKey(Constant.M_PATIENT));
        mIAddPatient.setText(Utilities.getKey(Constant.M_ADD_DIAGNOSTIC));
        mISearchPatient.setText(Utilities.getKey(Constant.M_SEARCH_DIAGNOSTIC));
        mIModifyPatient.setText(Utilities.getKey(Constant.M_MODIFY_DIAGNOSTIC));
        mIDeletePatient.setText(Utilities.getKey(Constant.M_DELETE_DIAGNOSTIC));

        menuAbout.setText(Utilities.getKey(Constant.M_ABOUT));
        mIAboutCreator.setText(Utilities.getKey(Constant.M_CREATORS));
        mIAboutApp.setText(Utilities.getKey(Constant.M_APPLICATION));
    }
}
