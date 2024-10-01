package domain.square;

import domain.component.property.RailRoadProperty;
import domain.player.Player;

public class RailRoadSquare extends PropertySquare {
    private final int RAILROAD_RENT = 25;

    public RailRoadSquare(int id) {
        super(id);
        property = new RailRoadProperty(id, name, id);
    }

}
