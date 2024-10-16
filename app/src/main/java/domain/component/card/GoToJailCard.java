package domain.component.card;

import domain.component.Board;
import domain.player.Player;
import domain.square.Square;
import domain.square.SquareType;

public class GoToJailCard extends SocialFundCard {
    private final Square JAIL_SQUARE = Board.squares.get(SquareType.JAIL.getIndex());

    public GoToJailCard(int index, String name) {
        this.index = index;
        this.name = name;
    }

    @Override
    public void takeEffect(Player player) {
        player.getPiece().setLocation(JAIL_SQUARE);
    }
    
}
