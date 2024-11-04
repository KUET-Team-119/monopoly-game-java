package domain.player.PlayerManager;

import domain.component.Cup;

public class DiceRollingManager {
    public final int MAX_COUNT_OF_DOUBLE = 3;

    private Cup cup;

    public DiceRollingManager() {
        this.cup = Cup.getInstance();
    }

    public int rollDice() {
        System.out.println("주사위를 굴립니다.");
        return cup.roll();
    }

    public boolean isDouble() {
        return cup.isDouble();
    }
}
