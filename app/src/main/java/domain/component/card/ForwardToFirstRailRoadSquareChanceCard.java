package domain.component.card;

import domain.component.Board;
import domain.player.Player;
import domain.square.SquareType;

public class ForwardToFirstRailRoadSquareChanceCard extends ChanceCard {

    @Override
    void takeEffect(Player player) {
        player.askForGoForward(SquareType.RAILROAD_GWANGJU);
    }
}
