package domain.component.card;

import domain.player.Player;

public class WithdrawChanceCard extends ChanceCard {

    private int amount;

    public WithdrawChanceCard(int index, String name, int amount) {
        this.index = index;
        this.name = name;
        this.amount = amount;
    }

    @Override
    public void takeEffect(Player player) {
        player.reduceCash(amount);
    }
}
