package domain.player;

import domain.component.Cup;

public class PrisonManager {
    public static final int BAIL_AMOUNT = 50;
    private Player player;

    public PrisonManager(Player player) {
        this.player = player;
    }

    public void handlePrisonTurn() {
        if (player.getPrisonTerm() > 0) {
            player.reducePrisonTerm();
            System.out.println("남은 수감 기간: " + player.getPrisonTerm());

            // 플레이어의 수감 기간이 남아 있는 경우
            System.out.println("탈출을 시도하거나 보석금을 낼 수 있습니다.");
            // TODO 보석금을 낼 수 있으면 보석금 지불, 이후 확률적으로 선택되도록 변경
            if (player.canPayBail()) {
                player.payBailAndLeavePrison(BAIL_AMOUNT);
                player.playNormalTurn();
                // 또는
                // attemptPrisonEscape();
            } else {
                attemptPrisonEscape();
            }
        }
    }

    private void attemptPrisonEscape() {
        System.out.println("더블을 굴려 탈옥을 시도합니다.");
        int rollResult = player.rollDice();
        if (Cup.getInstance().isDouble()) {
            System.out.println("더블이 나왔습니다. 감옥에서 나갑니다!");
            player.resetPrisonTerm();
            player.getPiece().goForward(rollResult);
        } else {
            System.out.println("더블이 나오지 않았습니다.");
            if (player.getPrisonTerm() == 0) {
                System.out.println("수감 기간이 끝났습니다. 보석금을 내고 감옥에서 나가야 합니다.");
                if (player.canPayBail()) {
                    player.payBailAndLeavePrison(BAIL_AMOUNT);
                    player.resetPrisonTerm();
                    player.getPiece().goForward(rollResult);
                } else {
                    // TODO 파산이 맞는지 확인 필요
                    System.out.println("보석금을 낼 수 없습니다. 파산했습니다.");
                }
            } else {
                System.out.println("다음 턴까지 감옥에 남습니다.");
            }
        }
    }
}