import model.Board;
import model.Coordinate;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.placePieces();
        board.highlight(board.getCell(new Coordinate('D',6)).getPiece().getNextMovements());
        System.out.println(board);


    }
}
