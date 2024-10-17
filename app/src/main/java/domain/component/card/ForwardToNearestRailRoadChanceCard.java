package domain.component.card;

import domain.square.RailRoadSquare;
import domain.square.Square;

public class ForwardToNearestRailRoadChanceCard extends ForwardToNearestChanceCard {

    public ForwardToNearestRailRoadChanceCard(int id, String name) {
        super(id, name);
    }

    @Override
    protected Class<? extends Square> getTargetSquareClass() {
        return RailRoadSquare.class;
    }

}
