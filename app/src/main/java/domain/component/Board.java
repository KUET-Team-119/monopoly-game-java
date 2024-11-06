package domain.component;

import java.util.HashMap;
import java.util.Map;

import domain.square.Square;
import domain.square.SquareFactory;
import domain.square.SquareType;

public class Board {
    public static final int SQUARES_TOTAL = 40;
    public static Map<Integer, Square> squares;

    public Board() {
        squares = new HashMap<>();
        build();
    }

    private void build() {
        for (SquareType type : SquareType.values()) {
            squares.put(type.getIndex(), SquareFactory.createSquare(type));
        }
    }
}