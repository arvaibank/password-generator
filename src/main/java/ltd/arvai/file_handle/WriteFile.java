package ltd.arvai.file_handle;

import ltd.arvai.display.Output;
import ltd.arvai.validator.FileValidator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    private String filename = "jelszavak.txt";
    FileValidator fileValidator = new FileValidator();
    Output output = new Output();
    File file = new File(filename);

    public void write(String content) throws IOException {
        FileWriter writer = new FileWriter(filename,  true);

        if (!fileValidator.validate()) {
            try {
                // Create a new file
                boolean created = file.createNewFile();
                if (!created) {
                    output.output("Nem sikerült létrehozni a fájlt.");
                    return;
                }
            } catch (IOException e) {
                output.output("Hiba történt: " + e.getMessage());
                return;
            }
        }
        writer.write(content + "\n");
        writer.close();
    }

}
