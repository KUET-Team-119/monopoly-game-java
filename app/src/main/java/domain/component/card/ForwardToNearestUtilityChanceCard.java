package domain.component.card;

import domain.square.Square;
import domain.square.UtilitySquare;

public class ForwardToNearestUtilityChanceCard extends ForwardToNearestChanceCard {

    public ForwardToNearestUtilityChanceCard(int index, String name) {
        super(index, name);
    }

    @Override
    protected Class<? extends Square> getTargetSquareClass() {
        return UtilitySquare.class;
    }

}
