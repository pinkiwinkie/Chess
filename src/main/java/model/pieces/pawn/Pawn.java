package model.pieces.pawn;

import model.Board;
import model.Cell;
import model.Coordinate;
import model.Piece;
import tools.Tools;

public abstract class Pawn extends Piece {

    private Coordinate[] coordinates;
    public Pawn(Type type, Cell cell){
        super(type,cell);
    }

    @Override
    public Coordinate[] getNextMovements() {
        coordinates = new Coordinate[0];
        Coordinate position = getCell().getCoordinate(), c;

        //UP

        c = position.up().up().left();
        check(c);
        c = position.up().up().right();
        check(c);

        //DOWN

        c = position.down().down().right();
        check(c);
        c = position.down().down().left();

        //LEFT

        c = position.left().left().down();
        check(c);
        c = position.left().left().up();
        check(c);

        //RIGHT

        c = position.right().right().down();
        check(c);
        c = position.right().right().up();
        check(c);
        return coordinates;
    }

    public void check(Coordinate c){
        Board board = getCell().getBoard();
        if (board.getCell(c) != null)
            if (board.getCell(c).isEmpty() ||
                    board.getCell(c).getPiece().getColor() != getColor())
                coordinates = Tools.add(coordinates,c);

    }
}
