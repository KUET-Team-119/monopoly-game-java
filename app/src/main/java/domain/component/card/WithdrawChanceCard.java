package domain.component.card;

import domain.player.Player;

public class WithdrawChanceCard extends ChanceCard {

    private int withdraw;

    public WithdrawChanceCard(int withdraw) {
        super();
        this.withdraw = withdraw;
    }

    @Override
    void takeEffect(Player player) {
        player.reduceCash(withdraw);
    }
}
