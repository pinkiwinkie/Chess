package model.pieces.pawn;

import model.Cell;
import model.Coordinate;
import model.Piece;
import model.pieces.queen.BlackQueen;

import java.util.HashSet;
import java.util.Set;

public class BlackPawn extends Pawn {

    public BlackPawn(Cell cell) {
        super(Type.BLACK_PAWN, cell);
    }

    @Override
    public Set<Coordinate> getNextMovements() {
        Coordinate position = getCell().getCoordinate(), c;

        //UP
        c = position.down();
        checkPawnMove(c);
        if (getCell().getCoordinate().getNumber() == 2) {
            c = position.down().down();
            checkPawnMove(c);
        }

        c = position.diagonalDownLeft();
        checkPawnKiller(c);
        c = position.diagonalDownRight();
        checkPawnKiller(c);

        return coordinates;
    }

    @Override
    public void transform() {
        Piece p = getCell().getPiece();
        new BlackQueen(getCell());
        getCell().getBoard().getDeletedPieceManager().addPiece(p);
        cell = null;
    }

}
