package views.home;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import utilities.Utilities;
import views.Constant;
import views.Language;
import views.models.GridModel;
import views.models.JModelLabel;

public class JPanelCenter extends JPanel implements Language{

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
	private JModelLabel lbTitleInformation;
	private JModelLabel lbTitleInformation1;
	private JModelLabel lbTitleformation2;
	private JModelLabel lbInformation;
	private JModelLabel lbInformation1;
	private JModelLabel lbInformation2;
	JModelLabel labelDiv ;
	private GridModel grid;

	public JPanelCenter() {
		grid = new GridModel(this);
		this.setLayout(new GridBagLayout());
		this.setBackground(Constant.COLOR_WHITE);
		initComponents();
	}
	
	private void initComponents() {
		grid.addExternalBorder(30, 0, 0, 0);

		labelDiv = new JModelLabel(Utilities.getKey(Constant.T_INFORMATION), Constant.C_MIDNIGHT_BLUE, Constant.COLOR_WHITE,
				Constant.FONT_HELVETICA_17, BorderFactory.createEmptyBorder(20,600,20,600));
		addLabel(labelDiv, 0, 0, 3, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.CENTER);
		
		lbTitleInformation = new JModelLabel(Utilities.getKey(Constant.T_INFO_COVID), Constant.COLOR_DIMGRAY, Constant.COLOR_WHITE,
				Constant.FONT_HELVETICA_17, BorderFactory.createEmptyBorder(5, 65, 40, 65));
		addLabel(lbTitleInformation, 1, 0, 1, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.SOUTH);
		
		lbTitleInformation1 = new JModelLabel(Utilities.getKey(Constant.T_INFO_SYMPTOMS), Constant.COLOR_DIMGRAY, Constant.COLOR_WHITE,
				Constant.FONT_HELVETICA_17, BorderFactory.createEmptyBorder(5,25,18,25));
		addLabel(lbTitleInformation1, 1, 1, 1, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.SOUTH);
		
		lbTitleformation2 = new JModelLabel(Utilities.getKey(Constant.T_INFO_PREVENT), Constant.COLOR_DIMGRAY, Constant.COLOR_WHITE,
				Constant.FONT_HELVETICA_17, BorderFactory.createEmptyBorder(5, 85, 40, 85));
		addLabel(lbTitleformation2, 1, 2, 1, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.SOUTH);
		
		lbInformation = new JModelLabel(Utilities.getKey(Constant.T_FIRST_INFORMATION), Constant.COLOR_WHITE_SMOKE,
				Constant.COLOR_BLACK,Constant.FONT_HELVETICA_15,BorderFactory.createEmptyBorder(10,5,10,5));
		addLabel(lbInformation, 2, 0, 1, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.NONE);
		
		lbInformation1 = new JModelLabel(Utilities.getKey(Constant.T_SECOND_INFORMATION), Constant.COLOR_WHITE_SMOKE,
				Constant.COLOR_BLACK,Constant.FONT_HELVETICA_15, BorderFactory.createEmptyBorder(10,5,10,5));
		
		addLabel(lbInformation1, 2, 1, 1, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.NONE);
		
		lbInformation2 = new JModelLabel(Utilities.getKey(Constant.T_THIRD_INFORMATION), Constant.COLOR_WHITE_SMOKE,
				Constant.COLOR_BLACK, Constant.FONT_HELVETICA_15, BorderFactory.createEmptyBorder(10,5,10,5));
		addLabel(lbInformation2, 2, 2, 1, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.NONE);
		
		lbImgCases = new JModelLabel(Constant.IMG_H_CASES, 200, 200);
		grid.addExternalBorder(20, 20, 20, 20);
		addLabel(lbImgCases,3, 0, 1, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.NONE);
		
		lbImgRecovered = new JModelLabel(Constant.IMG_H_RECOVERED, 200, 200);
		addLabel(lbImgRecovered, 3, 1, 1, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.NONE);
		
		lbImgDeceased = new JModelLabel(Constant.IMG_H_DECEASED, 200, 200);
		addLabel(lbImgDeceased, 3, 2, 1, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.NONE);
		
		grid.setExternalBorder();
		
		lbTextCases = new JModelLabel(Utilities.getKey(Constant.TEXT_H_LABEL_CASOS), Constant.IMG_H_LABEL_CASES, Constant.FONT_ARIAL_ROUNDER_17
				,Color.black);
		addLabel(lbTextCases, 4, 0, 1, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.SOUTHWEST);
		
		lbTextRevcovered = new JModelLabel(Utilities.getKey(Constant.TEXT_H_LABEL_RECOVERED), Constant.IMG_H_LABEL_RECOVERED,
				Constant.FONT_ARIAL_ROUNDER_17, Constant.COLOR_BLACK);
		addLabel(lbTextRevcovered,4, 1, 1, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.SOUTHWEST);
		
		lbTextDeceased = new JModelLabel(Utilities.getKey(Constant.TEXT_H_LABEL_DECEASED), Constant.IMG_H_LABEL_DECEASED, 
				Constant.FONT_ARIAL_ROUNDER_17, Constant.COLOR_BLACK);
		addLabel(lbTextDeceased, 4, 2, 1, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.SOUTHWEST);
		
		 
	}
	
	private void addLabel(JModelLabel jModelLabel, int row, int column, 
			int width,int heightRows, double height,int anchor,int fill) {
		this.add(jModelLabel ,grid.insertComponent(row, column, width, heightRows, height, anchor, fill));
	}

	@Override
	public void changeLanguage() {
		this.labelDiv.setText(Utilities.getKey(Constant.T_INFORMATION));
		this.lbInformation.setText(Utilities.getKey(Constant.T_FIRST_INFORMATION));
		this.lbInformation1.setText(Utilities.getKey(Constant.T_SECOND_INFORMATION));;
		this.lbInformation2.setText(Utilities.getKey(Constant.T_THIRD_INFORMATION));
		this.lbTitleInformation.setText(Utilities.getKey(Constant.T_INFO_COVID));
		this.lbTitleInformation1.setText(Utilities.getKey(Constant.T_INFO_SYMPTOMS));
		this.lbTitleformation2.setText(Utilities.getKey(Constant.T_INFO_PREVENT));
		this.lbTextCases.setText(Utilities.getKey(Constant.TEXT_H_LABEL_CASOS));
		this.lbTextRevcovered.setText(Utilities.getKey(Constant.TEXT_H_LABEL_RECOVERED));
		this.lbTextDeceased.setText(Utilities.getKey(Constant.TEXT_H_LABEL_DECEASED));
	}
	
	
}
