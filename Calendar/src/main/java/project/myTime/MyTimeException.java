package project.myTime;

/**
 * Created by alan on 05/12/16.
 */
public class MyTimeException extends RuntimeException {

    private final String message = "La hora ingresada no es valida";

    @Override
    public String getMessage() {
        return message;
    }
}
