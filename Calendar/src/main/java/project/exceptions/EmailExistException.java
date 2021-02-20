package project.exceptions;

/**
 * Created by alan on 05/12/16.
 */
public class EmailExistException extends RuntimeException {

    private final String message = "El email ya existe";

    @Override
    public String getMessage() {
        return message;
    }
}
