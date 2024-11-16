package domain.component.card;

import domain.MonopolyGame;
import domain.player.Player;

public class PayToOtherPlayersChanceCard extends ChanceCard {

    private int payment;

    public PayToOtherPlayersChanceCard(int index, String name, int payment) {
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
            int amount = player.getCashManager().reduceCash(payment);
            otherPlayer.getCashManager().addCash(amount);
        }
    }
}
