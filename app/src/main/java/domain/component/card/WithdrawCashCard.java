package domain.component.card;

import domain.player.Player;

public class WithdrawCashCard extends SocialFundCard{

    private int amount;

    public WithdrawCashCard(int index, String name, int amount) {
        this.index = index;
        this.name = name;
        this.amount = amount;
    }

    @Override
    public void takeEffect(Player player) {
        player.reduceCash(amount);
    }
}
