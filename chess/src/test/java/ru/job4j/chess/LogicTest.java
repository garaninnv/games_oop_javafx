package ru.job4j.chess;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class LogicTest {

    @Test
    void whenMoveFigureNotFoundException() throws FigureNotFoundException {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () -> {
            logic.move(Cell.F8, Cell.D6);
        });
        assertThat(exception.getMessage() == null);
    }

    @Test
    void whenMoveOccupiedCellException() throws OccupiedCellException {
        Logic logic = new Logic();
        OccupiedCellException exception = assertThrows(OccupiedCellException.class, () -> {
            logic.move(Cell.F8, Cell.E7);
        });
        assertThat(exception.getMessage().equals("Cell is occupied by another Figure."));
    }

    @Test
    void whenMoveImpossibleMoveException() throws ImpossibleMoveException {
        Logic logic = new Logic();
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            logic.move(Cell.F8, Cell.E6);
        });
        assertThat(exception.getMessage().equals("Could not move by diagonal from F8 to E6"));
    }
}