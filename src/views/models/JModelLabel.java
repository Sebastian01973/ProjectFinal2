package views.models;

import javax.swing.*;
import java.awt.*;

public class JModelLabel extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @descprtion Este metodo nos agrega una imagen a un label
	 * @param
	 */
	public JModelLabel(String imagePath) {
		this.setIcon( new ImageIcon(getClass().getResource( imagePath )));
	}

	public JModelLabel(String imagePath, int width, int height) {
		ImageIcon image;
		image = new ImageIcon(getClass().getResource(imagePath));
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
		this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		this.setIcon(icon);
	}
	
	public JModelLabel(String text,String imagePath,Font font,Color foreground) {
		super(text);
		ImageIcon image;
		image = new ImageIcon(getClass().getResource(imagePath));
		Icon icon = new ImageIcon(image.getImage());
		this.setIcon(icon);
		this.setOpaque(false);
		this.setFont(font);
		this.setForeground(foreground);
		this.setHorizontalTextPosition( SwingConstants.CENTER );
        this.setVerticalTextPosition( SwingConstants.BOTTOM );
	}
	
	public JModelLabel(String text, Color fg, Font font) {
		super(text);
		this.setOpaque(false);
		this.setFont(font);
		this.setForeground(fg);
	}

	public JModelLabel(String text, Color bg, Color fg) {
		super(text);
		this.setOpaque(false);
		this.setBackground(bg);
		this.setForeground(fg);
	}
	
	public JModelLabel(Icon icon) {
		super(icon);
		this.setOpaque(false);
	}
}
