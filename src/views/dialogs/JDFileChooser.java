package views.dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

import views.Constant;

public class JDFileChooser extends JDialog{
	private JFileChooser jFChooser;
	
	public JDFileChooser(ActionListener actionL) {
		this.setBackground(Constant.COLOR_WHITE);
		this.setLayout(new BorderLayout());
		this.setSize(new Dimension(600,600));
		initComponents(actionL);
	}
	
	private void initComponents(ActionListener actionL) {
		jFChooser = new JFileChooser(new File("resources/out"));
		jFChooser.addActionListener(actionL);
//		try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
//				| UnsupportedLookAndFeelException e) {
//			e.printStackTrace();
//		}
		String[] extensions = new String[] {"XML","json","txt","bin"};
		FileNameExtensionFilter filterFile = new FileNameExtensionFilter("XML,json,txt,bin",extensions);
		jFChooser.setFileFilter(filterFile);
		jFChooser.setApproveButtonText("Guardar");
		jFChooser.updateUI();
		this.add(jFChooser);
	}
	
	public String getPath() {
		return jFChooser.getSelectedFile().getName();
	}
	
	public void showDialog(boolean isVisible) {
		this.setVisible(isVisible);
	}
}
