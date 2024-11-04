package domain.player.PlayerManager;

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
            int payableAmout = cash;
            cash = Integer.MIN_VALUE;
            return payableAmout;
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