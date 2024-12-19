package com.coffecode.ui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.coffecode.enums.DataType;
import com.coffecode.enums.SortAlgorithmType;
import com.coffecode.enums.SortOrder;

import net.miginfocom.swing.MigLayout;

public class ControlPanel extends JPanel {

    private JComboBox<DataType> dataTypeComboBox;
    private JComboBox<SortAlgorithmType> sortAlgorithmComboBox;
    private JComboBox<SortOrder> sortOrderComboBox;
    private JComboBox<String> inputTypeComboBox;
    private JButton processButton;
    private JSpinner timerSpinner;

    public ControlPanel() {
        setLayout(new MigLayout("", "[][grow][][]", ""));

        // Create components
        JLabel dataTypeLabel = new JLabel("Data Type:");
        dataTypeComboBox = new JComboBox<>(DataType.values());

        JLabel algorithmLabel = new JLabel("Algorithm:");
        sortAlgorithmComboBox = new JComboBox<>(SortAlgorithmType.values());

        JLabel sortOrderLabel = new JLabel("Sort Order:");
        sortOrderComboBox = new JComboBox<>(SortOrder.values());

        JLabel inputTypeLabel = new JLabel("Input Type:");
        inputTypeComboBox = new JComboBox<>(new String[] { "Manual", "Auto" });

        JLabel timerLabel = new JLabel("Timer (ms):");
        timerSpinner = new JSpinner(new SpinnerNumberModel(100, 10, 5000, 10));

        processButton = new JButton("Process");

        // Add components to panel
        add(dataTypeLabel, "gapright 10");
        add(dataTypeComboBox, "growx, wrap");

        add(algorithmLabel, "gapright 10");
        add(sortAlgorithmComboBox, "growx, wrap");

        add(sortOrderLabel, "gapright 10");
        add(sortOrderComboBox, "growx, wrap");

        add(inputTypeLabel, "gapright 10");
        add(inputTypeComboBox, "growx, wrap");

        add(timerLabel, "gapright 10");
        add(timerSpinner, "growx, wrap");

        add(processButton, "span, align center");

        // Action listener for process button
        processButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Placeholder for processing logic
                System.out.println("Process initiated with:");
                System.out.println("Data Type: " + dataTypeComboBox.getSelectedItem());
                System.out.println("Algorithm: " + sortAlgorithmComboBox.getSelectedItem());
                System.out.println("Sort Order: " + sortOrderComboBox.getSelectedItem());
                System.out.println("Input Type: " + inputTypeComboBox.getSelectedItem());
                System.out.println("Timer: " + timerSpinner.getValue() + " ms");
            }
        });
    }
}
