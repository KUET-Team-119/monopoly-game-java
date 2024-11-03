package domain.player.PlayerManager;

import domain.component.Cup;

public class DiceRollingManager {
    private Cup cup;

    public DiceRollingManager(Cup cup) {
        this.cup = cup;
    }

    public int rollDice() {
        System.out.println("주사위를 굴립니다.");
        return cup.roll();
    }

    public boolean isDouble() {
        return cup.isDouble();
    }

    public boolean isThirdDouble() {
        return cup.isThirdDouble();
    }
}
