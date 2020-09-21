package views;

import views.dialogs.JDFileChooser;
import views.footer.JContainerFooter;
import views.header.JContainerHeader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class JMainPanel extends JPanel implements Language{

    private JContainerHeader jContainerHeater;
    private JCardLayout jcardLayout;
    private JContainerFooter jContainerFooter;
    private JDFileChooser jDFileChooser;

    public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();

    public JMainPanel(ActionListener actionListener,MouseListener mouseL) {
        this.setLayout(new BorderLayout(0,0));
        this.setBackground(Constant.COLOR_WHITE);
        initComponents(actionListener,mouseL);
    }

    private void initComponents(ActionListener actionListener,MouseListener mouseL) {
    	this.jDFileChooser = new JDFileChooser(actionListener);
        jContainerHeater = new JContainerHeader(actionListener);
        this.add(jContainerHeater,BorderLayout.NORTH);

        jcardLayout = new JCardLayout(actionListener,mouseL);
        this.add(jcardLayout,BorderLayout.CENTER);

        jContainerFooter = new JContainerFooter(actionListener);
        this.add(jContainerFooter,BorderLayout.SOUTH);
    }
    
    public void showFileChooser(boolean value) {
    	this.jDFileChooser.showDialog(value);
    }
    
    public String getFileName() {
    	return jDFileChooser.getPath();
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

    public void setDatasBar(int[] datas,String[] labelsDt) {
    	jcardLayout.setDatasBar(datas, labelsDt);
    }
    
    public void setValues(int cases,int casesDeath,int casesRecuperated) {
    	jcardLayout.setValues(cases, casesDeath, casesRecuperated);
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

    public void setCounts(int...cases) {
    	jcardLayout.setCounts( cases);
    }
    
    public void setCountsDpt(String location,int...values) {
    	this.jcardLayout.setCountsDpt(location,values);
    }
    @Override
    public void changeLanguage() {
        jContainerHeater.changeLanguage();
        jcardLayout.changeLanguage();
    }


}
