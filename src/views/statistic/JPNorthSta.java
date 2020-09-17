package views.statistic;

import controllers.Command;
import utilities.Utilities;
import views.Constant;
import views.Language;
import views.models.JModelButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPNorthSta extends JPanel implements Language {

    private JModelButton buttonRecuperated,buttonDeath,buttonActiveCases;

    public JPNorthSta(ActionListener actionListener) {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBackground(Constant.COLOR_BLUE_DARK);
        initComponents(actionListener);

    }

    private void initComponents(ActionListener actionListener) {
        buttonActiveCases = new JModelButton(Utilities.getKey(Constant.M_STA_REPORT_DIAGNOSTIC),Constant.FONT_HELVETICA_13,Constant.COLOR_BLUE_LIGHT_G,Constant.COLOR_WHITE);
        buttonActiveCases.setActionCommand(Command.C_ACTIVE_CASES.toString());
        buttonActiveCases.addActionListener(actionListener);
        this.add(buttonActiveCases);

        buttonRecuperated = new JModelButton(Utilities.getKey(Constant.M_STA_REPORT_RECOVERED),Constant.FONT_HELVETICA_13,Constant.COLOR_BLUE_LIGHT_G,Constant.COLOR_WHITE);
        buttonRecuperated.setActionCommand(Command.C_RECOVERED_CASES.toString());
        buttonRecuperated.addActionListener(actionListener);
        this.add(buttonRecuperated);

        buttonDeath = new JModelButton(Utilities.getKey(Constant.M_STA_REPORT_DEATH),Constant.FONT_HELVETICA_13,Constant.COLOR_BLUE_LIGHT_G,Constant.COLOR_WHITE);
        buttonDeath.setActionCommand(Command.C_DEATH_CASES.toString());
        buttonDeath.addActionListener(actionListener);
        this.add(buttonDeath);
    }

    @Override
    public void changeLanguage() {
        buttonActiveCases.setText(Utilities.getKey(Constant.M_STA_REPORT_RECOVERED));
        buttonRecuperated.setText(Utilities.getKey(Constant.M_STA_REPORT_RECOVERED));
        buttonDeath.setText(Utilities.getKey(Constant.M_STA_REPORT_DEATH));
    }
}
