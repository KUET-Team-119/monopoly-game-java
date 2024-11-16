package domain.player.PlayerState;

import domain.player.Player;

public class NormalState implements PlayerState {
    private final Player player;

    public NormalState(final Player player) {
        this.player = player;
    }

    @Override
    public void takeTurn() {
        System.out.println("플레이어 " + player.getId() + "의 차례입니다.");

        int countOfDouble = 0;

        while (player.isNormalState()) {
            int steps = player.getDiceRollingManager().rollDice();
            System.out.println("주사위 결과: " + steps);

            if (player.getDiceRollingManager().isDouble()) {
                if (++countOfDouble == player.getDiceRollingManager().MAX_COUNT_OF_DOUBLE) {
                    sendToPrison();
                    break;
                }
                movePlayer(steps);
            } else {
                // 더블이 아닌 경우 반복 종료
                movePlayer(steps);
                break;
            }
        }
    }

    private void sendToPrison() {
        System.out.println("더블이 연속 " + player.getDiceRollingManager().MAX_COUNT_OF_DOUBLE + "회 나왔습니다. 감옥으로 갑니다.");
        player.setState(new PrisonState(player));
    }

    private void movePlayer(int steps) {
        player.getPieceMovingManager().moveForwardBySteps(steps);
    }
}