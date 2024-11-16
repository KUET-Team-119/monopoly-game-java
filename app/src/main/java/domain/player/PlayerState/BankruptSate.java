package domain.player.PlayerState;

import domain.MonopolyGame;
import domain.player.Player;

public class BankruptSate implements PlayerState{
    private Player player;

    public BankruptSate(Player player) {
        this.player = player;
    }
    
    @Override
    public void takeTurn() {
        MonopolyGame.handleBankruptPlayer(player);
    }
}
