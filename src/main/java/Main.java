import model.Board;
import model.Cell;
import model.Coordinate;
import model.Piece;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board);
//        Coordinate c1 = new Coordinate('c', 1);
//        Piece whiteKnight = new Piece(Piece.Type.WHITE_KNIGHT, new Cell(new Board(), c1));
//        System.out.println(whiteKnight);
//        Piece blackKnight = new Piece(Piece.Type.BLACK_KNIGHT, new Cell(new Board(), c1));
//        System.out.println(blackKnight);
        board.placePieces();
        System.out.println(board);

        Coordinate[] coordinates = board.getCell(new Coordinate('G',2)).getPiece().getNextMovements();
        board.highlight(coordinates);
        System.out.println(board);
//        coordinates = board.getCell(new Coordinate('E',8)).getPiece().getNextMovements();
//        coordinates = board.getCell(new Coordinate('G',2)).getPiece().getNextMovements();
//        coordinates = board.getCell(new Coordinate('D',1)).getPiece().getNextMovements();
//        coordinates = board.getCell(new Coordinate('A',1)).getPiece().getNextMovements();
    }
}
