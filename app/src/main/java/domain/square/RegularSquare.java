package domain.square;

public class RegularSquare extends Square {

    boolean isSelled;
    Property property;

    public RegularSquare(int id) {
        super(id);
        isSelled = false;
        property = new Property(id, name);
    }

    public int findPrice() {
        return property.getPrice();
    }

    public int findRent() {
        return property.getRent();
    }

    public void setOwner(Player player) {
        isSelled = true;
        property.setOwner(player);
    }

    public Player findOwner() {
        return property.getOwner();
    }
}