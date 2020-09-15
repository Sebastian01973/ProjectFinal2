package views.home;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import views.Constant;
import views.JMainPanel;
import views.models.JModelLabel;


public class JPanelNorth extends JPanel{

	/**
	 * 
	 */
	private JModelLabel lableBanner;
	private static final long serialVersionUID = 1L;
	private GridBagConstraints gbc;
	
	public JPanelNorth() {
		gbc = new GridBagConstraints();
//		this.setBackground(Color.decode(Constant.COLOR_BANNER));
		this.setBackground(Color.red);
		this.setLayout(new GridBagLayout());
		initComponents();
	}
	
	private void initComponents() {
		lableBanner = new JModelLabel(Constant.IMG_H_BANNER);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.EAST;
		this.add(lableBanner,gbc);
	}
}
