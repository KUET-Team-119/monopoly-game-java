package domain.player.PlayerState;

import domain.player.Player;

public class NormalState implements PlayerState {
    private Player player;

    public NormalState(Player player) {
        this.player = player;
    }

    @Override
    public void takeTurn() {
        System.out.println("플레이어 " + player.getId() + "의 차례입니다.");

        int maxCountOfDouble = player.getDiceRollingManager().MAX_COUNT_OF_DOUBLE;
        int countOfDouble = 0;

        while (true) {
            int steps = player.getDiceRollingManager().rollDice();
            System.out.println("주사위 결과: " + steps);

            if (player.getDiceRollingManager().isDouble()) {
                countOfDouble++;
                if (countOfDouble == maxCountOfDouble) {
                    System.out.println("더블이 연속 " + maxCountOfDouble + "회 나왔습니다. 감옥으로 갑니다.");
                    player.setState(new PrisonState(player));
                    break;
                }
                System.out.println("더블입니다. 한 번 더 주사위를 굴릴 수 있습니다.");
            } else {
                // 더블이 아닌 경우 반복 종료
                player.getPieceMovingManager().moveForwardBySteps(steps);
                break;
            }

            player.getPieceMovingManager().moveForwardBySteps(steps);
        }
    }
}