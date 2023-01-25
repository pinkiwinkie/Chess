package model.pieces.pawn;

import model.Board;
import model.Cell;
import model.Coordinate;
import tools.Tools;

public class WhitePawn extends Pawn {
    private Coordinate[] coordinates;
    public WhitePawn(Cell cell){
        super(Type.WHITE_PAWN,cell);
    }

    @Override
    public Coordinate[] getNextMovements() {
        coordinates = new Coordinate[0];
        Coordinate position = getCell().getCoordinate(), c, c2;

        //UP
        c= position.up();
        check(c);
        if (position.getNumber() == 7)
           c= position.up().up();
       check(c);

        c=position.up().left();
        c2 = position.up().right();

        check2(c);
        check2(c2);
        return coordinates;
    }

    public void check(Coordinate c){
        Board board = getCell().getBoard();
        if (board.getCell(c) != null)
            if (board.getCell(c).isEmpty() ||
                    board.getCell(c).getPiece().getColor() != getColor())
                coordinates = Tools.add(coordinates,c);

    }

    public void check2(Coordinate c){
        Board board = getCell().getBoard();
        if (board.getCell(c) != null)
            if (!board.getCell(c).isEmpty() && board.getCell(c).getPiece().getColor() != getColor())
                coordinates = Tools.add(coordinates,c);
    }
}
