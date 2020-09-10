package views.models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class JModelTextField extends JTextField{

	public JModelTextField(String text,String water,Font font,Color bg) {
		setBorder(BorderFactory.createTitledBorder(text));
		this.setFont(font);
		this.setBackground(bg);
		
		TextPrompt placeHolder = new TextPrompt(water, this);
		setColumns(22);
	}
}
