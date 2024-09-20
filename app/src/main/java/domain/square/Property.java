package domain.square;

import java.util.Objects;

public class Property {
    int id;
    String name;
    int price;
    int rent;
    Player owner;

    public Property(int id, String name) {
        this(id, name, 5_000);
    }

    public Property(int id, String name, int price) {
        this(id, name, price, 10_000);
    }

    public Property(int id, String name, int price, int rent) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rent = rent;
    }

    public int getPrice() {
        return price;
    }

    public Player getOwner() {
        return owner;
    }

    public int getRent() {
        return rent;
    }

    public void setOwner(Player player) {
        owner = player;
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