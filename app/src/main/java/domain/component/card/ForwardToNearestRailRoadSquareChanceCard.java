package domain.component.card;

import domain.component.Board;
import domain.player.Player;
import domain.square.RailRoadSquare;
import domain.square.Square;
import domain.square.SquareType;
import domain.square.UtilitySquare;

public class ForwardToNearestRailRoadSquareChanceCard extends ForwardToNearestSquareChanceCard {

    private final int GO_SQUARE_INDEX = SquareType.GO.getIndex();

    @Override
    protected Class<? extends Square> getTargetSquareClass() {
        return RailRoadSquare.class;
    }

}
