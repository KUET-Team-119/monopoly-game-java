package domain.component.card;

import domain.player.Player;

public abstract class Card {
    private Long id;
    private String name;

    abstract void takeEffect(Player player);
}
