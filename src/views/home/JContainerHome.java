package views.home;

import views.Constant;
import views.JMainPanel;
import views.models.GridModel;
import views.models.JModelLabel;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

public class JContainerHome extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanelNorth jPNorth;
	private JPanelCenter jPCenter;
	private JPFooter jPfooter;
	private GridModel grid;
	/**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    public JContainerHome(ActionListener actionListener) {
//      this.setBackground(Constant.COLOR_WHITE);
        this.grid = new GridModel(this);
        this.setLayout(new GridBagLayout());
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
    	jPNorth = new JPanelNorth();
    	this.add(jPNorth,grid.insertComponent(0, 0, 1, 1, 1, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH));
    	
    	jPCenter = new JPanelCenter();
    	this.add(jPCenter, grid.insertComponent(1, 0, 1, 1,1,GridBagConstraints.FIRST_LINE_START,GridBagConstraints.BOTH));
    	
    	jPfooter = new JPFooter();
    	this.add(jPfooter,grid.insertComponent(2, 0, 1, 1, 1, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH));
    }
  
}
