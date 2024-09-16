package domain;

public class RailroadSquare extends PropertySquare {

    private static final int RAILROADPRICE = 25;
    public RailroadSquare(String name, int index) {
        super(name, index);
    }

    @Override
    int getRent(Player player) {
        return player.getRailroadCount() * RAILROADPRICE;
    }
}
