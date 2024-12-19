package com.coffecode;

import javax.swing.SwingUtilities;

import com.coffecode.ui.MainFrame;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.fonts.jetbrains_mono.FlatJetBrainsMonoFont;

public class App {

    public static void main(String[] args) {
        // Set FlatLaf look and feel
        FlatJetBrainsMonoFont.install();

        FlatLightLaf.setup();

        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}
