package views.models;

import javax.swing.*;
import java.awt.*;

public class JModelPanel extends JPanel {
    /**
     * Create a new buffered JPanel with the specified layout manager
     *
     * @param layout the LayoutManager to use
     */
    public JModelPanel(LayoutManager layout,Color bg) {
        super(layout);
        this.setBackground(bg);
    }
}
