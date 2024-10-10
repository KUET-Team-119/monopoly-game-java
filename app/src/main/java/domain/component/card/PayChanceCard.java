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
        players.remove(player);

        for (Player otherPlayer : players) {
            player.reduceCash(payment);
            otherPlayer.addCash(payment);
        }
    }
}
