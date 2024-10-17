package domain.component.card;

import domain.square.Square;
import domain.square.UtilitySquare;

public class ForwardToNearestUtilityChanceCard extends ForwardToNearestChanceCard {

    public ForwardToNearestUtilityChanceCard(int id, String name) {
        super(id, name);
    }

    @Override
    protected Class<? extends Square> getTargetSquareClass() {
        return UtilitySquare.class;
    }

}
