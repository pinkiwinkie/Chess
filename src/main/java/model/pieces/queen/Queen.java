package model.pieces.queen;

import model.*;
import model.pieces.rook.Rook;
import model.pieces.bishop.Bishop;
import java.util.Set;

public class Queen extends Piece {
    public Queen(Type type, Cell cell){
        super(type,cell);
    }

    @Override
    public Set<Coordinate> getNextMovements() {
       Set<Coordinate> pl;
       pl=Bishop.getNextMovementsAsBishop(this);
       pl.addAll(Rook.getNextMovementsAsRook(this));
       return pl;
    }
}
