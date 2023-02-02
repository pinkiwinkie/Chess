package model.pieces.pawn;

import model.Board;
import model.Cell;
import model.Coordinate;
import model.pieces.queen.WhiteQueen;
import tad.ListCoord;
import tools.Tools;

public class WhitePawn extends Pawn {
    private ListCoord coordinates;

    public WhitePawn(Cell cell) {
        super(Type.WHITE_PAWN, cell);
    }

    @Override
    public ListCoord getNextMovements() {
        coordinates = new ListCoord();
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
    public void transform() {
        new WhiteQueen(getCell());
        cell=null;
    }
}
