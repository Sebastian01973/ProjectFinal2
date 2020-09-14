package views.models;

import views.Constant;

import javax.swing.*;
import java.awt.*;

public class JModelDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JModelDialog(String title, String imagePath, int width, int height) {
		setModal(true);
		setTitle(title);
		setIconImage( new ImageIcon(getClass().getResource(imagePath)).getImage());
		setSize(new Dimension(width,height));
		getContentPane().setBackground(Constant.COLOR_WHITE);
	}
	
	public JModelDialog(String title, String imagePath, int width, int height, JPanel panelGraphic) {
		setModal(true);
		setTitle(title);
		setIconImage( new ImageIcon(getClass().getResource(imagePath)).getImage());
		setSize(new Dimension(width,height));
		getContentPane().setBackground(Constant.COLOR_WHITE);
		JScrollPane jScrollPane = new JScrollPane(panelGraphic);
		this.add(jScrollPane);
	}
	
}
