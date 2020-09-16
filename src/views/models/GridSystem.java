package views.models;

import javax.swing.*;
import java.awt.*;

public class GridSystem {

	private static final int DEFAULT_COLUMN_WIDTH = 1;
	private static final int COLUMNS_NUMBER = 12;
	public static final Dimension INIT_DIMENSION = new Dimension(0, 0);

	private GridBagConstraints constraints;

	public GridSystem(Container component) {
		component.setLayout(new GridBagLayout());
		constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		generateBasicGrid(component);
		
	}

	private void generateBasicGrid(Container component){
		constraints.weightx = DEFAULT_COLUMN_WIDTH;
		for (int i = 0; i < COLUMNS_NUMBER; i++) {
			constraints.gridx = i;
			component.add(new JLabel(), constraints);
		}
	}
	
	public GridBagConstraints insertComponent(int row, int column, int width,int heightRows, double height,int anchor){
		constraints.gridy = row;
		constraints.gridx = column;
		constraints.gridwidth = width;
		constraints.gridheight = heightRows;
		constraints.weightx = height;
		constraints.anchor = anchor;
		return constraints;
	}
	public GridBagConstraints insertComponent(int row, int column, int width, int height,int ipadx,int ipady){
		constraints.gridy = row;
		constraints.gridx = column;
		constraints.gridwidth = width;
		constraints.gridheight = height;
		constraints.ipadx = ipadx;
		constraints.ipady = ipady;
		return constraints;
	}

	public GridBagConstraints insertComponent(int row, int column,Insets insets){
		constraints.gridy = row;
		constraints.gridx = column;
		constraints.insets = insets;
		return constraints;
	}
	
	public GridBagConstraints insertComponent(int row, int column, int width, int height,Insets insets){
		constraints.gridy = row;
		constraints.gridx = column;
		constraints.gridwidth = width;
		constraints.gridheight = height;
		constraints.insets = insets;
		return constraints;
	}
	
	public GridBagConstraints insertComponent(int row, int column, int width, int height,int ipadx,int ipady,Insets insets){
		constraints.gridy = row;
		constraints.gridx = column;
		constraints.gridwidth = width;
		constraints.gridheight = height;
		constraints.ipadx = ipadx;
		constraints.ipady = ipady;
		constraints.insets = insets;
		return constraints;
	}
	
	/**
	 * 
	 * @param row initial value is 1
	 * @param column initial value is 0
	 * @param width number between 1 and 12, is the columns number that fill the component
	 * @param height of the row
	 * @return constrains with the new values
	 */
	public GridBagConstraints insertComponent(int row, int column, int width, double height){
		constraints.gridy = row;
		constraints.gridx = column;
		constraints.gridwidth = width;
		constraints.weighty = height;
		return constraints;
	}
	/**
	 * 
	 * Keeps row and height
	 * @param column initial value is 0
	 * @param width number between 1 and 12, is the columns number that fill the component
	 * @return constrains with the new values
	 */
	public GridBagConstraints insertComponent(int column, int width){
		constraints.gridx = column;
		constraints.gridwidth = width;
		return constraints;
	}

	/**
	 * Add a border to the previous component
	 * @param top
	 * @param right
	 * @param bottom
	 * @param left
	 */
	public void addExternalBorder(int top, int right, int bottom, int left){
		constraints.insets = new Insets(top,left,bottom,right);
	}
	
	public void setExternalBorder() {
		constraints.insets = new Insets(0,0,0,0);
	}
}
