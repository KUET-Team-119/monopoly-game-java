package domain.square;

import domain.component.property.LotProperty;

public class LotSquare extends PropertySquare {

    public LotSquare(int id, String name, int price) {
        this.property = new LotProperty(id, name, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof LotSquare regularSquare))
            return false;
        return this.id == regularSquare.id;
    }

    @Override
    public int hashCode() {
        return this.id;
    }
}