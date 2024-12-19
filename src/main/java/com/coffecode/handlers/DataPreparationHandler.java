package com.coffecode.handlers;

import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import com.coffecode.controllers.ItemsController;
import com.coffecode.enums.DataType;
import com.coffecode.enums.InputType;

public class DataPreparationHandler<T extends Comparable<T>> {

    private final ItemsController<T> controller;

    public DataPreparationHandler(ItemsController<T> controller) {
        this.controller = controller;
    }

    @SuppressWarnings("unchecked")
    private List<T> castList(List<?> list) {
        return (List<T>) list;
    }

    public void handleInputTypeChange(DataType dataType, InputType inputType) {
        controller.resetItems();

        if (inputType == InputType.MANUALINPUT) {
            String input = JOptionPane.showInputDialog(null, getInputMessage(dataType), "Manual Input",
                    JOptionPane.PLAIN_MESSAGE);
            if (input != null && !input.trim().isEmpty() && isValidInput(dataType, input)) {
                List<T> items = parseInput(dataType, input);
                controller.addItemsFromUserInput(items);
            } else {
                JOptionPane.showMessageDialog(null, "Input tidak valid. Silakan coba lagi.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void handleGenerateButton(DataType dataType, InputType inputType) {
        if (dataType == DataType.STRING && inputType == InputType.AUTOINPUT) {
            controller.addRandomStrings(5, 10); // Example parameters
        } else if (dataType == DataType.INTEGER && inputType == InputType.AUTOINPUT) {
            controller.addRandomIntegers(1, 100, 10); // Example parameters
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