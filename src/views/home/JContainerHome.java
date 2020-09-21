package views.home;

import views.Constant;
import views.Language;
import views.models.GridModel;

import javax.swing.*;

import utilities.Utilities;
import utilities.UtilitiesViews;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

public class JContainerHome extends JPanel implements Language{

	private static final long serialVersionUID = 1L;
	private JPanelNorth jPNorth;
	private JPanelCenter jPCenter;
	private JPFooter jPfooter;
	private GridModel grid;
	
	/**Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    public JContainerHome(ActionListener actionListener) {
    	grid = new GridModel(this);
    	this.setLayout(new GridBagLayout());
        this.setBackground(Constant.COLOR_WHITE);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
    	jPNorth = new JPanelNorth();
    	this.add(jPNorth,grid.insertComponent(0, 0, 1, 1, 1, GridBagConstraints.FIRST_LINE_START,
    			GridBagConstraints.BOTH));
    	
    	jPCenter = new JPanelCenter();
    	this.add(jPCenter, grid.insertComponent(1, 0, 1, 1,1,GridBagConstraints.FIRST_LINE_START,
    			GridBagConstraints.BOTH));
    	
    	jPfooter = new JPFooter();
    	this.add(jPfooter,grid.insertComponent(2, 0, 1, 1, 1, GridBagConstraints.FIRST_LINE_START, 
    			GridBagConstraints.BOTH));
    }

	@Override
	public void changeLanguage() {
		this.jPCenter.changeLanguage();
		this.jPfooter.changeLanguage();
	}
	
	public void setValues(int cases,int casesDeath,int casesRecuperated) {
		jPCenter.uptadeValues(cases, casesDeath, casesRecuperated);
	}
}
