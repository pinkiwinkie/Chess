package tools;

import com.diogonunes.jcolor.Attribute;
import model.*;

import static com.diogonunes.jcolor.Ansi.colorize;

public class View {


    /**
     * @param storage
     */
    public static void showStorage(IDeletedPieceManager storage){
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

    public static void show(Board board, Piece.Color color){
        if (color == Piece.Color.BLACK)
            showViewBlack(board);
        else
            showViewWhite(board);
        showStorage(board.getDeletedPieceManager());
//        showStorage(board.getCurrentPieceManager());
    }

    private static void showViewWhite(Board board){
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

    private static void showViewBlack(Board board){
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
