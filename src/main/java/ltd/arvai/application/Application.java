package ltd.arvai.application;

import ltd.arvai.display.Input;
import ltd.arvai.display.Output;
import ltd.arvai.file_handle.WriteFile;
import ltd.arvai.logic.Generator;
import ltd.arvai.validator.InputValidator;

import java.io.IOException;

public class Application {
    private boolean isRunning;
    Input input = new Input();
    Output output = new Output();
    Generator generator = new Generator();
    InputValidator inputValidator = new InputValidator();
    WriteFile writeFile = new WriteFile();
    public Application() {
        this.isRunning = true;
    }
    public void setRunning(boolean running) {
        isRunning = running;
    }
    public void generate() {

        while(isRunning) {
            output.output("Melyik oldalhoz generáljam a jelszót?");
            String website = input.input();

            output.output("Milyen hosszú legyen a jelszó?");
            int passwordLength = Integer.parseInt(input.input());
            String password = generator.generatePassword(passwordLength);
            output.output("Íme a jelszó: " + password);

            String content = website + " : " + password;

            try {
                writeFile.write(content);
            } catch (IOException e) {
                output.output("Hiba történt: " + e.getMessage());
            }

            output.output("Szeretnél még egy jelszót generálni? [Igen / Nem]");
            String toContinue = input.input();
            setRunning(inputValidator.validate(toContinue));
        }
    }
}
