package domain.component.card;

import domain.player.Player;

public class DepositChanceCard extends ChanceCard {

    private int deposit;

    public DepositChanceCard(int deposit) {
        super();
        this.deposit = deposit;
    }

    @Override
    void takeEffect(Player player) {
        player.addCash(deposit);
    }
}
