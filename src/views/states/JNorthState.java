package views.states;

import utilities.UtilitiesViews;
import views.Constant;
import views.Language;
import views.models.JModelLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JNorthState extends JPanel implements Language {

    private JModelLabel title,content;

    public JNorthState(ActionListener actionListener) {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBackground(Constant.COLOR_WHITE);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        title = new JModelLabel(Constant.M_TITLTE_STATES,Constant.COLOR_BLACK,Constant.FONT_ARIAL_ROUNDER_30);
        this.add(title);
        this.add(UtilitiesViews.spaceLabel(Constant.COLOR_WHITE,Constant.COLOR_WHITE));

        content = new JModelLabel(Constant.M_DIALOG_STATES,Constant.COLOR_BLACK,Constant.FONT_HELVETICA_17);
        this.add(content);
    }

    @Override
    public void changeLanguage() {

    }
}
