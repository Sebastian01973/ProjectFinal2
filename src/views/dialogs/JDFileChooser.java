package views.dialogs;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import views.Constant;
import views.models.JModelLabel;

public class JDFileChooser extends JDialog{
	private JFileChooser jFChooser;
	
	public JDFileChooser(ActionListener actionL) {
		this.setBackground(Constant.COLOR_WHITE);
		this.setLayout(new BorderLayout());
		this.setSize(new Dimension(600,600));
		this.setIconImage(new ImageIcon(getClass().getResource(Constant.IMG_ICON_DIALOG_SAVE)).getImage());
		initComponents(actionL);
	}
	
	private void initComponents(ActionListener actionL) {
//		try {
////			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//
////			UIManager.setLookAndFeel(NimbusLookAndFeel.class.getName());
//		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
//				| UnsupportedLookAndFeelException e) {
//			e.printStackTrace();
//		}
		JModelLabel labelMessage = new JModelLabel("Escriba el nombre del archivo con su extensión", Constant.COLOR_WHITE, Constant.COLOR_BLACK);
		this.add(labelMessage,BorderLayout.NORTH);
		jFChooser = new JFileChooser(new File("resources/out"));
		jFChooser.addActionListener(actionL);
		jFChooser.updateUI();
		String[] extensions = new String[] {"XML","json","txt","bin"};
		FileNameExtensionFilter filterFile = new FileNameExtensionFilter("XML,json,txt,bin",extensions);
		jFChooser.setFileFilter(filterFile);
		jFChooser.setApproveButtonText("Guardar");
		jFChooser.updateUI();
		jFChooser.setAcceptAllFileFilterUsed(false);
		this.add(jFChooser);
	}

	private static void refreshUI(JComponent c, boolean includeParent)
	{
		if (includeParent)
			c.updateUI();

		for (int i = 0; i < c.getComponentCount(); i++)
		{
			Component child = c.getComponent(i);
			if (child instanceof JComponent)
			{
				refreshUI((JComponent)child, true);
			}
		}
	}

	public String getPath() {
		return jFChooser.getSelectedFile().getName();
	}
	
	public void showDialog(boolean isVisible) {
		this.setVisible(isVisible);
	}
}
