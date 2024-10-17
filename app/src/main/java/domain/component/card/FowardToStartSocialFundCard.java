package domain.component.card;

import domain.component.Board;
import domain.player.Player;
import domain.square.Square;
import domain.square.SquareType;

public class FowardToStartSocialFundCard extends SocialFundCard {
    private final Square GO_SQUARE = Board.squares.get(SquareType.GO.getIndex());

    FowardToStartSocialFundCard(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void takeEffect(Player player) {
        player.getPiece().setLocation(GO_SQUARE);
    }
    
}
