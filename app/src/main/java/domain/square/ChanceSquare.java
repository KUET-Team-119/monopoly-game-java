package domain.square;

import domain.MonopolyGame;
import domain.component.card.Card;
import domain.player.Player;
import java.util.Queue;

public class ChanceSquare extends Square {

    public ChanceSquare(int index, String name) {
        this.index = index;
        this.name = name;
    }

    @Override
    public void landedOn(Player player) {
        System.out.println("찬스 카드를 한 장 뽑습니다.");
        Queue<Card> chanceCardDeck = MonopolyGame.chanceCardDeck;
        drawCard(player, chanceCardDeck);
    }

    private void drawCard(Player player, Queue<Card> chanceCardDeck) {
        Card chanceCard = chanceCardDeck.poll();
        chanceCard.takeEffect(player);
        chanceCardDeck.offer(chanceCard);
    }

}
