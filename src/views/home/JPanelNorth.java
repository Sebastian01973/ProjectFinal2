package views.home;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import views.Constant;
import views.JMainPanel;
import views.Language;
import views.models.GridModel;
import views.models.JModelLabel;


public class JPanelNorth extends JPanel implements Language{

	/**
	 * 
	 */
	private JModelLabel lableBanner;
	private GridModel grid;
	private static final long serialVersionUID = 1L;
	
	public JPanelNorth() {
		this.setBackground(Constant.COLOR_WHITE);
		grid = new GridModel(this);
//		this.setBackground(Color.red);
		this.setLayout(new GridBagLayout());
		initComponents();
	}
	
	private void initComponents() {
		lableBanner = new JModelLabel(Constant.IMG_H_BANNER,(int) JMainPanel.SCREEN_SIZE.getWidth()-100,200);
		this.add(lableBanner,grid.insertComponent(0, 0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE));
	}

	@Override
	public void changeLanguage() {
		
	}
}
