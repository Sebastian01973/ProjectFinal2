package views.states;

import controllers.Command;
import models.Departments;
import utilities.Utilities;
import views.Constant;
import views.models.GridModel;
import views.models.JModelButton;
import views.models.JModelLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;

public class JCenterState extends JPanel {

    private GridModel gridModel;

    public JCenterState(ActionListener actionListener,MouseListener mouseL) {
        gridModel = new GridModel(this);
        this.setLayout(new GridBagLayout());
        this.setBackground(Constant.COLOR_BLUE_DARK);
        initButtons(actionListener, mouseL);
    }

    private void createButton(int row,int column,String name,String imgPath,String command,ActionListener actionListener
    		,MouseListener mouseL){
        JModelButton button = new JModelButton(name,imgPath,300,250,Constant.COLOR_BLUE_DARK,command,actionListener
        		,mouseL);
        this.add(button,gridModel.insertComponent(row,column,1,1, new Insets(10,10,10,10)));
    }

    private void initButtons(ActionListener actionListener,MouseListener mouseL){
        Departments[] departmens = Departments.values();
        Command[] commands = Command.values();
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 3; j++) {
                createButton(i,j,departmens[count].getKeys(),Constant.IMGS_DEPART[count],
                		commands[count].toString(),actionListener,mouseL);
                count++;
            }
        }
    }
}
