package domain.component.card;

import domain.player.Player;
import domain.square.SquareType;

public class ForwardToStartChanceCard extends ChanceCard {

    public ForwardToStartChanceCard(int index, String name) {
        this.index = index;
        this.name = name;
    }

    @Override
    public void takeEffect(Player player) {
        player.askForMoveForward(SquareType.START);
    }
}
