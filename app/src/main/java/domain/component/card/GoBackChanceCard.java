package domain.component.card;

import domain.component.Board;
import domain.component.Piece;
import domain.player.Player;

public class GoBackChanceCard extends ChanceCard {

    private final int BACK = 3;

    @Override
    void takeEffect(Player player) {
        Piece piece = player.getPiece();
        int currentLocationId = piece.getLocation().getId();

        piece.setLocation(Board.squares.get(currentLocationId - BACK));
    }
}
