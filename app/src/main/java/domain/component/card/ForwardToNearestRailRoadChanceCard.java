package domain.component.card;

import domain.square.RailRoadSquare;
import domain.square.Square;

public class ForwardToNearestRailRoadChanceCard extends ForwardToNearestChanceCard {

    public ForwardToNearestRailRoadChanceCard(int index, String name) {
        super(index, name);
    }

    @Override
    protected Class<? extends Square> getTargetSquareClass() {
        return RailRoadSquare.class;
    }

}
