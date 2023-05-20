package ltd.arvai.file_handle;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    public void create(String filePath) {
        File file = new File(filePath);
        try {
            boolean created = file.createNewFile();
            if (!created) {
                //TODO implement graphic error message
            }
        } catch (IOException e) {
            //TODO implement graphic error message
        }
    }
}
