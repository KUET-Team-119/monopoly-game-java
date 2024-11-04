package domain.square;

import domain.component.property.UtilityProperty;
import domain.player.Player;

public class UtilitySquare extends PropertySquare {
    public UtilitySquare(int index, String name, int price) {
        super(index, name);
        property = new UtilityProperty(index, name, price);
    }

    @Override
    public void landedOn(Player player) {
        Player owner = property.getOwner();
        int price = property.getPrice();
        if (owner == null && player.getCashManager().hasEnoughCash(price)) {
            player.getCashManager().reduceCash(price);
            player.getPropertyManager().addProperty(property);
            setOwner(player);
            return;
        }
        if (owner == player) {
            return;
        }
        int rent = property.getRent();
        int amount = player.getCashManager().reduceCash(rent);
        owner.getCashManager().addCash(amount);
    }
}