package domain.component.card;

import domain.player.Player;

public class DepositSocialFundCard extends SocialFundCard {

    private int amount;

    public DepositSocialFundCard(int id, String name, int amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    @Override
    public void takeEffect(Player player) {
        player.addCash(amount);
    }
}
