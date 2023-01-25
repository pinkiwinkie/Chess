package model.pieces.rook;

import model.Board;
import model.Cell;
import model.Coordinate;
import model.Piece;
import tools.Tools;

public abstract class Rook extends Piece {

    private Coordinate[] coordinates;
    public Rook(Type type, Cell cell){
        super(type,cell);
    }

    @Override
    public Coordinate[] getNextMovements() {
        coordinates = new Coordinate[0];
        Coordinate position = getCell().getCoordinate(), c;

        //UP

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
