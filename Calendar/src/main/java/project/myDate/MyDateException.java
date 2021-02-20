package project.myDate;

/**
 * Created by alan on 05/12/16.
 */
public class MyDateException extends RuntimeException {

    private final String message = "La fecha ingresada no es valida";

    @Override
    public String getMessage(){
        return message;
    }
}
