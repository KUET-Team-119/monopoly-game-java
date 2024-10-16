package domain.component.card;

import domain.component.Board;
import domain.player.Player;

public class ForwardToStartChanceCard extends ChanceCard {

    @Override
    public void takeEffect(Player player) {
        int currentLocationId = player.getPiece().getLocation().getId();
        // 항상 출발점에 도착하는지 확인 필요
        player.getPiece().moveForward(Board.SQUARES_TOTAL - currentLocationId);
    }
}
