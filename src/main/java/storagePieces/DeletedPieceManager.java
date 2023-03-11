package storagePieces;

import model.Cell;
import model.Piece;
import storagePieces.IDeletedPieceManager;

import java.util.LinkedList;
import java.util.List;

import static com.diogonunes.jcolor.Ansi.colorize;

public class DeletedPieceManager implements IDeletedPieceManager {
    private List<Piece> pieces;

    public DeletedPieceManager() {
        pieces = new LinkedList<>();
    }

    @Override
    public void addPiece(Piece piece) {
        pieces.add(piece);
    }

    @Override
    public int count(Piece.Type type) {
        int count = 0;
        for (Piece piece : pieces)
            if (piece.getType().equals(type))
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
