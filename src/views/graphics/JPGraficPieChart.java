package views.graphics;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import utilities.UtilitiesViews;

public class JPGraficPieChart extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Container container;
	 
	
	public JPGraficPieChart(Container container) {
		this.container = container;
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D graphics2d = (Graphics2D) g;
		int x = UtilitiesViews.getSeparationAxis('x', 0.6f, container);
		int y = UtilitiesViews.getSeparationAxis('y', 0.6f, container);
		drawCircle(graphics2d,x,y);
	}
	
	public void drawCircle(Graphics2D graphics2d,int x, int y)  {
		graphics2d.fillOval(100, 100, 100, 100);
	}
	
	public static void main(String[] args) {
		JDialog jDialog = new JDialog();
		JPGraficPieChart jpg = new JPGraficPieChart(jDialog);
		JScrollPane jsp = new JScrollPane(jpg);
		jDialog.add(jsp);
		jDialog.setSize(new Dimension(500,600));
		jDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		jDialog.setVisible(true);
	}
}
