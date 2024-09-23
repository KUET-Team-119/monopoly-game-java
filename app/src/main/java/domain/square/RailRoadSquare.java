package domain.square;

import domain.component.property.RailRoadProperty;
import domain.player.Player;

public class RailRoadSquare extends PropertySquare {

    public RailRoadSquare(int id) {
        property = new RailRoadProperty(id, name, id);
    }

    @Override
    void landedOn(Player player) {
        // TODO
    }
    
}
