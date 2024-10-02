package domain.square;

import domain.component.property.RailRoadProperty;

public class RailRoadSquare extends PropertySquare {

    public RailRoadSquare(int id, String name, int price) {
        super(id, name);
        property = new RailRoadProperty(id, name, price);
    }

}
