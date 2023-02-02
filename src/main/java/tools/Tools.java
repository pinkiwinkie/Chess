package tools;

import java.util.Scanner;

public class Tools {

    /**
     * @param message indicates what the user has to enter.
     * @return integer.
     */
    public static int getInt(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        while (!sc.hasNextInt()) {
            System.err.println("Error - An integer number is requested");
            sc.next();
        }
        return sc.nextInt();
    }

    /**
     * @param message indicates what the user has to enter.
     * @return String.
     */
    public static String getString(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        return sc.next().toUpperCase();
    }


//    public static Coordinate[] add(Coordinate[] coordinates,Coordinate coordinate){
//        Coordinate [] aux = new Coordinate[coordinates.length+1];
//        System.arraycopy(coordinates,0,aux,0,coordinates.length);
//        aux[aux.length-1] = coordinate;
//        return aux;
//    }
}
