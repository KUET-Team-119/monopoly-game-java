package domain.component.card;

import domain.player.Player;

public class GoBackChanceCard extends ChanceCard {

    private final int BACK = 3;

    public GoBackChanceCard(int index, String name) {
        this.index = index;
        this.name = name;
    }

    @Override
    public void takeEffect(Player player) {
        player.askForGoBack(BACK);
    }
}
