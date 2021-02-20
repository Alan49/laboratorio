package project.exceptions;

/**
 * Created by alan on 05/12/16.
 */
public class EventNoExistException extends Exception {

    private final String message = "El evento no existe";

    @Override
    public String getMessage() {
        return message;
    }
}
