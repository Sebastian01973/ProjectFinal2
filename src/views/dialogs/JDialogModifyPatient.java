package views.dialogs;

import views.Constant;
import views.Language;

import javax.swing.*;
import java.awt.event.ActionListener;

public class JDialogModifyPatient extends JPanel implements Language {

    public JDialogModifyPatient(ActionListener actionListener){
        this.setBackground(Constant.COLOR_HOME_FOOTER);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
    }

    @Override
    public void changeLanguage() {

    }
}
