package ltd.arvai.application;

import ltd.arvai.display.GUI;
import ltd.arvai.display.Input;
import ltd.arvai.display.Output;
import ltd.arvai.file_handle.WriteFile;
import ltd.arvai.logic.Generator;
import ltd.arvai.validator.InputValidator;

import javax.swing.*;
import java.io.IOException;

public class Application {
    public void generate() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUI();
            }
        });
    }
}
