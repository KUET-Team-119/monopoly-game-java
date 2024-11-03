package domain.component.card;

import domain.component.Board;
import domain.player.Player;
import domain.square.Square;
import domain.square.SquareType;

public class ForwardToStartSocialFundCard extends SocialFundCard {
    private final Square GO_SQUARE = Board.squares.get(SquareType.START.getIndex());

    ForwardToStartSocialFundCard(int index, String name) {
        this.index = index;
        this.name = name;
    }

    @Override
    public void takeEffect(Player player) {
        player.getPieceMovingManager().setLocation(GO_SQUARE);
    }
    
}
