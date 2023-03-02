package model;

import model.pieces.bishop.*;
import model.pieces.king.*;
import model.pieces.knight.*;
import model.pieces.pawn.*;
import model.pieces.rook.*;
import model.pieces.queen.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Board {
    private Map<Coordinate, Cell> cellMap;
    private IDeletedPieceManager deletedPieceManager;
    private IDeletedPieceManager currentPieceManager;

    /**
     *
     */
    public Board() {
        deletedPieceManager = new DeletedPieceManager();
        cellMap = new HashMap<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cellMap.put(new Coordinate((char) ('A' + i), j + 1), new Cell(this, new Coordinate((char) ('A' + i), j + 1)));
            }
        }
        placePieces();
//        currentPieceManager = new CurrentPieceManager(this);
    }

    /**
     * @param coordinate
     * @return
     */
    public Cell getCell(Coordinate coordinate) {
        return cellMap.get(coordinate);
    }

    public IDeletedPieceManager getDeletedPieceManager() {
        return deletedPieceManager;
    }

    public IDeletedPieceManager getCurrentPieceManager() {
        return currentPieceManager;
    }

    /**
     *
     */
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

    /**
     * @param coordinate
     * @return
     */
    public boolean contains(Coordinate coordinate) {
        return coordinate.getLetter() >= 'A' &&
                coordinate.getLetter() <= 'H' &&
                coordinate.getNumber() >= 1 &&
                coordinate.getNumber() <= 8;
    }

    public void highlight(Set<Coordinate> coordinates) {
        for (Coordinate c : coordinates)
            getCell(c).highlight();
    }

    /**
     * @see Cell
     */
    public void resetColor() {
        for (Cell cell : cellMap.values()) {
            cell.resetColor();
        }
    }

    public Map<Coordinate, Cell> getCellMap() {
        return cellMap;
    }

    @Override
    public String toString() {
        String output = "   A  B  C  D  E  F  G  H\n";
        for (int i = 0; i < 8; i++) {
            output += (i + 1) + " ";
            for (int j = 0; j < 8; j++) {
                output += cellMap.get(new Coordinate((char) ('A' + j), i + 1));
            }
            output += " " + (i + 1) + "\n";
        }
        output += "   A  B  C  D  E  F  G  H";
        output += "\n\nDELETE STORAGE\n" + deletedPieceManager.toString();
//        output += "\n\nCURRENT STORAGE\n" + currentPieceManager.toString();
        return output;
    }
}
