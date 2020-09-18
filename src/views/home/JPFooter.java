package views.home;

import java.awt.Color;
import java.awt.GridBagConstraints;

import javax.swing.JPanel;

import utilities.Utilities;
import views.Constant;
import views.Language;
import views.models.GridModel;
import views.models.JModelLabel;

public class JPFooter extends JPanel implements Language{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GridModel grid;
	private JModelLabel labelUptc;
	private JModelLabel labelName1;
	private JModelLabel labelName2;
	private JModelLabel labelAmbulence;
	private JModelLabel labelemergency;
	
	public JPFooter() {
		this.grid = new GridModel(this);
		this.setBackground(Constant.COLOR_HOME_FOOTER);
		initComponents();
	}
	
	private void initComponents() {
		labelName1 = new JModelLabel(Utilities.getKey(Constant.TEXT_H_LABEL_NAME1), Constant.COLOR_WHITE, Constant.FONT_ARIAL_ROUNDER_17);
		this.add(labelName1, grid.insertComponent(0, 0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE));
		
		labelName2 = new JModelLabel(Utilities.getKey(Constant.TEXT_H_LABEL_NAME2),Constant.COLOR_WHITE, Constant.FONT_ARIAL_ROUNDER_17);
		this.add(labelName2, grid.insertComponent(0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE));
		
		labelUptc = new JModelLabel(Constant.IMG_H_LABEL_UPTC, 300, 200);
		this.add(labelUptc, grid.insertComponent(0, 2, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE));
		
		labelAmbulence = new JModelLabel(Constant.IMG_COV_AMBULANCE);
		this.add(labelAmbulence, grid.insertComponent(0, 3, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE));
		
		labelemergency = new JModelLabel(Constant.IMG_COV_CALL_EMERGENCY);
		this.add(labelemergency, grid.insertComponent(0, 4, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE));
	}

	@Override
	public void changeLanguage() {
		this.labelName1.setText(Utilities.getKey(Constant.TEXT_H_LABEL_NAME1));
		this.labelName2.setText(Utilities.getKey(Constant.TEXT_H_LABEL_NAME2));
	}

}
