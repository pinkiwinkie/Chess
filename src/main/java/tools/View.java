package tools;

import model.Board;
import model.Piece;
import model.IDeletedPieceManager;
import model.Coordinate;
public class View {

    public static void showStorage(IDeletedPieceManager storage){

    }

    public static void show(Board board, Piece.Color color){
        if (color == Piece.Color.BLACK)
            showViewBlack(board);
        else
            showViewWhite(board);
        showStorage(board.getDeletedPieceManager());
        showStorage(board.getCurrentPieceManager());
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
                output += board.getCell(new Coordinate((char) ('A' + j), i ));
            }
            output += " " + i + "\n";
        }
        output += "   A  B  C  D  E  F  G  H";
        System.out.println(output);
    }

}
