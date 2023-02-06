package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class BishopBlackTest {

    @Test
    void position() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D6);
        Cell expect = Cell.D6;
        assertThat(bishopBlack.position()).isEqualTo(expect);
    }

    @Test
    void way() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.way(Cell.G5);

    }

    @Test
    void isDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C4);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class,
                () -> bishopBlack.way(Cell.C5));
        String expect = "Could not move by diagonal from C4 to C5";
        assertThat(exception.getMessage()).isEqualTo(expect);
    }

    @Test
    void copy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D6);
        Cell expect = Cell.D6;
        assertThat(bishopBlack.copy(Cell.D6).position()).isEqualTo(expect);
    }
}