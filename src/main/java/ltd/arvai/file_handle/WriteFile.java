package ltd.arvai.file_handle;

import ltd.arvai.validator.FileValidator;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public void write(String content) throws IOException {
        String filename = "jelszavak.txt";
        FileValidator fileValidator = new FileValidator();
        CreateFile createFile = new CreateFile();

        FileWriter writer = new FileWriter(filename,  true);

        if (!fileValidator.validate()) {
            createFile.create(filename);
        }
        writer.write(content + "\n");
        writer.close();
    }

}
