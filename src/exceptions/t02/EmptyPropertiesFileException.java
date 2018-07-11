package exceptions.t02;

import java.io.IOException;

public class EmptyPropertiesFileException extends IOException {
    @Override
    public String getMessage() {
        return "Пустой файл";
    }
}
