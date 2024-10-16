package domain.component.card;

import domain.MonopolyGame;
import domain.player.Player;

import java.util.List;

public class PayToOtherPlayersChanceCard extends ChanceCard {

    private int payment;

    public PayToOtherPlayersChanceCard(int payment) {
        super();
        this.payment = payment;
    }

    @Override
    public void takeEffect(Player player) {
        List<Player> players = MonopolyGame.getPlayers();
        players.remove(player);

        for (Player otherPlayer : players) {
            player.reduceCash(payment);
            otherPlayer.addCash(payment);
        }
    }
}
