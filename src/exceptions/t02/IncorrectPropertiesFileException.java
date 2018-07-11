package exceptions.t02;

import java.io.IOException;

public class IncorrectPropertiesFileException extends IOException {
    @Override
    public String getMessage() {
        return "Нет ключа";
    }
}
