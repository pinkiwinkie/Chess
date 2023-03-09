package game;

import mistakesInput.Changes;
import model.Board;
import model.Cell;
import model.Coordinate;
import model.Piece;
import tools.Input;
import tools.View;

import java.util.Optional;

public class Game {
    private final Board board;
    private Piece.Color shift;
    private final String player1, player2;
    private boolean playing;

    /**
     * game builder.
     */
    public Game() {
        board = new Board();
        shift = Piece.Color.WHITE;
        playing = true;
        player1 = Input.getString("Introduce name of player 1: ");
        player2 = Input.getString("Introduce name of player 2: ");
    }

    /**
     * makes the game have a begining and an end.
     */
    //CAMBIAR EL IF DEL CONTADOR DEL REY PORQUE ASI NO VA A FINALIZAR PORQUE NO ESTA IMPLEMENTADO.
    public void start(){
        Piece king;
        while (playing){
            shift();
            changeShift();
//            king = findOutKing(findOutKingEnemy());
//            if (king != null){
//                changeShift();
//                if (findOutCheck(king))
//                    System.out.println("The king is in danger.");
//                else {
//                    playing = false;
//                    if (board.getDeletedPieceManager().count(Piece.Type.BLACK_KING) == 0)
//                        System.out.println("The winner is " + player1);
//                    else
//                        System.out.println("The winner is " + player2);
//                }
//            }
        }
    }

    /**
     * indicates what to do each turn.
     */
    private void shift(){
        if (shift == Piece.Color.WHITE)
            System.out.println("Shift of " + player1 + ".");
        else
            System.out.println("Shift of " + player2 + ".");
        View.show(board,shift);
        Coordinate c = selectPiece();
        movePiece(c);
    }

    private void changeShift() {
        if (shift == Piece.Color.WHITE)
            shift = Piece.Color.BLACK;
        else
            shift = Piece.Color.WHITE;
    }
    private Coordinate takeCoordinate(){
        Coordinate coordinate;
        String falseCoordinate;
        int number;
        char letter;
        boolean salir = false;
        do {
            falseCoordinate = Input.getString("Write the coordinate.");
            if (falseCoordinate.length() != 2)
                System.out.println("Solo 2 caracteres validos.");
            else
                salir = true;
        }while(!salir);
        do{
            number = Changes.separateNumberCoordinate(falseCoordinate);
            letter = Changes.separateLetterCoordinate(falseCoordinate);
            coordinate = new Coordinate(letter, number);
            if (!board.contains(coordinate))
                System.out.println("Not exists the coordinate.");
        }while(!board.contains(coordinate));

        return coordinate;
    }

    private Coordinate selectPiece(){
        boolean isValid = false;
        Coordinate coordinate = null;
        while (!isValid){
            coordinate = takeCoordinate();
//            System.out.println(coordinate);
            if (!board.getCell(coordinate).isEmpty()){
                if (board.getCell(coordinate).getPiece().getColor() == shift){
                    if (board.getCell(coordinate).getPiece().getNextMovements().size()>0)
                        isValid = true;
                    else
                        System.out.println("This piece has not a movements. Choose an other one.");
                }
            }else
                System.out.println("There is not piece in this coordinate.");
        }
        board.highlight(board.getCell(coordinate).getPiece().getNextMovements());
        View.show(board,shift);
        return coordinate;
    }

    private void movePiece(Coordinate coordinate){
        while (!board.getCell(coordinate).getPiece().moveTo(takeCoordinate())){
            System.out.println("Do not move the piece");
        }
        board.resetColor();
        View.show(board,shift);
    }
    private Piece findOutKing(Piece.Type king){
        Optional<Piece> rey = board.getCellMap().values().stream().filter(
                c -> !c.isEmpty()
        ).map(Cell::getPiece).filter(piece -> piece.getType() == king).findFirst();
        if (rey.isPresent())
            return rey.get();
        else
            return null;
    }

    private Piece.Type findOutKingEnemy(){
        if (shift == Piece.Color.WHITE)
            return Piece.Type.BLACK_KING;
        else
            return Piece.Type.WHITE_KING;
    }

    private boolean findOutCheck(Piece king){
        return false;
    }
}
