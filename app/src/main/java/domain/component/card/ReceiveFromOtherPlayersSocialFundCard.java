package domain.component.card;

import domain.MonopolyGame;
import domain.player.Player;

public class ReceiveFromOtherPlayersSocialFundCard extends SocialFundCard {

    private int payment;

    public ReceiveFromOtherPlayersSocialFundCard(int index, String name, int payment) {
        this.index = index;
        this.name = name;
        this.payment = payment;
    }

    @Override
    public void takeEffect(Player player) {
        for (Player otherPlayer : MonopolyGame.getPlayers().values()) {
            if (player.equals(otherPlayer)) {
                continue;
            }
            int amount = otherPlayer.getCashManager().reduceCash(payment);
            player.getCashManager().addCash(amount);
        }
    }
}
