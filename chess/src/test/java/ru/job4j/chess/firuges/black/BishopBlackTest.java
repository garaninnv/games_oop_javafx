package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class BishopBlackTest {

    @Test
    void whenPositionMatched() {
        BishopBlack expendet = new BishopBlack(Cell.A2);
        assertEquals(expendet.position(), Cell.A2);
    }

    @Test
    void whenWayDiagonal1() {
        BishopBlack expected = new BishopBlack(Cell.C1);
        Cell[] arrays = expected.way(Cell.G5);
        Cell[] expectArray = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertArrayEquals(arrays, expectArray);
    }

    @Test
    void whenWayDiagonal2() {
        BishopBlack expected = new BishopBlack(Cell.C8);
        Cell[] arrays = expected.way(Cell.G4);
        Cell[] expectArray = new Cell[]{Cell.D7, Cell.E6, Cell.F5, Cell.G4};
        assertArrayEquals(arrays, expectArray);
    }

    @Test
    void whenIsDiagonalTrue() {
        BishopBlack exp = new BishopBlack(Cell.C1);
        assertTrue(exp.isDiagonal(Cell.C1, Cell.G5));
    }

    @Test
    void whenIsDiagonalFalse() {
        BishopBlack exp = new BishopBlack(Cell.C1);
        assertFalse(exp.isDiagonal(Cell.C1, Cell.C2));
    }

    @Test
    void whenCopyTrue() {
        BishopBlack expendet = new BishopBlack(Cell.A2);
        Figure expendetCopy = expendet.copy(Cell.A1);
        assertEquals(expendetCopy.position(), Cell.A1);
    }
}