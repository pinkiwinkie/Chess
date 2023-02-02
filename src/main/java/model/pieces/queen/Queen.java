package model.pieces.queen;

import model.*;
import model.pieces.rook.Rook;
import model.pieces.bishop.Bishop;
import tad.ListCoord;

public class Queen extends Piece {
    public Queen(Type type, Cell cell){
        super(type,cell);
    }

    @Override
    public ListCoord getNextMovements() {

        return Bishop.getNextMovementsAsBishop(this).
                addAll(Rook.getNextMovementsAsRook(this));
    }
}
