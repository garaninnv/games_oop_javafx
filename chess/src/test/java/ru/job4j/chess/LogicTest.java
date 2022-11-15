package ru.job4j.chess;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () -> {
            logic.move(Cell.C1, Cell.H6);
        });
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

@Test
public void whenMoveThenOccupiedCellException()
        throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
    Logic logic = new Logic();
    BishopBlack bishopBlack = new BishopBlack(Cell.A3);
    BishopBlack bishopBlack1 = new BishopBlack(Cell.C5);
    logic.add(bishopBlack);
    logic.add(bishopBlack1);
    OccupiedCellException exception = assertThrows(OccupiedCellException.class, () -> {
        logic.move(bishopBlack.position(), bishopBlack1.position());
    });
    assertThat(exception.getMessage()).isEqualTo("Cell is occupied by another Figure.");
}

    @Test
    public void whenMoveThenImpossibleMoveException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.A3);
        logic.add(bishopBlack);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            logic.move(Cell.A3, Cell.C6);
        });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from A3 to C6");
    }
}