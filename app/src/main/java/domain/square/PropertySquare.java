package domain.square;

import domain.player.Player;
import domain.component.property.Property;

public abstract class PropertySquare extends Square {
    protected boolean soldOut = false;
    protected Property property;

    public PropertySquare(int id) {
        super(id);
    }

    public void setOwner(Player player) {
        soldOut = true;
        property.setOwner(player);
    }

    public void landedOn(Player player) {
        Player owner = property.getOwner();
        if (owner == null) {
            player.attemptPurchase(this, property.getPrice());
            return;
        }
        if (owner == player) {
            return;
        }
        int rent = property.getRent();
        owner.addCash(rent);
        player.reduceCash(rent);
    }
}
