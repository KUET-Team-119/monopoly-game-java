package domain.square;

import domain.component.property.RailRoadProperty;
import domain.player.Player;

public class RailRoadSquare extends PropertySquare {

    public RailRoadSquare(int index, String name, int price) {
        super(index, name);
        property = new RailRoadProperty(index, name, price);
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
