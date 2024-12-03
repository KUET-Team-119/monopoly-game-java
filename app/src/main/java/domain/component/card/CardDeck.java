package domain.component.card;

import java.util.Queue;

public abstract class CardDeck {

    protected Queue<Card> cards;

    protected void buildDeck(ChanceCardType[] values) {
        for (ChanceCardType type : values) {
            cards.add(ChanceCardFactory.createChanceCards(type));
        }
    }

    protected void buildDeck(SocialFundCardType[] values) {
        for (SocialFundCardType type : values) {
            cards.add(SocialFundCardFactory.createSocialFundCards(type));
        }
    }

    public Queue<Card> getCards() {
        return cards;
    }
}
