package ltd.arvai.file_handle;

import ltd.arvai.display.Output;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    public void create(String filename) {
        Output output = new Output();
        File file = new File(filename);
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
}
