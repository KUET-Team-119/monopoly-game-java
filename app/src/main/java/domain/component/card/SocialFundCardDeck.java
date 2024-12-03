package domain.component.card;

import java.util.Collections;
import java.util.LinkedList;

public class SocialFundCardDeck extends CardDeck {

    private static final SocialFundCardDeck instance = new SocialFundCardDeck();

    private SocialFundCardDeck() {
        buildDeck(SocialFundCardType.values());
        Collections.shuffle((LinkedList<Card>) cards);
    }

    public static SocialFundCardDeck getInstance() {
        return instance;
    }
}
