package domain.component.card;

import domain.MonopolyGame;
import domain.player.Player;

public class ReceiveFromOtherPlayersSocialFundCard extends SocialFundCard {

    private int amount;

    public ReceiveFromOtherPlayersSocialFundCard(int id, String name, int amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    @Override
    public void takeEffect(Player player) {
        for (Player otherPlayer : MonopolyGame.getPlayers()) {
            if (player.equals(otherPlayer)) {
                continue;
            }
            otherPlayer.reduceCash(amount);
            player.addCash(amount);
        }
    }
}
