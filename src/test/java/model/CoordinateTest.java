package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    @Test
    @DisplayName("New coordinate in up direction")
    void up() {
        Coordinate c1 = new Coordinate('c', 2);
        Coordinate c2 = new Coordinate('c',3).up();
        assertEquals(c1,c2);
    }

    @Test
    @DisplayName("New coordinate in down direction")
    void down() {
        Coordinate c1 = new Coordinate('c', 3);
        Coordinate c2 = new Coordinate('c',2).down();
        assertEquals(c1,c2);
        assertEquals(new Coordinate('f',8), new Coordinate('f',7).down());
    }

    @Test
    @DisplayName("New coordinate in right direction")
    void right() {
        Coordinate c1 = new Coordinate('d', 2);
        Coordinate c2 = new Coordinate('c',2).right();
        assertEquals(c1,c2);
    }

    @Test
    @DisplayName("New coordinate in left direction")
    void left() {
    }

    @Test
    void diagonalUpLeft() {
    }

    @Test
    void diagonalUpRight() {
    }

    @Test
    void diagonalDownLeft() {
    }

    @Test
    void diagonalDownRight() {
    }
}