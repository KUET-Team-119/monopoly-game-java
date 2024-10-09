package domain.component.card;

import domain.component.Board;
import domain.player.Player;
import domain.square.Square;
import domain.square.SquareType;

public class ForwardToGoSquareChanceCard extends ChanceCard {

    private final Square GO_SQUARE = Board.squares.get(SquareType.GO.getIndex());

    @Override
    void takeEffect(Player player) {
        player.getPiece().setLocation(GO_SQUARE);
    }
}
