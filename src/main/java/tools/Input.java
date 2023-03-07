package tools;

import model.Coordinate;

import java.util.Scanner;

public class Input {

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

    /**
     * @param message indicates what the user has to enter.
     * @return Coordinate.
     */
    public static Coordinate getCoordinate(String message){
        System.out.println(message);
        char letter = getString("Write the letter").charAt(0);
        int number = getInt("Write the number");
        boolean exit = false;
        return new Coordinate(, );
    }

//    public static Coordinate[] add(Coordinate[] coordinates,Coordinate coordinate){
//        Coordinate [] aux = new Coordinate[coordinates.length+1];
//        System.arraycopy(coordinates,0,aux,0,coordinates.length);
//        aux[aux.length-1] = coordinate;
//        return aux;
//    }
}
