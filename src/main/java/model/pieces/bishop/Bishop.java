package model.pieces.bishop;

import model.Board;
import model.Cell;
import model.Coordinate;
import model.Piece;
import tools.Tools;

public abstract class Bishop extends Piece {

    private Coordinate[] coordinates;

    public Bishop(Type type, Cell cell) {
        super(type, cell);
    }

    @Override
    public Coordinate[] getNextMovements() {
        coordinates = new Coordinate[0];
        Board board = getCell().getBoard();
        Coordinate position = getCell().getCoordinate(), c;

        //UP-LEFT
        c = position.diagonalUpLeft();
        while (board.contains(c) && board.getCell(c).isEmpty()) {
            coordinates = Tools.add(coordinates, c);
            c = c.diagonalUpLeft();
        }

        if (board.contains(c)) {
            Piece p = board.getCell(c).getPiece();
            coordinates = p.getColor() != this.getColor()
                    ? Tools.add(coordinates, c)
                    : coordinates;
        }

        //UP-RIGHT

        c = position.diagonalUpRight();
        while (board.contains(c) && board.getCell(c).isEmpty()) {
            coordinates = Tools.add(coordinates, c);
            c = c.diagonalUpRight();
        }

        if (board.contains(c)) {
            Piece p = board.getCell(c).getPiece();
            coordinates = p.getColor() != this.getColor()
                    ? Tools.add(coordinates, c)
                    : coordinates;
        }

        //DOWN-RIGHT
        c = position.diagonalDownRight();
        while (board.contains(c) && board.getCell(c).isEmpty()) {
            coordinates = Tools.add(coordinates, c);
            c = c.diagonalDownRight();
        }

        if (board.contains(c)) {
            Piece p = board.getCell(c).getPiece();
            coordinates = p.getColor() != this.getColor()
                    ? Tools.add(coordinates, c)
                    : coordinates;
        }

        //DOWN-LEFT

        c=position.diagonalDownLeft();
        while(board.contains(c) && board.getCell(c).isEmpty()){
            coordinates = Tools.add(coordinates,c);
            c=c.diagonalDownLeft();
        }

        if (board.contains(c)){
            Piece p = board.getCell(c).getPiece();
            coordinates = p.getColor() != this.getColor()
                    ? Tools.add(coordinates,c)
                    : coordinates;
        }

        return coordinates;
    }

    public void check(Coordinate c) {
        Board board = getCell().getBoard();
        if (board.getCell(c) != null)
            if (board.getCell(c).isEmpty() ||
                    board.getCell(c).getPiece().getColor() != getColor())
                coordinates = Tools.add(coordinates, c);

    }
}
