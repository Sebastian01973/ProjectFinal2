package views.header;

import controllers.Command;
import views.Constant;
import views.Language;

import javax.swing.*;
import java.awt.event.ActionListener;

public class JContainerHeader extends JPanel implements Language {

    private JMainMenu jMainMenu;
    private JMainToolBar jMainToolBar;


    public JContainerHeader(ActionListener actionListener) {
        this.setBackground(Constant.COLOR_BLUE_LIGHT);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        JButton button;
        button = new JButton("Ingles");
        button.setActionCommand(Command.C_US_LANGUAGE.toString());
        button.addActionListener(actionListener);
        this.add(button);

        JButton button1 = new JButton("Español");
        button1.setActionCommand(Command.C_ES_LANGUAGE.toString());
        button1.addActionListener(actionListener);
        this.add(button1);
    }

    @Override
    public void changeLanguage() {

    }
}
