package model;

import java.util.LinkedList;
import java.util.List;

import static com.diogonunes.jcolor.Ansi.colorize;

public class CurrentPieceManager implements IDeletedPieceManager {
    private List<Piece> pieces;
    private Board board;

    public CurrentPieceManager(Board board) {
        pieces = new LinkedList<>();
        this.board = board;
    }

    @Override
    public void addPiece(Piece piece) {
        pieces.add(piece);
    }

    @Override
    public int count(Piece.Type type) {

        int count = 0;
        for (Cell cell : board.getCellMap().values())
            if (cell.getPiece().getType().equals(type))
                count++;
        return count;
    }

    @Override
    public Piece removeLast() {
        return pieces.remove(0);
    }

    @Override
    public String toString() {
        String output = "";
        for (Piece.Type type : Piece.Type.values()) {
            output += colorize(" " + type.getShape() + " ", type.getColor().getPieceColor(), Cell.Color.WHITE_CELL.getAttribute());
        }
        output += "\n";
        for (Piece.Type type : Piece.Type.values()) {
            output += colorize(" " + count(type) + " ", type.getColor().getPieceColor(), Cell.Color.BLACK_CELL.getAttribute());
        }
        return output;
    }
}

