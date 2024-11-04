package domain.component.property;

import domain.player.Player;

public abstract class Property {
    int index;
    String name;
    int price;
    Player owner;

    public Property(int index, String name, int price) {
        this.index = index;
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public abstract int getRent();

    public void setOwner(Player player) {
        owner = player;
        player.getPropertyManager().addProperty(this);
    }

    public Player getOwner() {
        return owner;
    }
}