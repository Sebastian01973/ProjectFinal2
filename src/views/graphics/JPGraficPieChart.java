package views.graphics;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

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
	private String[] labels;
	private int[] datas;
	private int total;
	private Color[] colors;
	
	/**
	 * Constructor, OJO!!!, que todos los arrays tengan la misma longitud
	 * @param container
	 * @param labels
	 * @param datas
	 * @param colors
	 */
	public JPGraficPieChart(Container container,String[] labels,int[] datas,Color[] colors) {
		this.container = container;
		this.labels = labels;
		this.datas = datas;
		this.colors = colors;
		calculateTotal();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.setColor(Color.white);
		graphics2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		graphics2d.setColor(Color.black);
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		drawDatas(graphics2d);
	}
	
	private void calculateTotal() {
		for (int i = 0; i < datas.length; i++) {
			this.total += datas[i];
		}
	}
	
	public void drawCircle(Graphics2D graphics2d,int x, int y)  {
		int radius = UtilitiesViews.getSeparationAxis('x', 0.1f, container);
		graphics2d.fillOval(x, y, radius, radius);
	}
	
	private double calculateDegree(int value) {
		return Math.round((value*360.0/total));
	}
	
	private void drawArc(int value,Graphics2D graphics2d,int initialAngle,int finalAngle,Color color) {
		graphics2d.setColor(color);
		int x = UtilitiesViews.getSeparationAxis('x', 0.1f, container);
		int y = UtilitiesViews.getSeparationAxis('y', 0.1f, container);
		int radius = UtilitiesViews.getSeparationAxis('x', 0.4f, container);
		graphics2d.fillArc(x, y, radius, radius, initialAngle, finalAngle);
	}
	
	private void drawLabels(String label,Graphics2D graphics2d,Color color,int x,int y,int x1,int y1) {
		int width = UtilitiesViews.getSeparationAxis('x', 0.05f, container);
		int height = UtilitiesViews.getSeparationAxis('x', 0.03f, container);
		graphics2d.setColor(color);
		graphics2d.fillRoundRect(x, y, width, height, 10, 10);
//		graphics2d.fillRect(x, y, width, height);
		graphics2d.drawString(label, x1, y1);
	}
	
	private void drawDatas(Graphics2D graphics2d) {
		int acumulatedAngle = 0;
		int x = UtilitiesViews.getSeparationAxis('x', 0.7f, container);
		int x1 = UtilitiesViews.getSeparationAxis('x', 0.75f, container);
		int y = UtilitiesViews.getSeparationAxis('y', 0.15f, container);
		int y1 = UtilitiesViews.getSeparationAxis('y', 0.2f, container);
		int increase = (int) (container.getHeight()*0.075f);
		for (int i = 0; i < datas.length; i++) {
			drawArc(datas[i], graphics2d, acumulatedAngle, (int)calculateDegree(datas[i]), colors[i]);
			acumulatedAngle += calculateDegree(datas[i]);
			String label = labels[i]+" "+datas[i]+"%";
			drawLabels(label, graphics2d, colors[i], x, y, x1, y1);
			y += increase;
			y1 += increase;
		}
	}
}
