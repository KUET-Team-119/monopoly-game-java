package domain.square;

import java.util.Queue;

import domain.component.card.Card;
import domain.component.card.ChanceCardDeck;
import domain.player.Player;

public class ChanceSquare extends Square {

    private Queue<Card> cards;

    public ChanceSquare(int index, String name) {
        this.index = index;
        this.name = name;
        this.cards = ChanceCardDeck.getInstance().getCards();
    }

    @Override
    public void landedOn(Player player) {
        System.out.println("찬스 카드를 한 장 뽑습니다.");
        Card card = cards.poll();
        card.takeEffect(player);
        cards.add(card);
    }
    
}
