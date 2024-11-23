package domain.player;

import domain.component.card.Card;
import domain.player.PlayerManager.CashManager;
import domain.player.PlayerManager.DiceRollingManager;
import domain.player.PlayerManager.PieceMovingManager;
import domain.player.PlayerManager.SquareManager;
import domain.player.PlayerManager.StateManager;
import java.util.Queue;

public class Player {
    private final String id;
    private final StateManager stateManager;
    private final CashManager cashManager;
    private final SquareManager squareManager;
    private final DiceRollingManager diceRollingManager;
    private final PieceMovingManager pieceMovingManager;

    public Player(final String id) {
        this.id = id;
        this.stateManager = new StateManager(this);
        this.cashManager = new CashManager(this);
        this.squareManager = new SquareManager();
        this.diceRollingManager = new DiceRollingManager();
        this.pieceMovingManager = new PieceMovingManager(id, this);
    }

    public void takeTurn() {
        stateManager.getState().takeTurn();
    }

    public void drawCard(Queue<Card> deck) {
        Card card = deck.remove();
        card.takeEffect(this);
        deck.add(card);
    }

    public String getId() {
        return id;
    }

    public StateManager getStateManager() {
        return stateManager;
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