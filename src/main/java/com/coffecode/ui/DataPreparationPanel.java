package com.coffecode.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.coffecode.enums.DataType;
import com.coffecode.enums.InputType;

public class DataPreparationPanel extends JPanel {

    private final JComboBox<DataType> dataTypeComboBox;
    private final JComboBox<InputType> inputTypeComboBox;
    private final JButton generateButton;
    private final JButton resetButton;
    private final JTable dataTable;

    public DataPreparationPanel() {
        setLayout(new GridBagLayout());
        setBorder(new TitledBorder("Prepare Data"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Create components
        JLabel dataTypeLabel = new JLabel("Data Type:");
        dataTypeComboBox = new JComboBox<>(DataType.values());

        JLabel inputTypeLabel = new JLabel("Input Type:");
        inputTypeComboBox = new JComboBox<>(InputType.values());

        generateButton = new JButton("Generate");
        resetButton = new JButton("Reset");

        dataTable = new JTable(new DefaultTableModel(new Object[] { "Index", "Value" }, 0));
        JScrollPane scrollPane = new JScrollPane(dataTable);

        // Add components to panel
        add(dataTypeLabel, gbc);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        add(dataTypeComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.weightx = 0;
        add(inputTypeLabel, gbc);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        add(inputTypeComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.weightx = 0;
        add(generateButton, gbc);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        add(resetButton, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(scrollPane, gbc);
    }
}