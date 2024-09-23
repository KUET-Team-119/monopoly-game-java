package domain.component.property;

import java.util.Objects;

import domain.player.Player;

public abstract class Property {
    int id;
    String name;
    int price;
    Player owner;

    public Property(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public abstract int getRent();

    public void setOwner(Player player) {
        owner = player;
        player.gainProperty(this);
    }

    public Player getOwner() {
        return owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Property property))
            return false;
        return this.id == property.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}