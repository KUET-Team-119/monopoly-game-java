package domain.square;

import domain.component.property.LotProperty;

public class LotSquare extends PropertySquare {

    public LotSquare(int index, String name, int price) {
        super(index, name);
        this.property = new LotProperty(index, name, price);
    }
}