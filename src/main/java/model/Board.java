package model;

import model.pieces.bishop.*;
import model.pieces.king.*;
import model.pieces.knight.*;
import model.pieces.rook.*;
import model.pieces.queen.*;
import model.pieces.pawn.*;
import storagePieces.CurrentPieceManager;
import storagePieces.DeletedPieceManager;
import storagePieces.ICurrentPieceManager;
import storagePieces.IDeletedPieceManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Board {
    private Map<Coordinate, Cell> cellMap;
    private IDeletedPieceManager deletedPieceManager;
    private ICurrentPieceManager currentPieceManager;

    /**
     * board builder.
     */
    public Board() {
        cellMap = new HashMap<>();
        deletedPieceManager = new DeletedPieceManager();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cellMap.put(new Coordinate((char) ('A' + i), j + 1), new Cell(this, new Coordinate((char) ('A' + i), j + 1)));
            }
        }
        placePieces();
        currentPieceManager = new CurrentPieceManager(this);
    }

    /**
     * @param coordinate from cell to get.
     * @return cell of coordinate like Map.
     */
    public Cell getCell(Coordinate coordinate) {
        return cellMap.get(coordinate);
    }

    /**
     * @return the pieces you've killed.
     */
    public IDeletedPieceManager getDeletedPieceManager() {
        return deletedPieceManager;
    }

    /**
     * @return the piece you've on the board.
     */
    public ICurrentPieceManager getCurrentPieceManager() {
        return currentPieceManager;
    }

    /**
     * put the pieces on the board.
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
     * @param coordinate that checks if it is on the board.
     * @return true if exists the coordinate.
     *          false if not exists the coordinate.
     */
    public boolean contains(Coordinate coordinate) {
        return coordinate.getLetter() >= 'A' &&
                coordinate.getLetter() <= 'H' &&
                coordinate.getNumber() >= 1 &&
                coordinate.getNumber() <= 8;
    }

    /**
     * @param coordinates you want to highlight.
     */
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

    /**
     * @return cellMap.
     */
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
        return output;
    }
}
