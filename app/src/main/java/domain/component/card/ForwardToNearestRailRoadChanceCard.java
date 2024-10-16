package domain.component.card;

import domain.square.RailRoadSquare;
import domain.square.Square;

public class ForwardToNearestRailRoadChanceCard extends ForwardToNearestChanceCard {

    @Override
    protected Class<? extends Square> getTargetSquareClass() {
        return RailRoadSquare.class;
    }

}
