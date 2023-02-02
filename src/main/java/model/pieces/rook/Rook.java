package model.pieces.rook;

import model.Board;
import model.Cell;
import model.Coordinate;
import model.Piece;
import tad.ListCoord;
import tools.Tools;

public abstract class Rook extends Piece {

    private ListCoord coordinates;
    public Rook(Type type, Cell cell){
        super(type,cell);
    }

    @Override
    public ListCoord getNextMovements(){
        return Rook.getNextMovementsAsRook(this);
    }
    public static ListCoord getNextMovementsAsRook(Piece p) {
        ListCoord coordinates = new ListCoord();
        Cell cell = p.getCell();
        Board board = cell.getBoard();
        Piece.Color color = p.getColor();

        Coordinate original = cell.getCoordinate();
        Coordinate c;

        //UP
        c=original.up();
        while(board.getCell(c)!= null && board.getCell(c).isEmpty()) {
            coordinates.add(c);
            c = c.up();
        }
        if(board.getCell(c)!=null && board.getCell(c).getPiece().getColor()!=color)
            coordinates.add(c);

        //DOWN
        c=original.down();
        while(board.getCell(c)!= null && board.getCell(c).isEmpty()) {
            coordinates.add(c);
            c = c.down();
        }
        if(board.getCell(c)!=null && board.getCell(c).getPiece().getColor()!=color)
            coordinates.add(c);

        //LEFT
        c=original.left();
        while(board.getCell(c)!= null && board.getCell(c).isEmpty()) {
            coordinates.add(c);
            c = c.left();
        }
        if(board.getCell(c)!=null && board.getCell(c).getPiece().getColor()!=color)
            coordinates.add(c);

        //RIGHT
        c=original.right();
        while(board.getCell(c)!= null && board.getCell(c).isEmpty()) {
            coordinates.add(c);
            c = c.right();
        }
        if(board.getCell(c)!=null && board.getCell(c).getPiece().getColor()!=color)
            coordinates.add(c);

        return coordinates;
    }

}
