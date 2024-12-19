package com.coffecode.handlers;

import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import com.coffecode.controllers.ItemsController;
import com.coffecode.enums.DataType;
import com.coffecode.enums.InputType;

public class DataPreparationHandler<T extends Comparable<T>> {

    private final ItemsController<T> controller;
    private DataType currentDataType;

    public DataPreparationHandler(ItemsController<T> controller) {
        this.controller = controller;
        this.currentDataType = null;
    }

    @SuppressWarnings("unchecked")
    private List<T> castList(List<?> list) {
        return (List<T>) list;
    }

    public void handleGenerateButton(DataType dataType, InputType inputType) {
        if (controller.getItemSize() > 0 && currentDataType != null && currentDataType != dataType) {
            JOptionPane.showMessageDialog(null,
                    "Data sebelumnya adalah tipe " + currentDataType + ". Harap masukkan data yang sejenis.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (inputType == InputType.MANUALINPUT) {
            String input = JOptionPane.showInputDialog(null, getInputMessage(dataType), "Manual Input",
                    JOptionPane.PLAIN_MESSAGE);
            if (input != null && !input.trim().isEmpty()) {
                if (isValidInput(dataType, input)) {
                    List<T> items = parseInput(dataType, input);
                    controller.addItemsFromUserInput(items);
                    currentDataType = dataType;
                } else {
                    JOptionPane.showMessageDialog(null, "Input tidak valid. Silakan coba lagi.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (inputType == InputType.AUTOINPUT) {
            if (dataType == DataType.STRING) {
                controller.addRandomStrings(5, 10); // Example parameters
            } else if (dataType == DataType.INTEGER) {
                controller.addRandomIntegers(1, 100, 10); // Example parameters
            }
            currentDataType = dataType;
        }
    }

    private String getInputMessage(DataType dataType) {
        if (dataType == DataType.STRING) {
            return "Masukkan kata yang diinginkan, pisahkan dengan koma (,)";
        } else if (dataType == DataType.INTEGER) {
            return "Masukkan angka yang diinginkan, pisahkan dengan koma (,)";
        }
        return "";
    }

    private boolean isValidInput(DataType dataType, String input) {
        if (dataType == DataType.STRING) {
            return input.matches("^[a-zA-Z,\\s]+$");
        } else if (dataType == DataType.INTEGER) {
            return input.matches("^[0-9,\\s]+$");
        }
        return false;
    }

    private List<T> parseInput(DataType dataType, String input) {
        if (dataType == DataType.STRING) {
            return castList(Arrays.stream(input.split(","))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .toList());
        } else if (dataType == DataType.INTEGER) {
            return castList(Arrays.stream(input.split(","))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .map(Integer::valueOf)
                    .toList());
        }
        return List.of();
    }
}