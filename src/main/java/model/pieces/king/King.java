package model.pieces.king;

import model.Board;
import model.Cell;
import model.Coordinate;
import model.Piece;
import tad.ListCoord;
import tools.Tools;

public abstract class King extends Piece {
    public King(Type type, Cell cell) {
        super(type, cell);
    }

    @Override
    public ListCoord getNextMovements() {
        ListCoord coordinates = new ListCoord();
        Coordinate position = getCell().getCoordinate(), c;

        //UP
        c = position.up();
        check(c, coordinates);

        //DOWN
        c = position.down();
        check(c, coordinates);

        //LEFT
        c = position.left();
        check(c, coordinates);

        //RIGHT
        c = position.right();
        check(c, coordinates);

        return coordinates;
    }
}
