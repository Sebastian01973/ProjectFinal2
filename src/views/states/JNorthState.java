package views.states;

import utilities.Utilities;
import utilities.UtilitiesViews;
import views.Constant;
import views.JMainPanel;
import views.Language;
import views.models.JModelLabel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class JNorthState extends JPanel implements Language {

    private JModelLabel title,content;
    private JModelLabel jMLbanderCol;

    public JNorthState(ActionListener actionListener) {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBackground(Constant.COLOR_BLUE_LIGHT_G);
        this.setBorder(new EmptyBorder(0,30,0,0));
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        jMLbanderCol = new JModelLabel(Constant.IMG_BANDERA, (int)JMainPanel.SCREEN_SIZE.getWidth()-100,200);
        this.add(jMLbanderCol);

        title = new JModelLabel(Utilities.getKey(Constant.M_TITLTE_STATES),Constant.COLOR_WHITE,Constant.FONT_ARIAL_ROUNDER_30);
        this.add(title);
        this.add(UtilitiesViews.spaceLabel(Constant.COLOR_BLUE_LIGHT_G,Constant.COLOR_BLUE_LIGHT_G));

        content = new JModelLabel(Utilities.getKey(Constant.M_DIALOG_STATES),Constant.COLOR_WHITE,Constant.FONT_HELVETICA_17);
        this.add(content);
    }

    @Override
    public void changeLanguage() {
        title.setText(Utilities.getKey(Constant.M_TITLTE_STATES));
        content.setText(Utilities.getKey(Constant.M_DIALOG_STATES));
    }
}
