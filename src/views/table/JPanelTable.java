package views.table;

import utilities.Utilities;
import utilities.UtilitiesViews;
import views.Constant;
import views.Language;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class JPanelTable extends JPanel implements Language {

    private DefaultTableModel dtmElements;
    private JTable jtElements;
    private JScrollPane jScrollPane;

    public JPanelTable(ActionListener actionListener){
        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        this.setBackground(Constant.COLOR_WHITE);
        dtmElements = new DefaultTableModel() {

            private static final long serialVersionUID = 1L;
            @Override
            public boolean isCellEditable(int arg0, int arg1) {
                return false;
            }

        };
        dtmElements.setColumnIdentifiers(Utilities.getKeys(Constant.HEADERDS_TABLEMAIN));
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        jtElements = new JTable();
        jtElements.setModel(dtmElements);
        jtElements.setIntercellSpacing(new Dimension(0, 0));
        jtElements.getTableHeader().setReorderingAllowed(false);
        jtElements.getTableHeader().setBackground(Constant.COLOR_BLUE_COVID);
        jtElements.getTableHeader().setForeground(Constant.COLOR_WHITE);
        jtElements.getTableHeader().setPreferredSize(new Dimension(0, 50));
        jtElements.getTableHeader().setFont(Constant.FONT_ARIAL_ROUNDER_17);

        jtElements.setFont(Constant.FONT_ARIAL_ROUNDER_15);
        jtElements.setBackground(Constant.COLOR_WHITE);
        jtElements.setFillsViewportHeight(false);
        jtElements.setRowHeight( 35 );
        jtElements.setBorder(null);

        jScrollPane = new JScrollPane(jtElements);
        jScrollPane.setForeground(Color.white);
        jScrollPane.setBorder(null);
        jScrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.add(jScrollPane, BorderLayout.PAGE_END);
        this.setBorder(null);
    }

    public void cleanRowsTable() {
        dtmElements.setNumRows(0);
    }

    public DefaultTableModel getDefaultTableModel() {
        return dtmElements;
    }

    public void setDefaultTableModel(DefaultTableModel defaultTableModel) {
        this.dtmElements = defaultTableModel;
    }

    public void addElementToTable(Object[] vector){
        vector[6] = UtilitiesViews.toFormatterDate((LocalDate) vector[6]);
        vector[7] = UtilitiesViews.toFormatterDate((LocalDate) vector[7]);
        vector[8] = UtilitiesViews.toFormatterDate((LocalDate) vector[8]);
        dtmElements.addRow(vector);
    }

    public void addElementToTable(ArrayList<Object[]> matrix){
        cleanRowsTable();
        dtmElements.setColumnIdentifiers(Utilities.getKeys(Constant.HEADERDS_TABLEMAIN));
        for (Object[] objects : matrix) {
            addElementToTable(objects);
        }
    }

    private void centerText() {
        DefaultTableCellRenderer centeRenderer = new DefaultTableCellRenderer();
        centeRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < jtElements.getColumnCount(); i++) {
            jtElements.getColumnModel().getColumn(i).setCellRenderer(centeRenderer);
        }
    }

    public void deleteRowIndex(int index) {
        dtmElements.removeRow(index);
    }

    @Override
    public void changeLanguage() {
        dtmElements.setColumnIdentifiers(Utilities.getKeys(Constant.HEADERDS_TABLEMAIN));
    }
}
