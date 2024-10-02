package domain.square;

import domain.component.property.UtilityProperty;

public class UtilitySquare extends PropertySquare {

    public UtilitySquare(int id, String name, int price) {
        super(id, name);
        property = new UtilityProperty(id, name, price);
    }
}
