package domain.player.PlayerManager;

import domain.MonopolyGame;
import domain.player.Player;
import domain.player.PlayerState.BankruptState;
import domain.player.PlayerState.NormalState;
import domain.player.PlayerState.PlayerState;
import domain.player.PlayerState.PrisonState;

public class StateManager {

    private Player player;
    private PlayerState state;

    public StateManager(Player player) {
        this.player = player;
        this.state = new NormalState(player);
    }

    public void becomeNormalState() {
        this.state = new NormalState(player);
    }

    public void becomePrisonState() {
        this.state = new PrisonState(player);
    }

    public void becomeBankruptState() {
        this.state = new BankruptState();
        MonopolyGame.handleBankruptPlayer(player);
    }

    public boolean isNormalState() {
        return this.state instanceof NormalState;
    }

    public boolean isBankruptState() {
        return this.state instanceof BankruptState;
    }

    public PlayerState getState() {
        return this.state;
    }
}
