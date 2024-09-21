package domain.square;

import java.util.List;
import java.util.Objects;

public class Player {
    private static final int MAX_COUNT_OF_DOUBLE = 3;

    private String name;
    private Piece piece;
    private int cash;
    boolean chanceToRoll;
    int countOfDouble;

    public Player(String name) {
        this.name = name;
        this.piece = new Piece(name);
        this.cash = 1_500_000;
        this.chanceToRoll = false;
        this.countOfDouble = 0;
    }

    // TODO 로직이 마음에 들지 않음🥺
    public void takeTurn(List<Die> dice) {
        chanceToRoll = true;
        while (chanceToRoll) {
            System.out.println("플레이어 " + name + "의 차례입니다.");
            int numOfMovement = rollDice(dice);

            if (countOfDouble == MAX_COUNT_OF_DOUBLE) {
                System.out.println("더블이 연속 3회 나왔습니다. 감옥으로 가세요.");
                chanceToRoll = false;
                
                // 감옥으로 가는 로직
                break;
            }

            piece.move(numOfMovement);

            // TODO 이동 후 액션에 관한 로직
        }
        resetDoubleCount();
    }

    // TODO 로직이 마음에 들지 않음🥺
    private int rollDice(List<Die> dice) {
        Die firstDie = dice.get(0);
        Die secondDie = dice.get(1);

        System.out.println("주사위를 굴립니다.");
        int faceValueOfFirstDie = firstDie.roll();
        int faceValueOfSecondDie = secondDie.roll();

        System.out.println("첫 번째 주사위 눈: " + faceValueOfFirstDie);
        System.out.println("두 번째 주사위 눈: " + faceValueOfSecondDie);

        if (faceValueOfFirstDie == faceValueOfSecondDie) {
            System.out.println("더블입니다.");
            countOfDouble++;
        } else{
            chanceToRoll = false;
        }

        return faceValueOfFirstDie + faceValueOfSecondDie;
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

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Player player))
            return false;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}