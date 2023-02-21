package model;

import model.pieces.bishop.*;
import model.pieces.king.*;
import model.pieces.knight.*;
import model.pieces.pawn.*;
import model.pieces.rook.*;
import model.pieces.queen.*;
import tad.ListCoord;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private Map<Coordinate, Cell> cellMap;
    private IDeletedPieceManager deletedPieceManager;

    public Board() {
        deletedPieceManager = new DeletedPieceManager();
        cellMap = new HashMap<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cellMap.put(new Coordinate((char) ('A' + j), i + 1), new Cell(this, new Coordinate((char) ('A' + j), i + 1)));
            }
        }
    }

//    public Cell getCell(Coordinate coordinate) {
//        if (coordinate.getNumber() < 1 || coordinate.getNumber() > 8)
//            return null;
//        if (coordinate.getLetter() < 'A' || coordinate.getLetter() > 'H')
//            return null;
//        return cells[coordinate.getNumber() - 1][coordinate.getLetter() - 'A'];
//    }

    public void placePieces() {
        Piece p;
        p = new WhiteRook(getCell(new Coordinate('A', 8)));
        p.putInYourPlace();
        p = new WhiteRook(getCell(new Coordinate('H', 8)));
        p.putInYourPlace();
        p = new WhiteKnight(getCell(new Coordinate('B', 8)));
        p.putInYourPlace();
        p = new WhiteKnight(getCell(new Coordinate('G', 8)));
        p.putInYourPlace();
        p = new WhiteBishop(getCell(new Coordinate('C', 8)));
        p.putInYourPlace();
        p = new WhiteBishop(getCell(new Coordinate('F', 8)));
        p.putInYourPlace();
        p = new WhiteKing(getCell(new Coordinate('D', 8)));
        p.putInYourPlace();
        p = new WhiteQueen(getCell(new Coordinate('E', 8)));
        p.putInYourPlace();

        p = new BlackRook(getCell(new Coordinate('A', 1)));
        p.putInYourPlace();
        p = new BlackRook(getCell(new Coordinate('H', 1)));
        p.putInYourPlace();
        p = new BlackKnight(getCell(new Coordinate('B', 1)));
        p.putInYourPlace();
        p = new BlackKnight(getCell(new Coordinate('G', 1)));
        p.putInYourPlace();
        p = new BlackBishop(getCell(new Coordinate('C', 1)));
        p.putInYourPlace();
        p = new BlackBishop(getCell(new Coordinate('F', 1)));
        p.putInYourPlace();
        p = new BlackKing(getCell(new Coordinate('D', 1)));
        p.putInYourPlace();
        p = new BlackQueen(getCell(new Coordinate('E', 1)));
        p.putInYourPlace();

        for (int i = 0; i < 8; i++) {
            p = new BlackPawn(getCell(new Coordinate((char) ('A' + i), 2)));
            p.putInYourPlace();
            p = new WhitePawn(getCell(new Coordinate((char) ('A' + i), 7)));
            p.putInYourPlace();
        }
    }

    public boolean contains(Coordinate coordinate) {
        return coordinate.getLetter() >= 'A' &&
                coordinate.getLetter() <= 'H' &&
                coordinate.getNumber() >= 1 &&
                coordinate.getNumber() <= 8;
    }

    public void highlight(ListCoord coordinates) {
//        for (Coordinate c: coordinates)
//            getCell(c).highlight();
        for (int i = 0; i < coordinates.size(); i++) {
            getCell(coordinates.get(i)).highlight();
        }
    }

    public void resetColor() {
        for (Cell[] row : cells) {
            for (Cell cell : row)
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
        output += "\n\n" + deletedPieceManager.toString();
        return output;
    }
}
