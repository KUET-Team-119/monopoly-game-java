package domain.component.card;

import domain.component.Board;
import domain.player.Player;
import domain.square.SquareType;

public class ForwardToGoSquareChanceCard extends ChanceCard {

    private final int GO_SQUARE_INDEX = SquareType.GO.getIndex();

    @Override
    void takeEffect(Player player) {
        player.askForGoForward(SquareType.GO);
    }
}
