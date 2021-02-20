package map;

import java.util.*;

/**
 * Created by sistop on 07/10/16.
 */
public class Main {

    public static void main(String[] args){

        Map<Integer, String> algo = new HashMap<Integer, String>();
        algo.put(1,"hola");
        algo.put(22,"soy especial");
        ArrayList<String> ls = new ArrayList<String>();
        ls.add("asdasda");
        System.out.println(algo.get(1));
        System.out.println(algo.get(22));
        System.out.println(algo.size());


    }
}
