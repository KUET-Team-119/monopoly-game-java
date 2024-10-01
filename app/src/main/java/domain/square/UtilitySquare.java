package domain.square;

import domain.component.property.UtilityProperty;
import domain.player.Player;

public class UtilitySquare extends PropertySquare {

    public UtilitySquare(int id, String name, int price) {
        super(id);
        property = new UtilityProperty(id, name, price);
    }
}
