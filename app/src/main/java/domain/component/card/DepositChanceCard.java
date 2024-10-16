package domain.component.card;

import domain.player.Player;

public class DepositChanceCard extends ChanceCard {

    private int amount;

    public DepositChanceCard(int id, String name, int amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    @Override
    public void takeEffect(Player player) {
        player.addCash(amount);
    }
}
