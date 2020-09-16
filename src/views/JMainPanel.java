package views;

import views.about.JContainerAbout;
import views.home.JContainerHome;
import views.statistic.JContainerStatistic;
import views.table.JContainerTable;
import views.footer.JContainerFooter;
import views.header.JContainerHeader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JMainPanel extends JPanel implements Language{

    private JContainerHeader jContainerHeater;
    private JCardLayout jcardLayout;
    private JContainerFooter jContainerFooter;


    public JMainPanel(ActionListener actionListener) {
        this.setLayout(new BorderLayout(0,0));
        this.setBackground(Constant.COLOR_WHITE);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        jContainerHeater = new JContainerHeader(actionListener);
        this.add(jContainerHeater,BorderLayout.NORTH);

        jcardLayout = new JCardLayout(actionListener);
        this.add(jcardLayout,BorderLayout.CENTER);

        jContainerFooter = new JContainerFooter(actionListener);
        this.add(jContainerFooter,BorderLayout.SOUTH);
    }

    public void showPanels(String command){
        jcardLayout.showPanels(command);
    }

    public void showCardGraphics(String command){
        jcardLayout.showCardGraphics(command);
    }


    public void addElementToTable(Object[] objects){
        jcardLayout.addElementToTable(objects);
    }

    public void addElementToTable(ArrayList<Object[]> matrix){
        jcardLayout.addElementToTable(matrix);
    }


    @Override
    public void changeLanguage() {
        jContainerHeater.changeLanguage();
        jcardLayout.changeLanguage();
    }


}
