package domain.component;

import java.util.HashMap;
import java.util.Map;

import domain.square.Square;
import domain.square.SquareFactory;
import domain.square.SquareType;

public class Board {
    public static final int SQUARES_TOTAL = 40;
    public static final int MAX_COUNT_OF_HOUSE = 32;
    public static final int MAX_COUNT_OF_HOTEL = 12;
    public static Map<Integer, Square> squares;

    public static int currentCountOfHouse;
    public static int currentCountOfHotel;

    public Board() {
        squares = new HashMap<>();
        currentCountOfHouse = 0;
        currentCountOfHotel = 0;
        createSquare();
    }

    public static boolean canBuildHouse() {
        return currentCountOfHouse < MAX_COUNT_OF_HOUSE;
    }

    public static boolean canBuildHotel() {
        return currentCountOfHotel < MAX_COUNT_OF_HOTEL;
    }

    public static void addCountOfHouse() {
        currentCountOfHouse++;
    }

    public static void addCountOfHotel() {
        currentCountOfHotel++;
    }

    private void createSquare() {
        for (SquareType type : SquareType.values()) {
            squares.put(type.getIndex(), SquareFactory.createSquare(type));
        }
    }
}