package domain.component.card;

import domain.component.Board;
import domain.player.Player;
import domain.square.Square;
import domain.square.SquareType;

public class GoToJailSocialFundCard extends SocialFundCard {
    private final Square JAIL_SQUARE = Board.squares.get(SquareType.JAIL.getIndex());

    public GoToJailSocialFundCard(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void takeEffect(Player player) {
        player.getPiece().setLocation(JAIL_SQUARE);
    }
    
}
