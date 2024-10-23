package domain.square;

import domain.component.property.UtilityProperty;

public class UtilitySquare extends PropertySquare {
    public UtilitySquare(int index, String name, int price) {
        super(index, name);
        property = new UtilityProperty(index, name, price);
    }
}