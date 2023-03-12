package tools;

import model.*;
import storagePieces.ICurrentPieceManager;
import storagePieces.IDeletedPieceManager;

import java.io.Serializable;

import static com.diogonunes.jcolor.Ansi.colorize;

public class View implements Serializable {


    /**
     * @param storage of pieces deleted
     */
    public static void showStorageDeleted(IDeletedPieceManager storage) {
        String output = "DELETED PIECES\n";
        for (Piece.Type type : Piece.Type.values()) {
            output += colorize(" " + type.getShape() + " ", type.getColor().getPieceColor(), Cell.Color.WHITE_CELL.getAttribute());
        }
        output += "\n";
        for (Piece.Type type : Piece.Type.values()) {
            output += colorize(" " + storage.count(type) + " ", type.getColor().getPieceColor(), Cell.Color.BLACK_CELL.getAttribute());
        }
        System.out.println(output);
    }

    /**
     * @param storage of pieces deleted
     */
    public static void showStorageCurrent(ICurrentPieceManager storage) {
        String output = "CURRENT PIECES\n";
        for (Piece.Type type : Piece.Type.values()) {
            output += colorize(" " + type.getShape() + " ", type.getColor().getPieceColor(), Cell.Color.WHITE_CELL.getAttribute());
        }
        output += "\n";

        for (Piece.Type type : Piece.Type.values())
            output += colorize(" " + storage.count(type.getColor(), type) + " ", type.getColor().getPieceColor(), Cell.Color.BLACK_CELL.getAttribute());

        System.out.println(output);
    }

    /**
     * to show board
     */
    public static void show(Board board, Piece.Color color) {
        if (color == Piece.Color.BLACK)
            showViewBlack(board);
        else
            showViewWhite(board);
        showStorageDeleted(board.getDeletedPieceManager());
        showStorageCurrent(board.getCurrentPieceManager());
    }

    private static void showViewWhite(Board board) {
        String output = "   A  B  C  D  E  F  G  H\n";
        for (int i = 0; i < 8; i++) {
            output += (i + 1) + " ";
            for (int j = 0; j < 8; j++) {
                output += board.getCell(new Coordinate((char) ('A' + j), i + 1));
            }
            output += " " + (i + 1) + "\n";
        }
        output += "   A  B  C  D  E  F  G  H";
        System.out.println(output);
    }

    private static void showViewBlack(Board board) {
        String output = "   A  B  C  D  E  F  G  H\n";
        for (int i = 8; i > 0; i--) {
            output += i + " ";
            for (int j = 0; j < 8; j++) {
                output += board.getCell(new Coordinate((char) ('A' + j), i));
            }
            output += " " + i + "\n";
        }
        output += "   A  B  C  D  E  F  G  H";
        System.out.println(output);
    }

}
