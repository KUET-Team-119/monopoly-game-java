package domain.component.card;

import java.util.Collections;
import java.util.LinkedList;

public class ChanceCardDeck extends CardDeck {

    private static final ChanceCardDeck instance = new ChanceCardDeck();

    private ChanceCardDeck() {
        buildDeck(ChanceCardType.values());
        Collections.shuffle((LinkedList<Card>) cards);
    }

    public static ChanceCardDeck getInstance() {
        return instance;
    }   
}