package views.states;

import controllers.Command;
import models.Departments;
import views.Constant;
import views.models.GridModel;
import views.models.JModelButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JCenterState extends JPanel {

    private GridModel gridModel;


    public JCenterState(ActionListener actionListener) {
        gridModel = new GridModel(this);
        this.setLayout(new GridBagLayout());
        this.setBackground(Constant.COLOR_BLUE_DARK);
        initButtons(actionListener);
    }

    private void createButton(int row,int column,String name,String imgPath,String command,ActionListener actionListener){
        JModelButton button = new JModelButton(name,imgPath,300,250,Constant.COLOR_BLUE_DARK,command,actionListener);
        this.add(button,gridModel.insertComponent(row,column,1,1, new Insets(10,10,10,10)));
    }

    private void initButtons(ActionListener actionListener){
        Departments[] departmens = Departments.values();
        Command[] commands = Command.values();
        int count = 0;

        for (int i = 0; i < 11; i++) {
            for (int j = 1; j < 4; j++) {
                createButton(i,j,departmens[count].getKeys(),Constant.IMGS_DEPART[count],commands[count].toString(),actionListener);
                count++;
            }
        }

    }
}
