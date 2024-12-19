package com.coffecode.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.coffecode.controllers.ItemsController;
import com.coffecode.enums.SortAlgorithmType;
import com.coffecode.enums.SortOrder;

public class AlgorithmSettingsPanel<T extends Comparable<T>> extends JPanel {

    private JComboBox<SortAlgorithmType> algorithmComboBox;
    private JComboBox<SortOrder> sortOrderComboBox;
    private JTextField memoryField;
    private JTextField timeUseField;
    private JTextArea descriptionArea;
    private ItemsController<T> controller;

    public AlgorithmSettingsPanel(ItemsController<T> controller) {
        this.controller = controller;
        setLayout(new GridBagLayout());
        setBorder(new TitledBorder("Algorithm Settings"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Create components
        JLabel algorithmLabel = new JLabel("Algorithm:");
        algorithmComboBox = new JComboBox<>(SortAlgorithmType.values());

        JLabel sortOrderLabel = new JLabel("Sort Order:");
        sortOrderComboBox = new JComboBox<>(SortOrder.values());

        JLabel memoryLabel = new JLabel("Memory:");
        memoryField = new JTextField(20);
        memoryField.setEditable(false);

        JLabel timeUseLabel = new JLabel("Time Use:");
        timeUseField = new JTextField(20);
        timeUseField.setEditable(false);

        descriptionArea = new JTextArea(5, 20);
        descriptionArea.setBorder(new TitledBorder("Description"));
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea);

        JButton setAlgorithmButton = new JButton("Set Algorithm");

        // Add components to panel
        add(algorithmLabel, gbc);
        gbc.gridx = 1;
        add(algorithmComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(sortOrderLabel, gbc);
        gbc.gridx = 1;
        add(sortOrderComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(memoryLabel, gbc);
        gbc.gridx = 1;
        add(memoryField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(timeUseLabel, gbc);
        gbc.gridx = 1;
        add(timeUseField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(descriptionScrollPane, gbc);

        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(setAlgorithmButton, gbc);

        // Add action listener to set algorithm button
        setAlgorithmButton.addActionListener(e -> {
            SortAlgorithmType selectedAlgorithm = (SortAlgorithmType) algorithmComboBox.getSelectedItem();
            if (selectedAlgorithm != null) {
                controller.setSortStrategy(selectedAlgorithm);
                JOptionPane.showMessageDialog(this, "Sort algorithm set to: " + selectedAlgorithm);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a sort algorithm.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}