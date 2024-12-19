package com.coffecode;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.coffecode.ui.MainFrame;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.fonts.jetbrains_mono.FlatJetBrainsMonoFont;

public class App {

    public static void main(String[] args) {
        // Set FlatLaf look and feel
        FlatJetBrainsMonoFont.install();
        UIManager.put("Component.focusWidth", 2);
        FlatDarculaLaf.setup();

        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}
