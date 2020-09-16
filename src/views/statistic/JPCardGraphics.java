package views.statistic;

import controllers.Command;
import views.Constant;
import views.Language;
import views.graphics.JPBarGraphic;
import views.graphics.JPGraficPieChart;
import views.graphics.JPanelGraphics;

import javax.swing.*;

import com.sun.xml.internal.ws.client.sei.ValueSetter;

import java.awt.*;

public class JPCardGraphics extends JPanel implements Language {

    private JPanelGraphics jPanelGraphics;
    private JPBarGraphic jpBarGraphic;
    private JPGraficPieChart jpGraficPieChart;
    private CardLayout cardLayout;

    public JPCardGraphics() {
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        this.setBackground(Constant.COLOR_WHITE);
        initComponents();
    }

    private void initComponents() {

        jpBarGraphic = new JPBarGraphic(this,new String[] {"1","2","3","4","5","6","7","8"},new String[] {
                "10%","20%","30%","40%","50%","60%","70%","80%","90%","100%"
        },new int[] {22,33,45,88,70,40,80,90},new String[] {"Data1","Data","Data","Data","Data"
                ,"Data","Data7","Data8"},new Color[] {Color.red});
        this.add(jpBarGraphic,Command.C_GRAPHICS_BAR.toString());

        jPanelGraphics = new JPanelGraphics(new int[] {3,4,5,6,7,8,9,},new int[]{100,200,200,400,500,580,200}
        );
        this.add(jPanelGraphics, Command.C_GRAPHICS_LINE.toString());



        jpGraficPieChart = new JPGraficPieChart(this,new String[] {"Data1","Data2","Data3","Data4"},
                new int[] {50,10,10,30},
                new Color[] {Color.red,Color.blue,Color.green,Color.orange});
        this.add(jpGraficPieChart,Command.C_GRAPHICS_TORTE.toString());
    }

    public void showCardGraphics(String command){
        cardLayout.show(this,command);
    }

    @Override
    public void changeLanguage() {

    }
}
