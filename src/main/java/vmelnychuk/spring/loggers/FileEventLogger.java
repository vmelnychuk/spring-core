package vmelnychuk.spring.loggers;

import org.apache.commons.io.FileUtils;
import vmelnychuk.spring.beans.Event;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {
    private String fileName;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString() + "\n", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() throws IOException {
        this.file = new File(fileName);
        if (!file.canWrite()) {
            throw new IOException("Can't write to " + fileName);
        } else {
            System.out.println("File " + fileName + " is OK");
        }
    }
}
