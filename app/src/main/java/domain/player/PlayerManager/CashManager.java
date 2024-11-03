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

    public void reduceCash(int amount) {
        cash -= amount;
    }

    public boolean canPayBail(int bailAmount) {
        return cash >= bailAmount;
    }

    public boolean canPurchaseProperty(int price) {
        return cash >= price;
    }

    public int getCash() {
        return cash;
    }
}