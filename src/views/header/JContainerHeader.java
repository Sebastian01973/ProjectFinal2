package views.header;

import controllers.Command;
import views.Constant;
import views.Language;
import views.models.JModelButtonLanguage;
import views.models.JModelLabel;
import views.models.JModelPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JContainerHeader extends JPanel implements Language {

    private JMainMenu jMainMenu;
    private JMainToolBar jMainToolBar;
    private JModelLabel jMLBanner;
    private JModelButtonLanguage jBSpanish,jBEnglish;
    JModelPanel panelLanguage,panelBanner;


    public JContainerHeader(ActionListener actionListener) {
        this.setBackground(Constant.COLOR_GRAY_LIGHT);
        this.setLayout(new BorderLayout(0,0));
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {

        panelBanner = new JModelPanel(new FlowLayout(0),Constant.COLOR_GRAY_LIGHT);
        jMLBanner = new JModelLabel(Constant.IMG_BANNER,350,65);
        panelBanner.add(jMLBanner);
        this.add(panelBanner,BorderLayout.WEST);

        jMainMenu = new JMainMenu(actionListener);
        this.add(jMainMenu, BorderLayout.CENTER);

//       jMainToolBar = new JMainToolBar(actionListener);
//       this.add(jMainToolBar,BorderLayout.SOUTH);

        panelLanguage = new JModelPanel(new FlowLayout(0),Constant.COLOR_BLACK);
        jBSpanish = new JModelButtonLanguage(Constant.M_LANGUAGE_ES,Constant.IMG_SPANISH,Constant.FONT_NEW_ROMAN_13,25,25,Constant.COLOR_BLACK,Constant.COLOR_WHITE);
        jBSpanish.setActionCommand(Command.C_ES_LANGUAGE.toString());
        jBSpanish.addActionListener(actionListener);
        panelLanguage.add(jBSpanish);

        jBEnglish = new JModelButtonLanguage(Constant.M_LANGUAGE_US,Constant.IMG_ENGLISH,Constant.FONT_NEW_ROMAN_13,25,25,Constant.COLOR_BLACK,Constant.COLOR_WHITE);
        jBEnglish.setActionCommand(Command.C_US_LANGUAGE.toString());
        jBEnglish.addActionListener(actionListener);
        panelLanguage.add(jBEnglish);

        this.add(panelLanguage,BorderLayout.EAST);
    }

    @Override
    public void changeLanguage() {

    }
}
