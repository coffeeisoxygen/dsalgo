package com.coffecode.ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ResultPanel extends JPanel {

    private JTable resultTable;

    public ResultPanel() {
        setLayout(new BorderLayout());

        resultTable = new JTable(
                new DefaultTableModel(new Object[] { "Algorithm", "Order", "Time (ms)", "Result" }, 0));
        add(resultTable.getTableHeader(), BorderLayout.NORTH);
        add(resultTable, BorderLayout.CENTER);
    }
}