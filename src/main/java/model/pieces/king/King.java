package model.pieces.king;

import model.Cell;
import model.Coordinate;
import model.Piece;

import java.util.HashSet;
import java.util.Set;

public abstract class King extends Piece {
    public King(Type type, Cell cell) {
        super(type, cell);
    }

    @Override
    public Set<Coordinate> getNextMovements() {
        Set<Coordinate> coordinates = new HashSet<>();
        Coordinate position = getCell().getCoordinate(), c;

        //UP
        c = position.up();
        check(c, coordinates);

        //UP-LEFT
        c = position.diagonalUpLeft();
        check(c, coordinates);

        //UP-RIGHT
        c = position.diagonalUpRight();
        check(c, coordinates);

        //DOWN
        c = position.down();
        check(c, coordinates);

        // DOWN-LEFT
        c = position.diagonalDownLeft();
        check(c, coordinates);

        //DOWN-RIGHT
        c = position.diagonalDownRight();
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
