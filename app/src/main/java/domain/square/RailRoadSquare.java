package domain.square;

import domain.component.property.RailRoadProperty;
import domain.player.Player;

public class RailRoadSquare extends PropertySquare {

    public RailRoadSquare(int id, String name, int price) {
        this.property = new RailRoadProperty(id, name, price);
    }

    @Override
    void landedOn(Player player) {
        // TODO
    }
    
}
