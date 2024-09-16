package domain;

public class GoToJailSquare extends Square {
    private Square jail;

    public GoToJailSquare(String name, int index) {
        super(name, index);
    }

    @Override
    void landedOn(Player player) {
        player.setLocation(jail);
    }
}
