package views;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class JPanelGraphics extends JPanel{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
	
	private Container c;
	
	public JPanelGraphics(Container c) {
		this.c = c;
		this.setBackground(Color.white);
		this.initComponenets(c);
	}
	
	private void initComponenets(Container c) {
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D graphics2D = (Graphics2D) g;
		graphics2D.setStroke(new BasicStroke(2));
		int yAxisx = getSeparationX(0.09f);
		int yAxisy1 = getSeparationY(0.05f);
		int yAxisy2 = getSeparationY(0.8f);
		int lengthYAxis = yAxisy2-yAxisy1; 
		drawAxis(yAxisx, yAxisy1, yAxisx,
				yAxisy2,graphics2D);
		drawDivisions('y', graphics2D,10,lengthYAxis);
		int xAxisx1 = getSeparationX(0.09f);
		int xAxisx2 = getSeparationX(0.9f);
		int xAxisy = getSeparationY(0.8f);
		int lengthXAxis = xAxisx2-xAxisx1;
		drawAxis(xAxisx1, xAxisy, xAxisx2,
				xAxisy,graphics2D);
		drawDivisions('x', graphics2D,10,lengthXAxis);
		
		drawFunction(graphics2D, new int[] {3,4,5,6,7,8,9,10}, new int[] {100,
				100,100,100,100,100,100,100}, 8, lengthXAxis,lengthYAxis);
		graphics2D.drawOval(133, 60, 20, 20);
		graphics2D.drawOval(201, 207, 20, 20);
		graphics2D.drawOval(279, 279, 20, 20);
		graphics2D.drawOval(351, 351, 20, 20);
	}
	
	private void drawAxis(int x1,int y1,int x2,int y2,Graphics2D graphics2D) {
		graphics2D.drawLine(x1, y1, x2, y2);
	}
	
	private int getSeparationX(float value) {
		return (int) (c.getWidth()*value);
	}
	
	private int getSeparationY(float value) {
		return (int) (c.getHeight()*value);
	}
	
	private void drawDivisions(char AxisReference,Graphics2D g2D,int number,int length) {
		if(AxisReference == 'x') {
			drawXDivisions(number, g2D,length);
		}else {
			drawYDivisions(number, g2D, length);
		}
		g2D.setColor(Color.black);
	}
	
	private void drawXDivisions(int number,Graphics2D g2D,int length) {
		int x1= getSeparationX(0.15f);
		int y1=	getSeparationY(0.79f);
		int x2=	getSeparationX(0.15f);
		int y2= getSeparationY(0.81f);
		String[] numbers = new String[] {"3","4","5","6","7","8","9","10","11","12"};
		int increase = length/numbers.length;
		for (int i = 0; i < numbers.length; i++) {
			g2D.setColor(Color.red);
			g2D.drawLine(x1+(i*increase), y1, x2+(i*increase), y2);
			g2D.setColor(Color.black);
			g2D.drawString(numbers[i], x1+(i*increase)-2, y2+11);
			System.err.println( x1+(i*increase)-2);
		}
	}
	
	private void drawYDivisions(int number,Graphics2D g2D,int length) {
		int x1= getSeparationX(0.08f);
		int y1=	getSeparationY(0.1f);
		int x2=	getSeparationX(0.1f);
		int y2= getSeparationY(0.1f);
		int increase = length/number;
		String[] numbers = new String[] {"1.000M","900M","800M","700M",
				"600M","500M","400M","300M","200M","100M"};
		for (int i = 0; i < number; i++) {
			g2D.setColor(Color.red);
			g2D.drawLine(x1, y1+(i*increase), x2, y2+(i*increase));
			g2D.setColor(Color.black);
			g2D.drawString(numbers[i], x1-60, y2+(i*increase));
			System.out.println(y2+(i*increase));
		}
	}
	
	private void drawFunction(Graphics2D g2d,int[] xPoints,int[] yPoints,int nPoints,int lengthX,int lengthY) {
		int[] xPointsTransfrom = parsePointsX(xPoints, lengthX);
		int[] yPointsTransform = parsePointsY(yPoints, lengthY);
		g2d.drawPolyline(xPointsTransfrom, yPointsTransform, nPoints);
	}
	
	private int[] parsePointsX(int[] points,int length) {
		int x1= getSeparationX(0.15f);
		String[] numbers = new String[] {"3","4","5","6","7","8","9","10","11","12"};
		int increase = length/numbers.length;
		int[] transformedPoints = new int[points.length];
		for (int i = 0; i < points.length; i++) {
			transformedPoints[i] = (x1+(i*increase));
		}
		return transformedPoints;
	}
	
	private int[] parsePointsY(int[] points,int length) {
		int y2= getSeparationY(0.1f);
		int increase = length/10;
		int[] transformPoints = new int[points.length];
		for (int i = 0; i < transformPoints.length; i++) {
			transformPoints[i] = (y2+(i*increase)/points[i]);
		}
		return transformPoints;
	}
		
//	public static void main(String[] args) {
//		JDialog jDialog = new JDialog();
//		JPanelGraphics jpg = new JPanelGraphics(jDialog);
//		JScrollPane jsp = new JScrollPane(jpg);
//		jDialog.add(jsp);
//		jDialog.setSize(new Dimension(900,600));
//		jDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//		jDialog.setVisible(true);
//	}
}
