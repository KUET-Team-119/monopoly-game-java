package domain.component.card;

import domain.component.Board;
import domain.player.Player;
import domain.square.Square;
import domain.square.SquareType;

public class GoToJailChanceCard extends ChanceCard {

    public GoToJailChanceCard(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void takeEffect(Player player) {
        player.askForSetLocation(Board.squares.get(SquareType.JAIL.getIndex()));
    }
}
