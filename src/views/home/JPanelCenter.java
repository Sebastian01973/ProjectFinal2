package views.home;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import views.Constant;
import views.models.GridModel;
import views.models.JModelLabel;

public class JPanelCenter extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JModelLabel lbImgRecovered;
	private JModelLabel lbImgCases;
	private JModelLabel lbImgDeceased;
	private JModelLabel lbTextRevcovered;
	private JModelLabel lbTextDeceased;
	private JModelLabel lbTextCases;
	private GridModel grid;

	public JPanelCenter() {
		grid = new GridModel(this);
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.BLUE);
		initComponents();
	}
	
	private void initComponents() {
		lbImgCases = new JModelLabel(Constant.IMG_H_CASES, 200, 200);
		grid.addExternalBorder(20, 20, 20, 20);
		addLabel(lbImgCases,0, 0, 1, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.NONE);
		
		lbImgRecovered = new JModelLabel(Constant.IMG_H_RECOVERED, 200, 200);
		addLabel(lbImgRecovered, 0, 1, 1, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.NONE);
		
		lbImgDeceased = new JModelLabel(Constant.IMG_H_CASES, 200, 200);
		addLabel(lbImgDeceased, 0, 2, 1, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.NONE);
		
		lbTextCases = new JModelLabel("Casos:", Color.black, Constant.FONT_ARIAL_ROUNDER_17);
		addLabel(lbTextCases, 1, 0, 1, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.SOUTHWEST);
		
		lbTextRevcovered = new JModelLabel("Recuperados:", Color.BLACK, Constant.FONT_ARIAL_ROUNDER_17);
		addLabel(lbTextRevcovered, 1, 1, 1, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.SOUTHWEST);
		
		lbTextDeceased = new JModelLabel("Fallecidos:", Color.BLACK, Constant.FONT_ARIAL_ROUNDER_17);
		addLabel(lbTextDeceased, 1, 2, 1, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.SOUTHWEST);
	}
	
	private void addLabel(JModelLabel jModelLabel, int row, int column, 
			int width,int heightRows, double height,int anchor,int fill) {
		this.add(jModelLabel ,grid.insertComponent(row, column, width, heightRows, height, anchor, fill));
	}
}
