package domain.component.card;

import domain.component.Board;
import domain.player.Player;
import domain.square.SquareType;

public class ForwardToGoSquareChanceCard extends ChanceCard {

    private final int GO_SQUARE_INDEX = SquareType.GO.getIndex();

    @Override
    void takeEffect(Player player) {
        int currentLocationId = player.getPiece().getLocation().getId();
        // 항상 출발점에 도착하는지 확인 필요
        player.getPiece().setLocation(Board.squares.get(currentLocationId));
    }
}
