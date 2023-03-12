package storagePieces;

import model.Piece;

public interface ICurrentPieceManager {
    void addPiece(Piece piece);

    int count(Piece.Color color, Piece.Type type);

    Piece removeLast();
}
