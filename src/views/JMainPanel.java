package views;

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

    public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();

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

    public void addElementToTable(ArrayList<Object[]> matrix,String[] header){
        jcardLayout.addElementToTable(matrix,header);
    }

    public int getSelectRow() {
        return jcardLayout.getSelectRow();
    }

    public void deleteRowIndex(int index) {
        jcardLayout.deleteRowIndex(index);
    }

    public int getSelectedRow() {
        return jcardLayout.getSelectedRow();
    }

    public void setDatas(int[] datasx,int[] datasy){
        jcardLayout.setDatas(datasx,datasy);
    }
    
    public void setDatasPie(int[] datas) {
    	jcardLayout.setDatasPie( datas);
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
