package domain.square;

import java.util.Queue;

import domain.MonopolyGame;
import domain.component.card.Card;
import domain.player.Player;

public class SocialFundSquare extends Square {

    public SocialFundSquare(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void landedOn(Player player) {
        System.out.println("사회기금 카드를 한 장 뽑습니다.");
        Queue<Card> socialFundCardDeck = MonopolyGame.socialFundCardDeck;
        player.drawCard(socialFundCardDeck);
    }
    
}
