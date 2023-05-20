package ltd.arvai.validator;

import ltd.arvai.display.Output;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileValidator {
    public boolean validate() {
        String filePath = "jelszavak.txt";

        // Create a Path object from the file path
        Path path = Paths.get(filePath);

        // Check if the file exists
        boolean fileExists = Files.exists(path);

        return fileExists;
    }

}
