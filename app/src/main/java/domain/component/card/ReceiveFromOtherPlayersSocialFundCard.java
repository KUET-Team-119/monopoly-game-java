package domain.component.card;

import domain.MonopolyGame;
import domain.player.Player;

public class ReceiveFromOtherPlayersSocialFundCard extends SocialFundCard {

    private int amount;

    public ReceiveFromOtherPlayersSocialFundCard(int index, String name, int amount) {
        this.index = index;
        this.name = name;
        this.amount = amount;
    }

    @Override
    public void takeEffect(Player player) {
        for (Player otherPlayer : MonopolyGame.getPlayers()) {
            if (player.equals(otherPlayer)) {
                continue;
            }
            otherPlayer.getCashManager().reduceCash(amount);
            player.getCashManager().addCash(amount);
        }
    }
}
