package domain.square;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public static final int SQUARES_TOTAL = 40;

    List<Square> squares;

    public Board() {
        squares = new ArrayList<Square>(SQUARES_TOTAL);

        for (int i = 0; i < 40; i++) {
            squares.add(new RegularSquare(i));
        }
    }
}