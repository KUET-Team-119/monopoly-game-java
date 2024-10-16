package domain.component.card;

import domain.component.Board;
import domain.player.Player;
import domain.square.SquareType;

public class ForwardToFirstRailRoadChanceCard extends ChanceCard {

    @Override
    public void takeEffect(Player player) {
        int currentLocationId = player.getPiece().getLocation().getId();
        // 항상 광주역에 도착하는지 확인 필요
        player.getPiece().moveForward(Board.SQUARES_TOTAL - currentLocationId + SquareType.RAILROAD_GWANGJU.getIndex());
    }
}
