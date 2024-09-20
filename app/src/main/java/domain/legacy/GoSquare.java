package domain.legacy;

public class GoSquare extends Square {
    private static final int GO = 200;
    public GoSquare(String name, int index) {
        super(name, index);
    }

    @Override
    void landedOn(Player player) {
        player.addCash(GO);
    }

}
