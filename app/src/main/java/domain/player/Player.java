package domain.player;

import domain.component.card.Card;
import domain.player.PlayerManager.CashManager;
import domain.player.PlayerManager.DiceRollingManager;
import domain.player.PlayerManager.PieceMovingManager;
import domain.player.PlayerManager.SquareManager;
import domain.player.PlayerState.NormalState;
import domain.player.PlayerState.PlayerState;
import java.util.Queue;

public class Player {
    private final String id;
    private PlayerState state;
    private final CashManager cashManager;
    private final SquareManager squareManager;
    private final DiceRollingManager diceRollingManager;
    private final PieceMovingManager pieceMovingManager;

    public Player(final String id) {
        this.id = id;
        this.state = new NormalState(this);
        this.cashManager = new CashManager(this);
        this.squareManager = new SquareManager();
        this.diceRollingManager = new DiceRollingManager();
        this.pieceMovingManager = new PieceMovingManager(id, this);
    }

    public void takeTurn() {
        state.takeTurn();
    }

    public void setState(PlayerState state) {
        this.state = state;
    }

    public void drawCard(Queue<Card> deck) {
        Card card = deck.remove();
        card.takeEffect(this);
        deck.add(card);
    }

    public boolean isNormalState() {
        return this.state instanceof NormalState;
    }

    public String getId() {
        return id;
    }

    public PlayerState getState() {
        return state;
    }

    public CashManager getCashManager() {
        return cashManager;
    }

    public SquareManager getSquareManager() {
        return squareManager;
    }

    public DiceRollingManager getDiceRollingManager() {
        return diceRollingManager;
    }

    public PieceMovingManager getPieceMovingManager() {
        return pieceMovingManager;
    }
}