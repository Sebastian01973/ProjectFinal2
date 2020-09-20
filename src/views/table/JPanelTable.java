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

import static javax.swing.JOptionPane.showMessageDialog;

public class JPanelTable extends JPanel implements Language {

    private DefaultTableModel dtmElements;
    private JTable jtElements;
    private JScrollPane jScrollPane;
    private String[] headers;

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
        jtElements.getTableHeader().setResizingAllowed(false);

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

    public int getSelectRow() {
        return jtElements.getSelectedRow();
    }

    public int getSelectedRow() {
        if (jtElements.getSelectedRow() ==-1) {
            showMessageDialog(null,"No a seleccionado el objeto");
            return -3;
        }else {
            dtmElements.getValueAt(jtElements.getSelectedRow(), 0);
            return (int) dtmElements.getValueAt(jtElements.getSelectedRow(),0);
        }
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

    public void addElementToTable(Object[] vector,boolean status){
        if (status){
            vector[1] = Utilities.getKey(String.valueOf(vector[1]));
            vector[3] = Utilities.getKey(String.valueOf(vector[3]));
            vector[5] = Utilities.getKey(String.valueOf(vector[5]));
            vector[6] = UtilitiesViews.toFormatterDate((LocalDate) vector[6]);
            vector[7] = UtilitiesViews.toFormatterDate((LocalDate) vector[7]);
            vector[8] = UtilitiesViews.toFormatterDate((LocalDate) vector[8]);
            dtmElements.addRow(vector);
        }else{
            dtmElements.addRow(vector);
        }

    }

    public void addElementToTable(ArrayList<Object[]> matrix){
        cleanRowsTable();
        dtmElements.setColumnIdentifiers(Utilities.getKeys(Constant.HEADERDS_TABLEMAIN));
        UtilitiesViews.getModelColumn(jtElements, 0, 75, 75, 75);
        UtilitiesViews.getModelColumn(jtElements, 2, 55, 55, 55);
        this.centerText();
        for (Object[] objects : matrix) {
            addElementToTable(objects,true);
        }
    }

    public void addElementToTable(ArrayList<Object[]> matrix,String[] header){
        cleanRowsTable();
        this.headers = header;
        dtmElements.setColumnIdentifiers(Utilities.getKeys(headers));
        this.centerText();
        for (Object[] objects : matrix) {
            addElementToTable(objects,false);
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
        if (jtElements.getColumnCount() == Constant.HEADERDS_TABLEMAIN.length){
            dtmElements.setColumnIdentifiers(Utilities.getKeys(Constant.HEADERDS_TABLEMAIN));
            this.centerText();
            UtilitiesViews.getModelColumn(jtElements, 0, 75, 75, 75);
            UtilitiesViews.getModelColumn(jtElements, 2, 55, 55, 55);
        }else{
            dtmElements.setColumnIdentifiers(Utilities.getKeys(headers));
            this.centerText();
        }
    }
}
