package domain.component.card;

import domain.MonopolyGame;
import domain.player.Player;

public class ReceiveCashFromOtherPlayersCard extends SocialFundCard {

    private int amount;

    public ReceiveCashFromOtherPlayersCard(int index, String name, int amount) {
        this.index = index;
        this.name = name;
        this.amount = amount;
    }

    @Override
    public void takeEffect(Player player) {
        for (Player otherPlayer : MonopolyGame.players) {
            if (player.equals(otherPlayer)) {
                continue;
            }
            otherPlayer.reduceCash(amount);
            player.addCash(amount);
        }
    }
}
