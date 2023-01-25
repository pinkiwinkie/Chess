package model.pieces.pawn;

import model.Board;
import model.Cell;
import model.Coordinate;
import tools.Tools;

public class BlackPawn extends Pawn {
    private Coordinate[] coordinates;
    public BlackPawn(Cell cell){
        super(Type.BLACK_PAWN,cell);
    }

    @Override
    public Coordinate[] getNextMovements() {
        Board board = getCell().getBoard();
        coordinates = new Coordinate[0];
        Coordinate position = getCell().getCoordinate(), c, c2;

        //UP
        c= position.down();
        check(c);
        if (position.getNumber() == 2)
            c= position.down().down();
        check(c);

        c=position.down().left();
        c2 = position.down().right();

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
