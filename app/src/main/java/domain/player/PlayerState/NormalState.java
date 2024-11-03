package domain.player.PlayerState;

import domain.player.Player;

public class NormalState implements PlayerState {
    private boolean chanceToRoll;
    private Player player;

    public NormalState(Player player) {
        this.player = player;
    }

    @Override
    public void takeTurn() {
        retrieveChanceToRoll();
        while (hasChanceToRoll()) {
            System.out.println("플레이어 " + player.getId() + "의 차례입니다.");
            int steps = player.getDiceRollingManager().rollDice();

            if (player.getDiceRollingManager().isDouble()) {
                if (player.getDiceRollingManager().isThirdDouble()) {
                    System.out.println("더블이 연속 3회 나왔습니다. 감옥으로 갑니다.");
                    releaseChanceToRoll();
                    player.setState(new PrisonState(player));
                    return;
                }
                player.getPieceMovingManager().moveForward(steps);
            } else {
                releaseChanceToRoll();
                player.getPieceMovingManager().moveForward(steps);
            }
        }
    }

    private void retrieveChanceToRoll() {
        chanceToRoll = true;
    }

    private void releaseChanceToRoll() {
        chanceToRoll = false;
    }

    private boolean hasChanceToRoll() {
        return chanceToRoll;
    }
}
