package views.models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

public class JModelButtonLanguage extends JButton{
	
	private String link;
	private boolean status;

	public JModelButtonLanguage(String text, String imagePath, Font font, Color...colors) {
		super(text);
		this.setFont( font );
		this.setIcon( new ImageIcon(getClass().getResource( imagePath )) );
		this.setBorderPainted( false );
		this.setFocusable( false );
		this.setOpaque(false);
		this.setHorizontalTextPosition( SwingConstants.CENTER );
		this.setVerticalTextPosition( SwingConstants.BOTTOM );
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.setBackground(colors[0]);
		this.setForeground(colors[1]);
		
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

			}
			
			
			@Override
			public void mouseEntered(MouseEvent e) {
				status = true;
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				status = false;
				repaint();
			}
				
		});
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if (status) {
			g2.rotate(Math.toRadians(30),getWidth()/2,getHeight()/2);
		}
		super.paint(g2);
	}
}
