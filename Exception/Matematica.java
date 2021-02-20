package exception;

/**
 * Created by sistop on 07/10/16.
 */
public class Matematica {
    int i,j;

    public Matematica(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
    public String getDivision2() throws MyException {
        try {
            return "se pudo dividir "+this.getI()/this.getJ();
        }catch (ArithmeticException e){
            throw new MyException("viste que no sabe dividí gato");
        }
    }
}
