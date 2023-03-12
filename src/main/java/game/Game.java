package game;

import mistakesInput.Changes;
import model.Board;
import model.Cell;
import model.Coordinate;
import model.Piece;
import tools.Input;
import tools.View;

import java.io.Serializable;
import java.util.Optional;

public class Game implements Serializable {
    private final Board board;
    private Piece.Color shift;
    private final String player1, player2;
    private boolean playing;
    public static final Coordinate coordSave = new Coordinate('S',0);

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
     * makes the game have a beginning and an end.
     */
    public void start(){
        Piece king;
        while (playing){
            shift();
            king = findOutKing(findOutKingEnemy());
            if (king!=null){
                changeShift();
            } else{
                playing = false;
                if (board.getDeletedPieceManager().count(Piece.Type.BLACK_KING) == 1)
                    System.out.println("The winner is " + player1);
                else
                    System.out.println("The winner is " + player2);
            }
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

    /**
     * Ask the user for a coordinate.
     * @return a valid coordinate.
     */
    private Coordinate takeCoordinate(){
        Coordinate coordinate;
        String falseCoordinate;
        int number;
        char letter;
        boolean salir = false, salir2 = false;
        do {
            do {
                falseCoordinate = Input.getString("Write the coordinate.");
                if (falseCoordinate.length() != 2) {
                    System.out.println("Solo 2 caracteres validos.");
                } else
                    salir2 = true;
            } while (!salir2);
            number = Changes.separateNumberCoordinate(falseCoordinate);
            letter = Changes.separateLetterCoordinate(falseCoordinate);
            coordinate = new Coordinate(letter, number);
            if (!board.contains(coordinate) && !coordinate.equals(coordSave)) {
                System.out.println("Not exists the coordinate.");
            }else
                salir = true;

        }while(!board.contains(coordinate) && !coordinate.equals(coordSave)|| !salir);
        return coordinate;
    }

    /**
     * @return coordinate of the piece to move.
     */
    private Coordinate selectPiece(){
        boolean isValid = false;
        Coordinate coordinate = null;
        while (!isValid){
            coordinate = takeCoordinate();
//            System.out.println(coordinate);
            if (coordinate.equals(coordSave)) {
                String file = Input.getString("Wire name of file");
                File.save(this,file);
                System.out.println("The game has been saved as game.txt correctly.");
                Menu.menu();
            }else if (!board.getCell(coordinate).isEmpty()){
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

    /**
     * @param coordinate that indicates the user to move the piece around the board.
     */
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
        ).map(Cell::getPiece).filter(piece -> piece.getType() == king).findAny();
        return rey.orElse(null);
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
