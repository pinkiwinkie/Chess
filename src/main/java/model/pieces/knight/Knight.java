package model.pieces.knight;

import model.*;

import java.util.HashSet;
import java.util.Set;

public abstract class Knight extends Piece {

    private Set<Coordinate> coordinates;

    public Knight(Type type, Cell cell) {
        super(type, cell);
    }

    @Override
    public Set<Coordinate> getNextMovements() {
        coordinates = new HashSet<>();
        Coordinate position = getCell().getCoordinate(), c;

        //UP

        c = position.up().up().left();
        check(c, coordinates);
        c = position.up().up().right();
        check(c, coordinates);

        //DOWN

        c = position.down().down().right();
        check(c, coordinates);
        c = position.down().down().left();
        check(c, coordinates);

        //LEFT

        c = position.left().left().down();
        check(c, coordinates);
        c = position.left().left().up();
        check(c, coordinates);

        //RIGHT

        c = position.right().right().down();
        check(c, coordinates);
        c = position.right().right().up();
        check(c, coordinates);
        return coordinates;
    }
}
