package project.exceptions;

/**
 * Created by alan on 05/12/16.
 */
public class CalendarNoExistException extends Exception {

    private final String message = "El calendario no existe";

    @Override
    public String getMessage() {
        return message;
    }
}
