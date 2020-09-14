package views.graphics;

import java.awt.BasicStroke;
import java.awt.Color;
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
	private String[] labelsData;
	private Color[] colors;
	private int[] datas;
	
	public JPBarGraphic(Container container,String[] labelsX,String[] labelsY,int[] datas,String[] labelsDt,Color[]colors) {
		this.container = container;
		this.labelsX = labelsX;
		this.labelsY = labelsY;
		this.datas = datas;
		this.colors = colors;
		this.labelsData = labelsDt;
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
		int width = (int)(lengthXAxis*0.05f);
		int height = (int) (lengthYAxis*(value/100.0)-yAxisy1/2);
		x = x-width/2;
		int y = (int) ((100-value)/100.0*lengthYAxis+increaseY);
		graphics2d.fillRect(x, y, width, height);
	}
	
	public void drawDatas(int[] datasY,Graphics2D graphics2d, int lengthXAxis,int lengthYAxis,int yAxisy1) {
		int x = UtilitiesViews.getSeparationAxis('x', 0.75f, container);
		int x1 = UtilitiesViews.getSeparationAxis('x', 0.8f, container);
		int y = UtilitiesViews.getSeparationAxis('y', 0.15f, container);
		int y1 = UtilitiesViews.getSeparationAxis('y', 0.17f, container);
		int increase = (int) (container.getHeight()*0.075f);
		for (int i = 0; i < datasY.length; i++) {
			drawBar(graphics2d, datasY[i], lengthXAxis, i, lengthYAxis, yAxisy1);
			drawLabels(labelsData[i], graphics2d, Color.black, x, y, x1, y1);
			y += increase;
			y1 += increase;
		}
	}
	
	private void drawLabels(String label,Graphics2D graphics2d,Color color,int x,int y,int x1,int y1) {
		int width = UtilitiesViews.getSeparationAxis('x', 0.05f, container);
		int height = UtilitiesViews.getSeparationAxis('x', 0.03f, container);
		graphics2d.setColor(color);
		graphics2d.fillRect(x, y, width, height);
		graphics2d.drawString(label, x1, y1);
	}

	public static void main(String[] args) {
		JDialog jDialog = new JDialog();
		JPBarGraphic jpg = new JPBarGraphic(jDialog,new String[] {"1","2","3","4","5","6","7","8"},new String[] {
				"10%","20%","30%","40%","50%","60%","70%","80%","90%","100%"
		},new int[] {22,33,45,88,70,40,80,90},new String[] {"Data1","Data","Data","Data","Data"
				,"Data","Data7","Data8"},new Color[] {Color.red});
		JScrollPane jsp = new JScrollPane(jpg);
		jDialog.add(jsp);
		jDialog.setSize(new Dimension(500,600));
		jDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		jDialog.setVisible(true);
	}
}
