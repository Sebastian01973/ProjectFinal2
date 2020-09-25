
package views.statistic;

import controllers.Command;
import utilities.UtilitiesViews;
import views.Constant;
import views.Language;
import views.graphics.*;

import javax.swing.*;


import java.awt.*;

public class JPCardGraphics extends JPanel implements Language {

    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CardLayout cardLayout;
    private JPanelGraphics jPanelGraphics;
    private JPBarGraphic jpBarGraphic;
    private JPGraficPieChart jpGraficPieChart;

    private int[] datasx,datasy;

    public JPCardGraphics() {
        datasx =new int[] {};
        datasy = new int[]{};
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        this.setBackground(Constant.COLOR_WHITE);
        initComponents();
    }

    private void initComponents() {
        //new int[] {3,4,5,6,7,8,9},new int[]{100,200,200,400,500,580,200}
        jPanelGraphics = new JPanelGraphics(datasx,datasy);
        this.add(jPanelGraphics, Command.C_GRAPHICS_LINE.toString());

        jpBarGraphic = new JPBarGraphic(this,Constant.LABELS_X_BAR,Constant.LABELS_Y_BAR
        ,new int[] {22,33,45,88,70,40,80,90,10,100},new String[] {"Data1","Data","Data","Data","Data","D","d","d","d","d"
                ,"Data","Data7","Data8"},Constant.COLORS_BAR);
        this.add(jpBarGraphic,Command.C_GRAPHICS_BAR.toString());

        jpGraficPieChart = new JPGraficPieChart(this,Constant.LABELS_PIE_AGE,
                new double[] {},
                new Color[] {});
        this.add(jpGraficPieChart,Command.C_GRAPHICS_TORTE.toString());
    }

    public void setDatas(int[] datasx,int[] datasy){
        jPanelGraphics.removeAll();
        jPanelGraphics = new JPanelGraphics(datasx,UtilitiesViews.parseDatas(datasy));
        this.add(jPanelGraphics, Command.C_GRAPHICS_LINE.toString());
    }
    
    public void setDatasPie(double[] datas,String[] labels) {
    	jpGraficPieChart.removeAll();
    	jpGraficPieChart = new JPGraficPieChart(this, labels,datas, 
    			new Color[] {Color.red,Color.blue,Color.green,Color.orange,Color.gray,Color.black,Color.pink});
    	this.add(jpGraficPieChart,Command.C_GRAPHICS_TORTE.toString());
    }
    
    public void setDatasBar(int[] datas,String[] labelsDt) {
    	jpBarGraphic.removeAll();
    	jpBarGraphic = new JPBarGraphic(this, Constant.LABELS_X_BAR, Constant.LABELS_Y_BAR,
    			datas, labelsDt,Constant.COLORS_BAR);
    	this.add(jpBarGraphic,Command.C_GRAPHICS_BAR.toString());
    }

    public void showCardGraphics(String command){
        cardLayout.show(this,command);
        this.revalidate();
    }

    @Override
    public void changeLanguage() {

    }
}
