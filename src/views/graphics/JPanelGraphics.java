package views.graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import utilities.UtilitiesViews;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class JPanelGraphics extends  JPanel{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
	
	private int[] datasX;
	private int[] datasY;

	public JPanelGraphics(int[] datasX,int[] datasY) {
		this.datasX = datasX;
		this.datasY = datasY;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D graphics2D = (Graphics2D) g;
		graphics2D.setColor(Color.white);
		graphics2D.fillRect(0, 0, this.getWidth(), this.getHeight());
		graphics2D.setColor(Color.black);
		graphics2D.setStroke(new BasicStroke(2));
		int yAxisx = UtilitiesViews.getSeparationAxis('x',0.09f,this);
		int yAxisy1 = UtilitiesViews.getSeparationAxis('y',0.05f,this);
		int yAxisy2 = UtilitiesViews.getSeparationAxis('y',0.8f,this);
		int lengthYAxis = yAxisy2-yAxisy1;
		UtilitiesViews.drawAxis(yAxisx, yAxisy1, yAxisx,yAxisy2,graphics2D);
		String[] labelsY = new String[] {"1K","2K","3K","4K","5K","6K","7K","8K","9K","10K"};
		UtilitiesViews.drawYDivisions(graphics2D, lengthYAxis, labelsY,this);

		int xAxisx1 = UtilitiesViews.getSeparationAxis('x',0.09f,this);
		int xAxisx2 = UtilitiesViews.getSeparationAxis('x',0.9f,this);
		int xAxisy = UtilitiesViews.getSeparationAxis('y',0.8f,this);
		int lengthXAxis = xAxisx2-xAxisx1;
		String[] labelsX = new String[] {"6","7","8","9"};
		UtilitiesViews.drawAxis(xAxisx1, xAxisy, xAxisx2,xAxisy,graphics2D);
		UtilitiesViews.drawXDivisions(graphics2D, lengthXAxis, labelsX, this);

		// grafiac de los datos
		drawFunction(graphics2D, datasX, datasY, datasX.length, lengthXAxis,
				lengthYAxis);
	}
	

	
	private void drawFunction(Graphics2D g2d,int[] xPoints,int[] yPoints,int nPoints,int lengthX,int lengthY) {
		int[] xPointsTransfrom = parsePointsX(xPoints, lengthX,4);
		int[] yPointsTransform = parsePointsY(yPoints, lengthY);
		g2d.drawPolyline(xPointsTransfrom, yPointsTransform, nPoints);
		drawPoint(xPointsTransfrom, yPointsTransform, g2d);
	}

	private int[] parsePointsX(int[] points,int length, int lengthLabelsX) {
		int x = UtilitiesViews.getSeparationAxis('x',0.15f,this);
		int transfrmedPoints [] = new int[points.length];
		int increase = length/lengthLabelsX;
		for (int i = 0; i < points.length; i++) {
			transfrmedPoints[i] = x+(i*increase);
		}
		return transfrmedPoints;
	}
	
	public void drawPoint(int[] parsePointsX,int[] parsePointsY,Graphics2D g2d) {
		g2d.setColor(Color.red);
		for (int i = 0; i < parsePointsY.length; i++) {
			g2d.fillOval(parsePointsX[i]-5, parsePointsY[i]-5, 10, 10);
		}
		g2d.setColor(Color.black);
	}
	
	private int[] parsePointsY(int[] points,int length) {
		int sizeDivision = length/10;
		int transformedPoints [] = new int[points.length];
		for (int i = 0; i < points.length; i++) {
			int value = length-(points[i]/100)*sizeDivision+sizeDivision;
			value = value == 0? value+sizeDivision:value;
			value = value > length? length:value;
			transformedPoints[i] = value;
		}
		return transformedPoints;
	}

	public void setDatas(int[] datasX,int[] datasY){
		this.datasX = datasX;
		this.datasY = datasY;
	}

	public void setDatasX(int[] datasX) {
		this.datasX = datasX;
	}

	public void setDatasY(int[] datasY) {
		this.datasY = datasY;
	}
}
