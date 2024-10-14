package domain.component.card;

import domain.MonopolyGame;
import domain.player.Player;
import monopolygame.App;

import java.util.List;
import java.util.stream.Collectors;

public class PayChanceCard extends ChanceCard {

    private int payment;

    public PayChanceCard(int payment) {
        super();
        this.payment = payment;
    }

    @Override
    void takeEffect(Player player) {
        List<Player> otherPlayers = MonopolyGame.getPlayers().stream()
                                                        .filter(p -> p != player)
                                                        .toList();

        for (Player other : otherPlayers) {
            player.reduceCash(payment);
            other.addCash(payment);
        }
    }
}
