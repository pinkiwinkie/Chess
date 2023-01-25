package model.pieces.king;

import model.Board;
import model.Cell;
import model.Coordinate;
import model.Piece;
import tools.Tools;

public abstract class King extends Piece {

    private Coordinate[] coordinates;
    public King(Type type, Cell cell){
        super(type,cell);
    }

    @Override
    public Coordinate[] getNextMovements() {
        coordinates = new Coordinate[0];
        Coordinate position = getCell().getCoordinate(), c;

        //UP

        c = position.up();
        check(c);

        //DOWN
        c = position.down();
        check(c);

        //LEFT

        c = position.left();
        check(c);

        //RIGHT

        c = position.right();
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
