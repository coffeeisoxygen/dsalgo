package com.coffecode.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.coffecode.controllers.ItemsController;
import com.coffecode.enums.DataType;
import com.coffecode.enums.InputType;

public class DataPreparationPanel<T extends Comparable<T>> extends JPanel {

    private JComboBox<DataType> dataTypeComboBox;
    private JComboBox<InputType> inputTypeComboBox;
    private JButton generateButton;
    private JButton resetButton;
    private JTable dataTable;
    private ItemsController<T> controller;

    public DataPreparationPanel(ItemsController<T> controller) {
        this.controller = controller;
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

        // Add action listeners
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleGenerateButton();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleResetButton();
            }
        });
    }

    private void handleGenerateButton() {
        DataType dataType = (DataType) dataTypeComboBox.getSelectedItem();
        InputType inputType = (InputType) inputTypeComboBox.getSelectedItem();

        if (dataType == DataType.STRING && inputType == InputType.AUTOINPUT) {
            controller.addRandomStrings(5, 10); // Example parameters
        } else if (dataType == DataType.INTEGER && inputType == InputType.AUTOINPUT) {
            controller.addRandomIntegers(1, 100, 10); // Example parameters
        }

        updateTable();
    }

    private void handleResetButton() {
        controller.resetItems();
        updateTable();
    }

    private void updateTable() {
        DefaultTableModel model = (DefaultTableModel) dataTable.getModel();
        model.setRowCount(0);

        int index = 0;
        for (T item : controller.getItemList()) {
            model.addRow(new Object[] { index++, item.toString() });
        }
    }
}