package domain.square;

import domain.player.Player;
import domain.component.property.Property;

public abstract class PropertySquare extends Square {
    protected boolean soldOut;
    protected Property property;

    public PropertySquare(int index, String name) {
        this.index = index;
        this.name = name;
        this.soldOut = false;
    }

    public void setOwner(Player player) {
        soldOut = true;
        property.setOwner(player);
    }
}
