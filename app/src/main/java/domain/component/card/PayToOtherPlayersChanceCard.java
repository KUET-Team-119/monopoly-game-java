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
            if (player.equals(otherPlayer) || otherPlayer.getStateManager().isBankruptState()) {
                continue;
            }
            int amount = player.getCashManager().reduceCash(payment);
            System.out.println(otherPlayer.getId() + "에게 돈을 " + amount + "만큼 줍니다.");
            otherPlayer.getCashManager().addCash(amount);
        }
    }
}
