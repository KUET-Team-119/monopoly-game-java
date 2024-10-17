package domain.component.card;

import domain.component.Board;
import domain.player.Player;
import domain.square.SquareType;

public class ForwardToStartChanceCard extends ChanceCard {

    public ForwardToStartChanceCard(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void takeEffect(Player player) {
        player.askForMoveForward(SquareType.START);
    }
}
