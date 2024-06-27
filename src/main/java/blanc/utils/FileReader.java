package blanc.utils;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {

    @SneakyThrows
    public static synchronized Template readTemplate(String fileName) {
        return new Template(Files.readString(Path.of("src/main/resources/templates", fileName)));
    }
}
