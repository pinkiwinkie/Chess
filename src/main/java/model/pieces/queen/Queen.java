package model.pieces.queen;

import model.Cell;
import model.Piece;
import model.pieces.rook.Rook;
import tad.ListCoord;

public abstract class Queen extends Piece {
    public Queen(Type type, Cell cell){
        super(type,cell);
    }

    @Override
    public ListCoord getNextMovements() {

        return Bishop.getNextMovementsAsBishop(this).
                addAll(Rook.getNextMovementsAsRook(this));
    }
}
