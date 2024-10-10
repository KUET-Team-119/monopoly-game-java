package domain.component.card;

import domain.MonopolyGame;
import domain.player.Player;
import monopolygame.App;

import java.util.List;

public class PayChanceCard extends ChanceCard {

    private int payment;

    public PayChanceCard(int payment) {
        super();
        this.payment = payment;
    }

    @Override
    void takeEffect(Player player) {
        List<Player> players = MonopolyGame.getPlayers();

        for (Player otherPlayer : players) {
            if (otherPlayer == player) {
                continue;
            }
            player.reduceCash(payment);
            otherPlayer.addCash(payment);
        }
    }
}
