package domain.component.card;

import domain.component.Board;
import domain.player.Player;
import domain.square.Square;

public abstract class ForwardToNearestChanceCard extends ChanceCard {

    public ForwardToNearestChanceCard(int index, String name) {
        this.index = index;
        this.name = name;
    }

    protected abstract Class<? extends Square> getTargetSquareClass();

    @Override
    public void takeEffect(Player player) {
        int currentLocationId = player.getPieceMovingManager().getCurrentLocationId();
        Class<? extends Square> targetSquare = getTargetSquareClass();

        int destinationId = -1;

        for (int i = currentLocationId + 1; i < Board.squares.size(); i++) {
            Square square = Board.squares.get(i);
            if (targetSquare.isInstance(square)) {
                destinationId = square.getId();
                break;
            }
        }

        if (destinationId != -1) {
            player.getPieceMovingManager().setLocation(Board.squares.get(destinationId));
            return;
        }

        // 유틸리티 칸이 없다면, 보드 처음부터 탐색
        for (int i = 0; i <= currentLocationId; i++) {
            Square square = Board.squares.get(i);
            if (targetSquare.isInstance(square)) {
                destinationId = square.getId();
                break;
            }
        }

        player.getPieceMovingManager().setLocationAndReceiveSalary(Board.squares.get(destinationId));
    }

}
