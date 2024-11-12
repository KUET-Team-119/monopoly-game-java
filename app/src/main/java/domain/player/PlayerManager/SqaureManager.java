package domain.player.PlayerManager;

import java.util.ArrayList;
import java.util.List;

import domain.square.RailRoadSquare;
import domain.square.Square;
import domain.square.UtilitySquare;

public class SqaureManager {
    private List<Square> squares;

    public SqaureManager() {
        this.squares = new ArrayList<Square>();
    }

    public void addSquare(Square square) {
        squares.add(square);
    }

    public int countRailRoadSquares() {
        int count = 0;
        for (Square square : squares) {
            if (square instanceof RailRoadSquare) {
                count++;
            }
        }
        return count;
    }

    public int countUtilitySquares() {
        int count = 0;
        for (Square square : squares) {
            if (square instanceof UtilitySquare) {
                count++;
            }
        }
        return count;
    }

    public List<Square> getSquares() {
        return squares;
    }
}
