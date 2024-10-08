package domain.component.card;

import domain.component.Board;
import domain.player.Player;
import domain.square.Square;
import domain.square.SquareType;

public class FowardToGoSquareCard extends SocialFundCard {
    private final Square GO_SQUARE = Board.squares.get(SquareType.GO.getIndex());

    FowardToGoSquareCard(int index, String name) {
        this.index = index;
        this.name = name;
    }

    @Override
    public void takeEffect(Player player) {
        player.getPiece().setLocation(GO_SQUARE);
    }
    
}
