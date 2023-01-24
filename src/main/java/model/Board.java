package model;

import model.pieces.bishop.BlackBishop;
import model.pieces.knight.BlackKnight;
import model.pieces.knight.WhiteKnight;

public class Board {
    private Cell[][] cells;

    public Board() {
        cells = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cells[i][j] = new Cell(this, new Coordinate((char) ('A' + j), i + 1));
            }
        }
    }

    public Cell getCell(Coordinate coordinate){
        if (coordinate.getNumber()<1 || coordinate.getNumber()>8)
            return null;
        if (coordinate.getLetter()<'A' || coordinate.getLetter()>'H')
            return null;
        return cells[coordinate.getNumber()-1][coordinate.getLetter()-'A'];
    }

    public void placePieces(){
        Piece piece;
        piece = new WhiteKnight(getCell(new Coordinate('B',8)));
        piece.putInYourPlace();
        piece = new WhiteKnight(getCell(new Coordinate('G',8)));
        piece.putInYourPlace();
        piece = new BlackKnight(getCell(new Coordinate('B',1)));
        piece.putInYourPlace();
        piece = new BlackKnight(getCell(new Coordinate('G',1)));
        piece.putInYourPlace();
        piece = new BlackBishop(getCell(new Coordinate('C',1)));
        piece.putInYourPlace();
        piece = new BlackBishop(getCell(new Coordinate('F',1)));
        piece.putInYourPlace();
        piece = new BlackBishop(getCell(new Coordinate('C',8)));
        piece.putInYourPlace();
        piece = new BlackBishop(getCell(new Coordinate('F',8)));
        piece.putInYourPlace();
    }

    public void highlight(Coordinate [] coordinates){
        for (Coordinate c: coordinates)
            getCell(c).highlight();
    }

    public void resetColor(){
        for (Cell [] cells1: cells){
            for (Cell cell: cells1)
                cell.resetColor();
        }
    }
    @Override
    public String toString() {
        String output = "   A  B  C  D  E  F  G  H\n";
        for (int i = 0; i < 8; i++) {
            output += (i + 1) + " ";
            for (int j = 0; j < 8; j++) {
                output += cells[i][j];
            }
            output += " " + (i + 1) + "\n";
        }
        output += "   A  B  C  D  E  F  G  H";
        return output;
    }
}
