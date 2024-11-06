package domain.square;

import domain.component.property.RailRoadProperty;

public class RailRoadSquare extends PropertySquare {

    public RailRoadSquare(int index, String name, int price) {
        super(index, name);
        property = new RailRoadProperty(index, name, price);
    }

}
