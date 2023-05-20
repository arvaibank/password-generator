package ltd.arvai.display;

import ltd.arvai.file_handle.ReadFile;
import ltd.arvai.file_handle.WriteFile;
import ltd.arvai.logic.Generator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

public class GUI implements ActionListener {
    private JLabel systemLabel;
    private JFrame frame;
    private JPanel panel;
    private JPanel containerPanel;
    private JButton button;
    private JTextField textField;
    private int passwordLength;
    private String website = "starterValue";
    private String password = "starterValue";

    public GUI() {
        frame = new JFrame();
        button = new JButton("Gyerünk!");
        systemLabel = new JLabel("Melyik oldalhoz generáljam a jelszót?");
        containerPanel = new JPanel(new BorderLayout());
        panel = new JPanel();
        textField = new JTextField();

        button.addActionListener(this);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Jelszó generátor");
        frame.add(containerPanel, BorderLayout.CENTER);

        containerPanel.add(panel, BorderLayout.CENTER);
        frame.add(containerPanel);

        listPasswords();
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!website.equals("starterValue")) {
            if (website.equals("")) {
                setWebsite();
                systemLabel.setText("Milyen hosszú legyen a jelszó?");
            } else {
                generatePassword();

                website = "";
                password = "";

                systemLabel.setText("Melyik oldalhoz generáljam a jelszót?");
            }
        } else {
            if (password.equals("")) {
                generatePassword();
                systemLabel.setText("Melyik oldalhoz generáljam a jelszót?");
            } else {
                setWebsite();
                systemLabel.setText("Milyen hosszú legyen a jelszó?");
            }
        }
    }

    private void generatePassword() {
        Generator generator = new Generator();
        WriteFile writeFile = new WriteFile();

        passwordLength = Integer.parseInt(textField.getText());
        password = generator.generatePassword(passwordLength);
        String content = website + " : " + password;

        try {
            writeFile.write(content);
        } catch (IOException err) {
            systemLabel.setText("Hiba történt: " + err.getMessage());
        }

        textField.setText("");
        listPasswords();

        frame.revalidate();
        frame.repaint();
    }

    private void setWebsite() {
        website = textField.getText();
        textField.setText("");
    }

    private void listPasswords() {
        String filename = "jelszavak.txt";
        ReadFile readFile = new ReadFile();
        List<String> passwords = readFile.read(filename);

        panel.removeAll();
        panel.setLayout(new GridLayout(passwords.size() + 3, 1)); // +3 for systemLabel, textField, and button
        panel.add(systemLabel);
        panel.add(textField);
        panel.add(button);

        for (String currentPassword : passwords) {
            JTextField contentField = new JTextField(currentPassword);
            contentField.setEditable(false);
            contentField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            contentField.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        contentField.requestFocusInWindow();
                        contentField.selectAll();
                    }
                }
            });
            panel.add(contentField);
        }

        frame.revalidate();
        frame.repaint();
    }
}