package domain.component.card;

import domain.component.Board;
import domain.player.Player;
import domain.square.RailRoadSquare;
import domain.square.Square;
import domain.square.SquareType;

public class ForwardToNearestRailRoadSquareChanceCard extends ChanceCard {

    private final int GO_SQUARE_INDEX = SquareType.GO.getIndex();

    @Override
    void takeEffect(Player player) {
        int destinationId = 0;
        int currentLocationId = player.getPiece().getLocation().getId();

        for (Square square : Board.squares.values()) {
            if (square.getId() < currentLocationId) {
                continue;
            }
            if (square instanceof RailRoadSquare) {
                destinationId = square.getId();
                break;
            }
        }
        player.getPiece().setLocation(Board.squares.get(destinationId));
    }
}
