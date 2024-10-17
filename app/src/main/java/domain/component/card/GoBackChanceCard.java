package domain.component.card;

import domain.component.Board;
import domain.component.Piece;
import domain.player.Player;

public class GoBackChanceCard extends ChanceCard {

    private final int BACK = 3;

    public GoBackChanceCard(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void takeEffect(Player player) {
        player.askForGoBack(BACK);
    }
}
