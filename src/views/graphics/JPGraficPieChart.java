package views.graphics;

import java.awt.Color;
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
//		int x = UtilitiesViews.getSeparationAxis('x', 0.1f, container);
//		int y = UtilitiesViews.getSeparationAxis('y', 0.1f, container);
//		drawCircle(graphics2d,x,y);
		int grade1 = calculateDegree(50);
		int grade2 = calculateDegree(50);
		int grade3 = calculateDegree(50);
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
	
	private int calculateDegree(int value) {
		return(value*360/total);
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
		graphics2d.fillRect(x, y, width, height);
		graphics2d.drawString(label, x1, y1);
	}
	
	private void drawDatas(Graphics2D graphics2d) {
		int acumulatedAngle = 0;
		int x = UtilitiesViews.getSeparationAxis('x', 0.7f, container);
		int x1 = UtilitiesViews.getSeparationAxis('x', 0.7f, container);
		int y = UtilitiesViews.getSeparationAxis('y', 0.35f, container);
		int y1 = UtilitiesViews.getSeparationAxis('y', 0.35f, container);
		for (int i = 0; i < datas.length; i++) {
			drawArc(datas[i], graphics2d, acumulatedAngle, calculateDegree(datas[i]), colors[i]);
			acumulatedAngle += calculateDegree(datas[i]);
			drawLabels(labels[i], graphics2d, colors[i], x, y, x1, y1);
			acumulateNumber(x, y, x1, y1);
		}
	}
	
	private void acumulateNumber(int x, int y,int x1,int y1) {
		x1 = 2*x1;
		y = 2*y;
		y1 = 2*y1;
	}
	
	public static void main(String[] args) {
		JDialog jDialog = new JDialog();
		JPGraficPieChart jpg = new JPGraficPieChart(jDialog,new String[] {"1","2","3","4"},new int[] {50,50,50,50},
				new Color[] {Color.red,Color.blue,Color.green,Color.orange});
		JScrollPane jsp = new JScrollPane(jpg);
		jDialog.add(jsp);
		jDialog.setSize(new Dimension(600,400));
		jDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		jDialog.setVisible(true);
	}
}
