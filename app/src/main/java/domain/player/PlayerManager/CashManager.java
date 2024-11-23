package domain.player.PlayerManager;

import java.util.List;

import domain.player.Player;
import domain.square.LotSquare;
import domain.square.PropertySquare;

public class CashManager {

    private static final int INITIAL_CASH = 1_500;

    private Player player;
    private int cash;

    public CashManager(Player player) {
        this.player = player;
        this.cash = INITIAL_CASH;
    }

    public void addCash(int amount) {
        System.out.println(amount + "원을 받습니다.");
        cash += amount;
    }

    public int reduceCash(int amount) {
        System.out.println("가진 돈은 " + cash + "원입니다.");
        if (hasEnoughCash(amount)) {
            return reduceAvailableCash(amount);
        }
        return handleInsufficientCash(amount);
    }

    private int reduceAvailableCash(int amount) {
        cash -= amount;
        return amount;
    }

    private int handleInsufficientCash(int amount) {
        coverCash(amount);

        if (hasEnoughCash(amount)) {
            return reduceAvailableCash(amount);
        }
        return handleBankruptcy();
    }

    private int handleBankruptcy() {
        System.out.println("플레이어 " + player.getId() + "이/가 파산했습니다.");
        player.getStateManager().becomeBankruptState();
        int payableAmount = cash;
        cash = 0;
        return payableAmount;
    }
    
    private void coverCash(int amount) {
        List<PropertySquare> sortedPropertySquares = player.getSquareManager().getSortedPropertySquare();
        int totalCash = cash;
    
        // 정렬된 부지들을 순차적으로 처리
        for (PropertySquare propertySquare : sortedPropertySquares) {
            int value = (propertySquare instanceof LotSquare) ? propertySquare.getRent() : propertySquare.getPrice();
            totalCash += value;
            player.getSquareManager().removePropertySquare(propertySquare.getIndex());
    
            // 현금이 목표 금액 이상이 되면 판매 중지
            if (totalCash >= amount) {
                cash = totalCash - amount;  // 초과한 금액은 플레이어의 현금으로 남김
                return;
            }
        }
    
        // 모든 부지를 팔고도 부족하다면, 남은 현금 설정
        cash = totalCash;
    }

    public boolean hasEnoughCash(int amount) {
        return cash >= amount;
    }

    public int calculateTotalAssets() {
        coverCash(Integer.MAX_VALUE);
        return getCash();
    }
    
    public int getCash() {
        return cash;
    }
}