package project.exceptions;

/**
 * Created by alan on 05/12/16.
 */
public class EmailNoExistException extends RuntimeException {

    private final String message = "El usuario no existe";

    @Override
    public String getMessage() {
        return message;
    }
}
