package domain.square;

import java.util.Objects;

import domain.component.property.LotProperty;
import domain.player.Player;

public class LotSquare extends PropertySquare {

    public LotSquare(int id, String name) {
        property = new LotProperty(id, name, id);
    }

    @Override
    public void landedOn(Player player) {
        // TODO
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