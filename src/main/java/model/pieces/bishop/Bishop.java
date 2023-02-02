package model.pieces.bishop;

import model.*;
import tad.ListCoord;

public abstract class Bishop extends Piece {

    public Bishop(Type type, Cell cell) {
        super(type, cell);
    }

    @Override
    public ListCoord getNextMovements() {
        return Bishop.getNextMovementsAsBishop(this);
    }

    public static ListCoord getNextMovementsAsBishop(Piece p) {
        ListCoord coordinates = new ListCoord();
        Cell cell = p.getCell();
        Board board = cell.getBoard();
        Piece.Color color = p.getColor();
        Coordinate position = cell.getCoordinate(), c;

        //UP-LEFT
        c = position.diagonalUpLeft();
        while (board.getCell(c) != null && board.getCell(c).isEmpty()) {
            coordinates.add(c);
            c = c.diagonalUpLeft();
        }

        if (board.getCell(c) != null && board.getCell(c).getPiece().getColor() != color)
            coordinates.add(c);

        //UP-RIGHT

        c = position.diagonalUpRight();
        while (board.getCell(c) != null && board.getCell(c).isEmpty()) {
            coordinates.add(c);
            c = c.diagonalUpRight();
        }

        if (board.getCell(c) != null && board.getCell(c).getPiece().getColor() != color)
            coordinates.add(c);

        //DOWN-RIGHT
        c = position.diagonalDownRight();
        while (board.getCell(c) != null && board.getCell(c).isEmpty()) {
            coordinates.add(c);
            c = c.diagonalDownRight();
        }

        if (board.getCell(c) != null && board.getCell(c).getPiece().getColor() != color)
            coordinates.add(c);

        //DOWN-LEFT

        c = position.diagonalDownLeft();
        while (board.getCell(c) != null && board.getCell(c).isEmpty()) {
            coordinates.add(c);
            c = c.diagonalDownLeft();
        }

        if (board.getCell(c) != null && board.getCell(c).getPiece().getColor() != color)
            coordinates.add(c);

        return coordinates;
    }
}
