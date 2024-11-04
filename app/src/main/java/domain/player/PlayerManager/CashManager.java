package domain.player.PlayerManager;

// import domain.player.BankruptcyException;

public class CashManager {

    private final int INITIAL_CASH = 1_500;

    private int cash;

    public CashManager() {
        this.cash = INITIAL_CASH;
    }

    public void addCash(int amount) {
        cash += amount;
    }

    public int reduceCash(int amount) {
        if (hasEnoughCash(amount)) {
            cash -= amount;
            return amount;
        } else {
            // TODO 예외 발생 시 파산한 플레이어에게 한 푼도 못 받는 문제 발생
            int payableAmount = cash;
            cash = Integer.MIN_VALUE;
            // throw new BankruptcyException();
            return payableAmount;
        }
    }

    public boolean canPayBail(int bailAmount) {
        return cash >= bailAmount;
    }

    public boolean hasEnoughCash(int amount) {
        return cash >= amount;
    }

    public int getCash() {
        return cash;
    }
}