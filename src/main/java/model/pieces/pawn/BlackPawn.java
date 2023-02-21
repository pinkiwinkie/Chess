package model.pieces.pawn;

import model.Cell;
import model.Coordinate;
import model.pieces.queen.BlackQueen;
import java.util.HashSet;
import java.util.Set;

public class BlackPawn extends Pawn {
    private Set<Coordinate> coordinates;
    public BlackPawn(Cell cell){
        super(Type.BLACK_PAWN,cell);
    }

    @Override
    public Set<Coordinate> getNextMovements() {
        coordinates = new HashSet<>();
        Coordinate position = getCell().getCoordinate(), c;

        //UP
        c= position.down();
        checkPawnMove(c);
        if (getCell().getCoordinate().getNumber()==2) {
            c = position.down().down();
            checkPawnMove(c);
        }

        c=position.diagonalDownLeft();
        checkPawnKiller(c);
        c = position.diagonalDownRight();
        checkPawnKiller(c);

        return coordinates;
    }
    @Override
    public void transform() {
        new BlackQueen(getCell());
        cell=null;
    }

}
