package domain.legacy;

public abstract class PropertySquare extends Square {

    private int price;
    private Player owner;

    public PropertySquare(String name, int index) {
        super(name, index);
        this.price = price;
    }

    public void landedOn(Player player) {
        if (player == this.owner) {
            player.attemptPurchase(this);
        } else {
            payRent(player);
        }
    }

    private void payRent(Player player) {
        int rent = getRent(player);
        player.reduceCash(rent);
        this.owner.addCash(rent);
    }

    abstract int getRent(Player player);

    public int getPrice() {
        return price;
    }

    public void setOwner(Player player) {
        this.owner = player;
    }
}
