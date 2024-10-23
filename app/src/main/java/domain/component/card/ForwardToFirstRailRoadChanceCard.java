package domain.component.card;

import domain.player.Player;
import domain.square.SquareType;

public class ForwardToFirstRailRoadChanceCard extends ChanceCard {

    public ForwardToFirstRailRoadChanceCard(int index, String name) {
        this.index = index;
        this.name = name;
    }

    @Override
    public void takeEffect(Player player) {
        player.askForMoveForward(SquareType.RAILROAD_GWANGJU);
    }
}
