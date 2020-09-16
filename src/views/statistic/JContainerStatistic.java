package views.statistic;

import views.Constant;
import views.Language;
import views.graphics.JPBarGraphic;
import views.graphics.JPGraficPieChart;
import views.graphics.JPanelGraphics;
import views.home.JPanelNorth;
import views.models.GridModel;
import views.models.GridSystem;
import views.models.JModelLabel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class JContainerStatistic extends JPanel implements Language {

    private JPNorthSta jPanelNorth;
    private JPanelLeft jPanelLeft;
    private JPanelRight jPanelRight;
    private JPCardGraphics jpCardGraphics;

    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    public JContainerStatistic(ActionListener actionListener) {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        jPanelNorth = new JPNorthSta(actionListener);
        this.add(jPanelNorth,BorderLayout.NORTH);

        jPanelLeft = new JPanelLeft(actionListener);
        this.add(jPanelLeft,BorderLayout.WEST);

        jPanelRight = new JPanelRight(actionListener);
        this.add(jPanelRight,BorderLayout.EAST);

        jpCardGraphics = new JPCardGraphics();
        this.add(jpCardGraphics,BorderLayout.CENTER);
    }

    public void showCardGraphics(String command){
        jpCardGraphics.showCardGraphics(command);
    }

    @Override
    public void changeLanguage() {
        jPanelNorth.changeLanguage();
        jPanelLeft.changeLanguage();
        jPanelRight.changeLanguage();
    }
}
