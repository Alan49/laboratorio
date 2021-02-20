package exception;

import java.util.StringTokenizer;

/**
 * Created by sistop on 07/10/16.
 */
public class Main {

    public static void main(String[] args){
        //primer punto
        /*
        try {
            System.out.print(division(3,0));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            //si o si se ejecute
            System.out.println("me ejecuto si o si ");
        }*/
        //segundo punto
        /*
        try {
            System.out.println(division2(3, 0));
        } catch (MyException e) {
            System.out.println(e.getMessage());
            e.printStackTrace(System.out);
        }*/
        //tercer
        Matematica mat = new Matematica(3,1);
        try {
            System.out.println(mat.getDivision2());
        } catch (MyException e) {
            //System.out.println(e.getMessage());
            e.printStackTrace(System.out);
        }
    }

    private static String division(int i, int i1) {
        try{
             return "se pudo dividir"+ i / i1+" el resutado es"+ i / i1;
        }catch (ArithmeticException e){
            throw new ArithmeticException("no se pudo dividir gato");
        }
    }




}
