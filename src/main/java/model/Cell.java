package model;

public class Cell {
    private Piece piece;
    private Board board;
    private Coordinate coordinate;

    public Cell(Board board, Coordinate coordinate) {
        this.board = board;
        this.coordinate = coordinate;
        this.piece = null;
    }
}
