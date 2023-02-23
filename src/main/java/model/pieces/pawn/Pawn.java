package model.pieces.pawn;

import model.Board;
import model.Cell;
import model.Coordinate;
import model.Piece;

public abstract class Pawn extends Piece {
    public Pawn(Type type, Cell cell){
        super(type,cell);
    }

    public abstract void transform();

    @Override
    public void moveTo(Coordinate c) {
        super.moveTo(c);
        if (getCell().getCoordinate().getNumber() == 8 ||
                getCell().getCoordinate().getNumber() == 1)
            transform();
    }

    protected void checkPawnKiller(Coordinate c) {
        Board board = getCell().getBoard();
        if ((board.getCell(c) != null) && (board.getCell(c).getPiece().getColor() != getColor()))
            coordinates.add(c);
    }

    protected void checkPawnMove(Coordinate c) {
        Board board = getCell().getBoard();
        if ((board.getCell(c) != null) && (board.getCell(c).isEmpty()))
            coordinates.add(c);
    }
}
