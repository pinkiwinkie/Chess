package storagePieces;

import model.Board;
import model.Cell;
import model.Piece;
import storagePieces.IDeletedPieceManager;

import java.util.LinkedList;
import java.util.List;

import static com.diogonunes.jcolor.Ansi.colorize;

public class CurrentPieceManager implements ICurrentPieceManager {
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
    public int count(Piece.Color color) {
        int count = 0;
        for (Cell cell : board.getCellMap().values())
            if (cell.getPiece().getType().getColor().equals(color))
                count++;
        return count;
    }

    @Override
    public Piece removeLast() {
        return pieces.remove(0);
    }
}

