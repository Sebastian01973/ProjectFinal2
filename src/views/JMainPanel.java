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
    private JContainerHome jContainerHome;
    private JContainerTable jContainerTable;
    private JContainerStatistic jContainerStatistic;
    private JContainerAbout jContainerAbout;
    private JContainerFooter jContainerFooter;
    
    public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();


    public JMainPanel(ActionListener actionListener) {
        this.setLayout(new BorderLayout(0,0));
        this.setBackground(Constant.COLOR_WHITE);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        jContainerHeater = new JContainerHeader(actionListener);
        this.add(jContainerHeater,BorderLayout.NORTH);

        jContainerHome = new JContainerHome(actionListener);
        this.add(jContainerHome,BorderLayout.CENTER);

        jContainerFooter = new JContainerFooter(actionListener);
        this.add(jContainerFooter,BorderLayout.SOUTH);
    }

    public void setBody(JPanel jPanel){
        this.remove(jContainerHome);
        this.add(jPanel);
    }

    public void addElementToTable(Object[] objects){
        jContainerTable.addElementToTable(objects);
    }

    public void addElementToTable(ArrayList<Object[]> matrix){
        jContainerTable.addElementToTable(matrix);
    }


    @Override
    public void changeLanguage() {
        jContainerHeater.changeLanguage();
        jContainerTable.changeLanguage();
    }
}
