package domain.player.PlayerState;

import domain.MonopolyGame;
import domain.player.Player;

public class BankruptState implements PlayerState{
    private Player player;

    public BankruptState(Player player) {
        this.player = player;
    }
    
    @Override
    public void takeTurn() {
        MonopolyGame.handleBankruptPlayer(player);
    }
}
