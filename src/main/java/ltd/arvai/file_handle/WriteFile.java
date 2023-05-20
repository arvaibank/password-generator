package ltd.arvai.file_handle;

import ltd.arvai.validator.FileValidator;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public static final String FILE_PATH = "./src/main/resources/jelszavak.txt";
    public void write(String content) throws IOException {
        FileValidator fileValidator = new FileValidator();
        CreateFile createFile = new CreateFile();

        FileWriter writer = new FileWriter(FILE_PATH,  true);

        if (!fileValidator.validate()) {
            createFile.create(FILE_PATH);
        }
        writer.write(content + "\n");
        writer.close();
    }

}
