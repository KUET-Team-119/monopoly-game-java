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
            prisonTerm--; // 수감 기간 감소
            System.out.println("남은 수감 기간: " + prisonTerm);

            if (prisonTerm == 0) {
                if (player.getCashManager().canPayBail(BAIL_AMOUNT)) {
                    payBailAndExit();
                } else {
                    System.out.println("보석금을 낼 수 없어 파산했습니다.");
                    // TODO: 파산 처리 로직 추가
                }
            } else {
                attemptPrisonEscape();
            }
        }
    }

    private void attemptPrisonEscape() {
        System.out.println("더블을 굴려 탈옥을 시도합니다.");
        int rollResult = player.getDiceRollingManager().rollDice();

        if (player.getDiceRollingManager().isDouble()) {
            System.out.println("더블이 나왔습니다. 감옥에서 나갑니다!");
            leaveJailAndMove(rollResult);
        } else {
            System.out.println("더블이 나오지 않았습니다.");
            System.out.println("다음 턴까지 감옥에 남습니다.");
        }
    }

    private void payBailAndExit() {
        player.getCashManager().reduceCash(BAIL_AMOUNT); // 보석금 차감
        leaveJail();
    }

    private void leaveJailAndMove(int rollResult) {
        leaveJail();
        player.getPieceMovingManager().moveForwardBySteps(rollResult);
    }

    private void leaveJail() {
        player.setState(new NormalState(player)); // 정상 상태로 복귀
        System.out.println("감옥에서 나옵니다.");
        player.takeTurn();
    }
}
