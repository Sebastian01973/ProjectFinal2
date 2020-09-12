package views.models;

import javax.swing.*;
import java.awt.*;

public class JModelLabel extends JLabel{

	/**
	 * @descprtion Este metodo nos agrega una imagen a un label
	 * @param icon
	 */
	public JModelLabel(String imagePath) {
		this.setIcon( new ImageIcon(getClass().getResource( imagePath )));
	}

	public JModelLabel(String imagePath, int width, int height) {
		ImageIcon image;
		image = new ImageIcon(getClass().getResource(imagePath));
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
		this.setIcon(icon);
	}
	
	public JModelLabel(String text, Color fg, Font font) {
		super(text);
		this.setOpaque(false);
		this.setFont(font);
		this.setForeground(fg);
	}
	
	public JModelLabel(Icon icon) {
		super(icon);
		this.setOpaque(false);
	}
}