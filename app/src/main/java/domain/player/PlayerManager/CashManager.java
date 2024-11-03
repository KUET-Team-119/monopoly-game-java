package domain.player.PlayerManager;

import domain.square.PropertySquare;

public class CashManager {
    private int cash;

    public CashManager(int initialCash) {
        this.cash = initialCash;
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

    public void attemptPurchase(PropertySquare square, int price) {
        if (cash >= price) {
            
            reduceCash(price);
        }
    }

    public int getCash() {
        return cash;
    }
}