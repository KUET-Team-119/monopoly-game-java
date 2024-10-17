package domain.component.card;

import domain.player.Player;
import domain.square.SquareType;

public class ForwardToFirstRailRoadChanceCard extends ChanceCard {

    public ForwardToFirstRailRoadChanceCard(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void takeEffect(Player player) {
        player.askForMoveForward(SquareType.RAILROAD_GWANGJU);
    }
}
