package project.exceptions;

/**
 * Created by alan on 05/12/16.
 */
public class EmptyParametersException extends RuntimeException {

    private final String message = "Existen parametros vacios";

    @Override
    public String getMessage() {
        return message;
    }
}
