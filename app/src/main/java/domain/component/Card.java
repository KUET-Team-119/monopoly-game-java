package domain.component;

public abstract class Card {
    private Long id;
    private String name;

    abstract void takeEffect();
}
