package domain.square;

import domain.component.card.Card;
import domain.component.card.SocialFundCardDeck;
import domain.player.Player;
import java.util.Queue;

public class SocialFundSquare extends Square {

    private Queue<Card> cards;

    public SocialFundSquare(int index, String name) {
        this.index = index;
        this.name = name;
        this.cards = SocialFundCardDeck.getInstance().getCards();
    }

    @Override
    public void landedOn(Player player) {
        System.out.println("사회기금 카드를 한 장 뽑습니다.");
        Card card = cards.poll();
        card.takeEffect(player);
        cards.add(card);
    }
}