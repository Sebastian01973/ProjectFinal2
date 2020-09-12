package views.graphics;

import java.awt.BasicStroke;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import utilities.UtilitiesViews;

public class JPBarGraphic extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container container;
	private String[] labelsX;
	private String[] labelsY;
	private int[] datas;
	
	public JPBarGraphic(Container container,String[] labelsX,String[] labelsY,int[] datas) {
		this.container = container;
		this.labelsX = labelsX;
		this.labelsY = labelsY;
		this.datas = datas;
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.setStroke(new BasicStroke(2));
		//eje y
		int yAxisx = UtilitiesViews.getSeparationAxis('x',0.09f,this.container);
		int yAxisy1 = UtilitiesViews.getSeparationAxis('y',0.05f,this.container);
		int yAxisy2 = UtilitiesViews.getSeparationAxis('y',0.8f,this.container);
		int lengthYAxis = yAxisy2-yAxisy1; 
		UtilitiesViews.drawAxis(yAxisx, yAxisy1, yAxisx,yAxisy2,graphics2d);
		UtilitiesViews.drawYDivisions(graphics2d, lengthYAxis, labelsY, container);
		
		//eje x
		int xAxisx1 = UtilitiesViews.getSeparationAxis('x',0.09f,container);
		int xAxisx2 = UtilitiesViews.getSeparationAxis('x',0.7f,container);
		int xAxisy = UtilitiesViews.getSeparationAxis('y',0.8f,container);
		int lengthXAxis = xAxisx2-xAxisx1;		
		UtilitiesViews.drawAxis(xAxisx1, xAxisy, xAxisx2,xAxisy,graphics2d);
		UtilitiesViews.drawXDivisions(graphics2d, lengthXAxis, labelsX, container);
		drawDatas(datas, graphics2d, lengthXAxis, lengthYAxis, yAxisy1);
	}
	
	public void drawBar(Graphics2D graphics2d,int value,int lengthXAxis,int index,int lengthYAxis,int yAxisy1) {
		int increaseX = lengthXAxis/labelsX.length;
		int increaseY = lengthYAxis/labelsY.length;
		int x = UtilitiesViews.getSeparationAxis('x',0.15f,this.container)+(index*increaseX);
		int width = (int)(lengthXAxis*0.1f);
		int height = (int) (lengthYAxis*(value/100.0)-yAxisy1/2);
		x = x-width/2;
		int y = (int) ((100-value)/100.0*lengthYAxis+increaseY);
		graphics2d.fillRect(x, y, width, height);
	}
	
	public void drawDatas(int[] datasY,Graphics2D graphics2d, int lengthXAxis,int lengthYAxis,int yAxisy1) {
		for (int i = 0; i < datasY.length; i++) {
			drawBar(graphics2d, datasY[i], lengthXAxis, i, lengthYAxis, yAxisy1);
		}
	}

	public static void main(String[] args) {
		JDialog jDialog = new JDialog();
		JPBarGraphic jpg = new JPBarGraphic(jDialog,new String[] {"1","2","3","4","5","6","7","8","9"},new String[] {
				"10%","20%","30%","40%","50%","60%","70%","80%","90%","100%"
		},new int[] {22,33,45,88,70,40,80,90,99});
		JScrollPane jsp = new JScrollPane(jpg);
		jDialog.add(jsp);
		jDialog.setSize(new Dimension(500,600));
		jDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		jDialog.setVisible(true);
	}
}
