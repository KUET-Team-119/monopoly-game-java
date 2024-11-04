package domain.player.PlayerManager;

import domain.component.Piece;
import domain.player.Player;
import domain.square.SquareType;

public class PieceMovingManager {
    private Piece piece;

    public PieceMovingManager(String id, Player player) {
        this.piece = new Piece(id, player);
    }

    // 말을 몇 칸 앞으로 이동시키는 행동
    public void moveForwardBySteps(int steps) {
        piece.moveForwardBySteps(steps);
    }

    // 말을 몇 칸 뒤로 이동시키는 행동
    public void moveBackwardBySteps(int steps) {
        piece.moveBackwardBySteps(steps);
    }

    // 말을 특정 칸까지 앞으로 이동시키는 행동
    public void moveForwardToSquareType(SquareType destination) {
        piece.moveFowardToSquareType(destination);
    }

    // 말을 특정 칸으로 순간이동시키는 행동
    public void warpToSquareType(SquareType destination) {
        piece.setLocation(destination);
    }

    public int getCurrentLocationId() {
        return piece.getLocationId();
    }
}
