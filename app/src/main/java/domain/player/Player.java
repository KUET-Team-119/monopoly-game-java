package domain.player;

import java.util.Queue;
import domain.component.card.Card;
import domain.player.PlayerManager.CashManager;
import domain.player.PlayerManager.DiceRollingManager;
import domain.player.PlayerManager.PieceMovingManager;
import domain.player.PlayerManager.SqaureManager;
import domain.player.PlayerState.NormalState;
import domain.player.PlayerState.PlayerState;

public class Player {
    private String id;
    private PlayerState state;
    private CashManager cashManager;
    private SqaureManager squareManager;
    private DiceRollingManager diceRollingManager;
    private PieceMovingManager pieceMovingManager;

    public Player(String id) {
        this.id = id;
        this.state = new NormalState(this);
        this.cashManager = new CashManager(this);
        this.squareManager = new SqaureManager();
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

    public String getId() {
        return id;
    }

    public PlayerState getState() {
        return state;
    }

    public CashManager getCashManager() {
        return cashManager;
    }

    public SqaureManager getSquareManager() {
        return squareManager;
    }

    public DiceRollingManager getDiceRollingManager() {
        return diceRollingManager;
    }

    public PieceMovingManager getPieceMovingManager() {
        return pieceMovingManager;
    }
}