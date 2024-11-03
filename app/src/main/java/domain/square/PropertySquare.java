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

    public void landedOn(Player player) {
        Player owner = property.getOwner();
        int price = property.getPrice();
        if (owner == null && player.getCashManager().getCash() >= price) {
            player.getCashManager().reduceCash(price);
            player.getPropertyManager().addProperty(property);
            setOwner(player);
            return;
        }
        if (owner == player) {
            return;
        }
        int rent = property.getRent();
        owner.getCashManager().addCash(rent);
        player.getCashManager().reduceCash(rent);
    }
}
