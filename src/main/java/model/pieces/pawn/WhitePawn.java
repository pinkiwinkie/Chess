package model.pieces.pawn;

import model.Cell;
import model.Coordinate;
import model.Piece;
import model.pieces.queen.BlackQueen;
import model.pieces.queen.WhiteQueen;

import java.util.HashSet;
import java.util.Set;

public class WhitePawn extends Pawn {
    public WhitePawn(Cell cell) {
        super(Type.WHITE_PAWN, cell);
    }

    @Override
    public Set<Coordinate> getNextMovements() {
        Coordinate position = getCell().getCoordinate(), c;

        //UP
        c = position.up();
        checkPawnMove(c);
        if (getCell().getCoordinate().getNumber() == 7) {
            c = position.up().up();
            checkPawnMove(c);
        }
        c = position.diagonalUpLeft();
        checkPawnKiller(c);
        c = position.diagonalUpRight();
        checkPawnKiller(c);

        return coordinates;
    }


    @Override
    public void transform(Piece piece) {
        getCell().getBoard().getDeletedPieceManager().addPiece(piece);
        piece = new WhiteQueen(getCell());
        piece.putInYourPlace();
        getCell().getBoard().getCurrentPieceManager().addPiece(piece);
    }
}
