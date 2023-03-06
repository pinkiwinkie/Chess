package model.pieces.rook;

import model.Board;
import model.Cell;
import model.Coordinate;
import model.Piece;

import java.util.HashSet;
import java.util.Set;

public abstract class Rook extends Piece {

    public Rook(Type type, Cell cell) {
        super(type, cell);
    }

    @Override
    public Set<Coordinate> getNextMovements() {
        return Rook.getNextMovementsAsRook(this);
    }

    public static Set<Coordinate> getNextMovementsAsRook(Piece p) {
        Set<Coordinate> coordinates = p.getCoordinates();
        Cell cell = p.getCell();
        Board board = cell.getBoard();
        Piece.Color color = p.getColor();

        Coordinate original = cell.getCoordinate();
        Coordinate c;

        //UP
        c = original.up();
        while (board.getCell(c) != null && board.getCell(c).isEmpty()) {
            coordinates.add(c);
            c = c.up();
        }
        if (board.getCell(c) != null && board.getCell(c).getPiece().getColor() != color)
            coordinates.add(c);

        //DOWN
        c = original.down();
        while (board.getCell(c) != null && board.getCell(c).isEmpty()) {
            coordinates.add(c);
            c = c.down();
        }
        if (board.getCell(c) != null && board.getCell(c).getPiece().getColor() != color)
            coordinates.add(c);

        //LEFT
        c = original.left();
        while (board.getCell(c) != null && board.getCell(c).isEmpty()) {
            coordinates.add(c);
            c = c.left();
        }
        if (board.getCell(c) != null && board.getCell(c).getPiece().getColor() != color)
            coordinates.add(c);

        //RIGHT
        c = original.right();
        while (board.getCell(c) != null && board.getCell(c).isEmpty()) {
            coordinates.add(c);
            c = c.right();
        }
        if (board.getCell(c) != null && board.getCell(c).getPiece().getColor() != color)
            coordinates.add(c);

        return coordinates;
    }

}
