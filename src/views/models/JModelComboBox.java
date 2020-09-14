package views.models;

import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.plaf.basic.BasicComboBoxUI;


import views.Constant;

public class JModelComboBox extends JComboBox<Object>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JModelComboBox(Object[] objects,String title,Font font) {
		super(objects);
		this.setFont(font);
		this.setBackground(Constant.COLOR_WHITE);
		this.setBorder(BorderFactory.createTitledBorder(title));
		setUI(propieties.createUI(getRootPane()));		
	}
	
	public void setItems(Object[] objects) {
		this.removeAllItems();
		for (int i = 0; i < objects.length; i++) {
			this.addItem(objects[i]);
		}
	}
	
	public static class propieties extends BasicComboBoxUI{
		
		public static BasicComboBoxUI createUI(JComponent component) {
			return new propieties();
		}

//		@Override
//		protected JButton createArrowButton() {
////			JModelButton jModelButton = new JModelButton(Constant.IMG_ARROW_DOWN);
////			jModelButton.setBorder(BorderFactory.createLineBorder(Constant.COLOR_COMBO_BOX,2));
////			jModelButton.setContentAreaFilled(false);
////			return jModelButton;
//		}

		@Override
		public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
			g.setColor(null);
			g.fillRect(bounds.x,bounds.y, bounds.width, bounds.height);
		}

		@Override
		protected ListCellRenderer createRenderer() {
		
			return new DefaultListCellRenderer() {

				@Override
				public Component getListCellRendererComponent(JList<?> list, Object value, int index,
						boolean isSelected, boolean cellHasFocus) {
					 super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
					 list.setSelectionBackground(null);
					 
					 if (index !=- 1) {
						setIcon(new ImageIcon(getClass().getResource("")));
					 }
					 return this;
				}
			};
		}
		
		
	}
}
