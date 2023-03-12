package model;

import java.io.Serializable;

public class Coordinate implements Serializable {
    private int number;
    private char letter;

    /**
     * coordinate builder
     */
    public Coordinate(char letter, int number) {
        this.number = number;
        this.letter = Character.toUpperCase(letter);
    }

    public int getNumber() {
        return number;
    }

    public char getLetter() {
        return letter;
    }

    /**
     * this method return the next coordinate of the position
     */

    public Coordinate up() {
        return new Coordinate(letter, number - 1);
    }

    public Coordinate down() {
        return new Coordinate(letter, number + 1);
    }

    public Coordinate right() {
        return new Coordinate((char) (letter + 1), number);
    }

    public Coordinate left() {
        return new Coordinate((char) (letter - 1), number);
    }

    public Coordinate diagonalUpLeft() {
        return up().left();
    }

    public Coordinate diagonalUpRight() {
        return up().right();
    }

    public Coordinate diagonalDownLeft() {
        return down().left();
    }

    public Coordinate diagonalDownRight() {
        return down().right();
    }

    @Override
    public String toString() {
        return "(" + letter + "," + number + " )";
    }


    //we are override equals to compare objects. no memory direction.
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Coordinate))
            return false;
        Coordinate c = (Coordinate) o;
        return (c.getLetter() == this.letter) && (c.getNumber() == this.number);
    }

    @Override
    public int hashCode() {
        return number;
    }
}
