package domain.component.card;

import domain.player.Player;

public abstract class Card {
    protected int id;
    protected String name;

    public abstract void takeEffect(Player player);
}
