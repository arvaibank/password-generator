package ltd.arvai.application;

import ltd.arvai.display.GUI;

import javax.swing.*;

public class Application {
    public void generate() {
        SwingUtilities.invokeLater(() -> new GUI());
    }
}
