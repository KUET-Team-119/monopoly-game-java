package domain.component.card;

import domain.component.Board;
import domain.player.Player;
import domain.square.Square;
import domain.square.SquareType;

public class GoToJailChanceCard extends ChanceCard {

    private final Square JAIL_SQUARE = Board.squares.get(SquareType.JAIL.getIndex());

    @Override
    public void takeEffect(Player player) {
        player.getPiece().setLocation(JAIL_SQUARE);
    }
}
