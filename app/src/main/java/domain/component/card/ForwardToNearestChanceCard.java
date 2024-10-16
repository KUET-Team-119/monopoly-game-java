package domain.component.card;

import domain.component.Board;
import domain.player.Player;
import domain.square.Square;

public abstract class ForwardToNearestChanceCard extends ChanceCard {

    protected abstract Class<? extends Square> getTargetSquareClass();

    @Override
    public void takeEffect(Player player) {
        int currentLocationId = player.getPiece().getLocation().getId();
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
            player.getPiece().setLocation(Board.squares.get(destinationId));
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

        player.getPiece().setLocationAndReceiveSalary(Board.squares.get(destinationId));
    }

}
