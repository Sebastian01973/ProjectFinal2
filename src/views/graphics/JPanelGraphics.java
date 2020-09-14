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

public class JPanelGraphics extends JPanel{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
	
	private Container c;
	private int[] datasX;
	private int[] datasY;

	public JPanelGraphics(Container c,int[] datasX,int[] datasY) {
		this.c = c;
		this.datasX = datasX;
		this.datasY = datasY;
		this.setBackground(Color.white);
		this.initComponenets(c);
	}
	
	private void initComponenets(Container c) {
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D graphics2D = (Graphics2D) g;
		graphics2D.setStroke(new BasicStroke(2));
		int yAxisx = UtilitiesViews.getSeparationAxis('x',0.09f,this.c);
		int yAxisy1 = UtilitiesViews.getSeparationAxis('y',0.05f,this.c);
		int yAxisy2 = UtilitiesViews.getSeparationAxis('y',0.8f,this.c);
		int lengthYAxis = yAxisy2-yAxisy1;
		UtilitiesViews.drawAxis(yAxisx, yAxisy1, yAxisx,yAxisy2,graphics2D);
		String[] labelsY = new String[] {"100K","200K","300K","400K","500K","600K","700K","800K","900K","1M"};
		UtilitiesViews.drawYDivisions(graphics2D, lengthYAxis, labelsY, c);

		int xAxisx1 = UtilitiesViews.getSeparationAxis('x',0.09f,this.c);
		int xAxisx2 = UtilitiesViews.getSeparationAxis('x',0.9f,this.c);
		int xAxisy = UtilitiesViews.getSeparationAxis('y',0.8f,this.c);
		int lengthXAxis = xAxisx2-xAxisx1;
		String[] labelsX = new String[] {"3","4","5","6","7","8","9","10","11","12"};
		UtilitiesViews.drawAxis(xAxisx1, xAxisy, xAxisx2,xAxisy,graphics2D);
		UtilitiesViews.drawXDivisions(graphics2D, lengthXAxis, labelsX, c);

		// grafiac de los datos
		drawFunction(graphics2D, datasX, datasY, datasX.length, lengthXAxis,
				lengthYAxis);

	}
	

	
	private void drawFunction(Graphics2D g2d,int[] xPoints,int[] yPoints,int nPoints,int lengthX,int lengthY) {
		int[] xPointsTransfrom = parsePointsX(xPoints, lengthX,10);
		int[] yPointsTransform = parsePointsY(yPoints, lengthY);
		g2d.drawPolyline(xPointsTransfrom, yPointsTransform, nPoints);
	}

	private int[] parsePointsX(int[] points,int length, int lengthLabelsX) {
		int x = UtilitiesViews.getSeparationAxis('x',0.15f,this.c);
		int transfrmedPoints [] = new int[points.length];
		int increase = length/lengthLabelsX;
		for (int i = 0; i < points.length; i++) {
			transfrmedPoints[i] = x+(i*increase);
		}
		return transfrmedPoints;
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

	public void setDatasX(int[] datasX) {
		this.datasX = datasX;
	}

	public void setDatasY(int[] datasY) {
		this.datasY = datasY;
	}

	public static void main(String[] args) {
		JDialog jDialog = new JDialog();
		JPanelGraphics jpg = new JPanelGraphics(jDialog,new int[] {3,4,5,6,7,8,9,},new int[]{100,200,200,400,500,580,200});
		JScrollPane jsp = new JScrollPane(jpg);
		jDialog.add(jsp);
		jDialog.setSize(new Dimension(900,600));
		jDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		jDialog.setVisible(true);
	}
}
