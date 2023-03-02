import model.Board;
import model.Coordinate;
import model.Piece;
import tools.Tools;
import tools.View;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.placePieces();
        board.highlight(board.getCell(new Coordinate('D',6)).getPiece().getNextMovements());
        View.show(board, Piece.Color.BLACK);
        View.show(board, Piece.Color.WHITE);
    }
}
