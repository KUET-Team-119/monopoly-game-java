package domain.square;

import java.util.List;
import java.util.Objects;

public class Player {
    private static final int MAX_COUNT_OF_DOUBLE = 3;

    private String id;
    private Piece piece;
    private int cash;
    boolean chanceToRoll;
    int countOfDouble;

    public Player(String id) {
        this.id = id;
        this.piece = new Piece(id);
        this.cash = 1_500_000;
        this.chanceToRoll = false;
        this.countOfDouble = 0;
    }

    public void takeTurn(List<Die> dice) {
        retrieveChanceToRoll();
        while (chanceToRoll) {
            System.out.println("플레이어 " + id + "의 차례입니다.");
            int numOfMove = rollDice(dice);

            if (isThirdDouble()) {
                System.out.println("더블이 연속 3회 나왔습니다. 감옥으로 가세요.");
                yieldChanceToRoll();
                
                // TODO 감옥으로 가는 로직
                break;
            }

            piece.move(numOfMove);

            // TODO 이동 후 액션에 관한 로직
        }
    }

    private int rollDice(List<Die> dice) {
        Die firstDie = dice.get(0);
        Die secondDie = dice.get(1);

        System.out.println("주사위를 굴립니다.");
        int faceValueOfFirstDie = firstDie.roll();
        int faceValueOfSecondDie = secondDie.roll();

        System.out.println("첫 번째 주사위의 눈: " + faceValueOfFirstDie);
        System.out.println("두 번째 주사위의 눈: " + faceValueOfSecondDie);

        if (isDouble(faceValueOfFirstDie, faceValueOfSecondDie)) {
            System.out.println("더블입니다.");
            countOfDouble++;
        } else{
            yieldChanceToRoll();
        }

        return faceValueOfFirstDie + faceValueOfSecondDie;
    }

    private void retrieveChanceToRoll() {
        chanceToRoll = true;
    }

    private void yieldChanceToRoll() {
        chanceToRoll = false;
        resetDoubleCount();
    }

    private boolean isDouble(int faceValueOfFirstDie, int faceValueOfSecondDie) {
        if (faceValueOfFirstDie == faceValueOfSecondDie) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isThirdDouble() {
        if (countOfDouble == MAX_COUNT_OF_DOUBLE) {
            return true;
        } else {
            return false;
        }
    }

    private void resetDoubleCount() {
        countOfDouble = 0;
    }

    public void attemptPurchase(RegularSquare square) {
        int price = square.findPrice();
        if (cash >= price && !square.isSelled) {
            purchaseSquare(square, price);
            return;
        }
        payRent(square);
    }

    private void purchaseSquare(RegularSquare square, int price) {
        square.setOwner(this);
        reduceCash(price);
    }

    private void payRent(RegularSquare square) {
        int rent = square.findRent();
        square.findOwner().addCash(rent);
        reduceCash(rent);
    }

    public void addCash(int price) {
        this.cash += price;
    }

    public void reduceCash(int price) {
        this.cash -= price;
    }

    public int getCash() {
        return cash;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Player player))
            return false;
        return Objects.equals(id, player.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}