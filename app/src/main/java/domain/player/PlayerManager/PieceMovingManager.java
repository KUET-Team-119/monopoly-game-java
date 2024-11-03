package domain.player.PlayerManager;

import domain.component.Board;
import domain.component.Piece;
import domain.square.Square;
import domain.square.SquareType;

public class PieceMovingManager {
    private Piece piece;

    public PieceMovingManager(Piece piece) {
        this.piece = piece;
    }

    public void moveForward(int steps) {
        piece.moveForward(steps);
    }

    public void setLocation(Square location) {
        piece.setLocation(location);
    }

    public void setLocationAndReceiveSalary(Square location) {
        piece.setLocationAndReceiveSalary(location);
    }

    public void moveToSquareType(SquareType squareType) {
        piece.moveForward(Board.SQUARES_TOTAL - getCurrentLocationId() + squareType.getIndex());
    }

    public void goBack(int steps) {
        piece.setLocation(Board.squares.get(getCurrentLocationId() - steps));
    }

    public int getCurrentLocationId() {
        return piece.getLocationId();
    }
}
