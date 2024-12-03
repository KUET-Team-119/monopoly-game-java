package domain.square;

import domain.MonopolyGame;
import domain.component.card.Card;
import domain.player.Player;
import java.util.Queue;

public class SocialFundSquare extends Square {

    public SocialFundSquare(int index, String name) {
        this.index = index;
        this.name = name;
    }

    @Override
    public void landedOn(Player player) {
        System.out.println("사회기금 카드를 한 장 뽑습니다.");
        Queue<Card> socialFundCardDeck = MonopolyGame.socialFundCardDeck;
        drawCard(player, socialFundCardDeck);
    }

    private void drawCard(Player player, Queue<Card> socialFundCardDeck) {
        Card socialFundCard = socialFundCardDeck.poll();
        socialFundCard.takeEffect(player);
        socialFundCardDeck.offer(socialFundCard);
    }

}
