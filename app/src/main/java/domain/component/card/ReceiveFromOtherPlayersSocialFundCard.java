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
            if (player.equals(otherPlayer) || otherPlayer.getStateManager().isBankruptState()) {
                continue;
            }
            int amount = otherPlayer.getCashManager().reduceCash(payment);
            System.out.println(otherPlayer.getId() + "에게 돈을 " + amount + "만큼 받습니다.");
            player.getCashManager().addCash(amount);
        }
    }
}
