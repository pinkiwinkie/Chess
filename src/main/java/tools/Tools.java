package tools;

import model.Coordinate;

public class Tools {
    public static Coordinate[] add(Coordinate[] coordinates,Coordinate coordinate){
        Coordinate [] aux = new Coordinate[coordinates.length+1];
        System.arraycopy(coordinates,0,aux,0,coordinates.length);
        aux[aux.length-1] = coordinate;
        return aux;
    }
}
