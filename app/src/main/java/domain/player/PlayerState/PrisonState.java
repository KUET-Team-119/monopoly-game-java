package domain.player.PlayerState;

import domain.player.Player;

public class PrisonState implements PlayerState {
    public static final int BAIL_AMOUNT = 50; // 보석금
    public static final int INITIAL_PRISON_TERM = 3; // 초기 수감 기간
    
    private Player player;
    private int prisonTerm;

    public PrisonState(Player player) {
        this.player = player;
        this.prisonTerm = INITIAL_PRISON_TERM;
    }

    @Override
    public void takeTurn() {
        if (prisonTerm > 0) {
            prisonTerm--;
            System.out.println("남은 수감 기간: " + prisonTerm);

            if (prisonTerm == 0) {
                player.getCashManager().reduceCash(BAIL_AMOUNT);
                payBailAndExit();
            } else {
                attemptPrisonEscape();
            }
        }
    }

    private void attemptPrisonEscape() {
        System.out.println("더블을 굴려 탈옥을 시도합니다.");
        int rollResult = player.getDiceRollingManager().rollDice();

        if (player.getDiceRollingManager().isDouble()) {
            System.out.println("더블이 나왔습니다. 탈옥에 성공했습니다!");
            leaveJailAndMove(rollResult);
        } else {
            System.out.println("더블이 나오지 않았습니다.");
            System.out.println("다음 턴까지 감옥에 남습니다.");
        }
    }

    private void payBailAndExit() {
        int paidCash = player.getCashManager().reduceCash(BAIL_AMOUNT);
        if (paidCash == BAIL_AMOUNT) {
            leaveJail();
            player.takeTurn(); // 정상 상태에서 턴 실행
        }
    }

    private void leaveJailAndMove(int steps) {
        leaveJail();
        player.getPieceMovingManager().moveForwardBySteps(steps);
    }

    private void leaveJail() {
        player.getStateManager().becomeNormalState(); // 정상 상태로 복귀
        System.out.println("감옥에서 나옵니다.");
    }
}
