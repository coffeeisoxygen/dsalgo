package com.coffecode.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import com.coffecode.enums.DataType;
import com.coffecode.enums.SortAlgorithmType;
import com.coffecode.enums.SortOrder;

public class ControlPanel extends JPanel {

    private JComboBox<DataType> dataTypeComboBox;
    private JComboBox<SortAlgorithmType> sortAlgorithmComboBox;
    private JComboBox<SortOrder> sortOrderComboBox;
    private JComboBox<String> inputTypeComboBox;
    private JButton processButton;
    private JSpinner timerSpinner;
    private JTextArea manualInputArea;

    public ControlPanel() {
        setLayout(new GridBagLayout());
        setBorder(new EmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Create components
        JLabel dataTypeLabel = new JLabel("Data Type:");
        dataTypeComboBox = new JComboBox<>(DataType.values());

        JLabel algorithmLabel = new JLabel("Algorithm:");
        sortAlgorithmComboBox = new JComboBox<>(SortAlgorithmType.values());

        JLabel sortOrderLabel = new JLabel("Sort Order:");
        sortOrderComboBox = new JComboBox<>(SortOrder.values());

        JLabel inputTypeLabel = new JLabel("Input Type:");
        inputTypeComboBox = new JComboBox<>(new String[] { "Manual", "Auto" });
        inputTypeComboBox.addActionListener(e -> {
            boolean isManual = "Manual".equals(inputTypeComboBox.getSelectedItem());
            manualInputArea.setEnabled(isManual);
            if (!isManual) {
                manualInputArea.setText("[Auto-generated input will be here]");
            }
        });

        JLabel timerLabel = new JLabel("Timer (ms):");
        timerSpinner = new JSpinner(new SpinnerNumberModel(100, 10, 5000, 10));

        manualInputArea = new JTextArea(5, 20);
        manualInputArea.setEnabled(false);

        processButton = new JButton("Process");

        // Add components to panel
        add(dataTypeLabel, gbc);
        gbc.gridx = 1;
        add(dataTypeComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(algorithmLabel, gbc);
        gbc.gridx = 1;
        add(sortAlgorithmComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(sortOrderLabel, gbc);
        gbc.gridx = 1;
        add(sortOrderComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(inputTypeLabel, gbc);
        gbc.gridx = 1;
        add(inputTypeComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(timerLabel, gbc);
        gbc.gridx = 1;
        add(timerSpinner, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        add(new JLabel("Manual Input:"), gbc);

        gbc.gridy++;
        add(manualInputArea, gbc);

        gbc.gridy++;
        add(new JSeparator(), gbc);

        gbc.gridy++;
        add(processButton, gbc);
    }
}
