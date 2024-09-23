package domain.square;

import domain.component.property.Property;
import domain.player.Player;

public abstract class PropertySquare extends Square{
    protected boolean soldOut = false;
    protected Property property;

    public Player findOwner() {
        return property.getOwner();
    }

    public void setOwner(Player player) {
        soldOut = true;
        property.setOwner(player);
    }

    public int findPrice() {
        return property.getPrice();
    }

    public int findRent() {
        return property.getRent();
    }

    public boolean isSoldOut() {
        return soldOut;
    }

    public void setSoldOut(boolean soldOut) {
        this.soldOut = soldOut;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
