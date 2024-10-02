package domain.square;

import domain.player.Player;

public abstract class Square {

    protected int id;
    protected String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    abstract public void landedOn(Player player);
}