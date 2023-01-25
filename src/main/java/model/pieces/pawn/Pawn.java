package model.pieces.pawn;

import model.Board;
import model.Cell;
import model.Coordinate;
import model.Piece;
import tools.Tools;

public abstract class Pawn extends Piece {


    public Pawn(Type type, Cell cell){
        super(type,cell);
    }


}
