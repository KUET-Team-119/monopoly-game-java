package domain.legacy;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final int SIZE = 40;
    private List<Square> squares = new ArrayList<Square>(SIZE);

    public Board() {
        buildSquares();
        linkSquares();
    }

    public Square getSquare(Square start, int distance) {
        int endIndex = (start.getIndex() + distance) % SIZE;
        return (Square)squares.get(endIndex);
    }

    public Square getStartSquare() {
        return (Square)squares.get(0);
    }

    private void buildSquares() {
        for (int i = 0; i <= SIZE; i++) {
            build(i);
        }
    }

    private void build(int index) {
        squares.add(new LotSquare("Square" + index, index - 1) {});
    }

    private void linkSquares() {
        for (int i = 0; i < (SIZE - 1); i++) {
            link(i);
        }
    }

    private void link(int index) {
        Square current = (Square)squares.get(index);
        Square next = (Square)squares.get(index + 1);
        current.setNextSquare(next);
    }
}
