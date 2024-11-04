package domain.component.card;

import domain.player.Player;
import domain.square.SquareType;

public class GoToJailChanceCard extends ChanceCard {

    public GoToJailChanceCard(int index, String name) {
        this.index = index;
        this.name = name;
    }

    @Override
    public void takeEffect(Player player) {
        player.getPieceMovingManager().warpToSquareType(SquareType.JAIL);
    }
}
