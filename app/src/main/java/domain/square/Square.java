package domain.square;

import domain.player.Player;

public abstract class Square {

    protected int index;
    protected String name;

    public int getId() {
        return index;
    }

    public String getName() {
        return name;
    }

    public abstract void landedOn(Player player);
}