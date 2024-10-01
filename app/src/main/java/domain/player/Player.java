package domain.player;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

import domain.component.Die;
import domain.component.Piece;
import domain.component.property.Property;
import domain.component.property.RailRoadProperty;
import domain.component.property.UtilityProperty;
import domain.square.PropertySquare;

public class Player {
    private static final int MAX_COUNT_OF_DOUBLE = 3;

    private String id;
    private Piece piece;
    private int cash;
    private boolean chanceToRoll;
    private int countOfDouble;
    private List<Property> properties;

    public Player(String id) {
        this.id = id;
        this.piece = new Piece(id);
        this.cash = 1_500_000;
        this.chanceToRoll = false;
        this.countOfDouble = 0; // TODO 주사위 책임으로(?)
        this.properties = new ArrayList<Property>();
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

    // TODO 주사위 책임으로(?)
    private boolean isDouble(int faceValueOfFirstDie, int faceValueOfSecondDie) {
        if (faceValueOfFirstDie == faceValueOfSecondDie) {
            return true;
        } else {
            return false;
        }
    }

    // TODO 주사위 책임으로(?)
    private boolean isThirdDouble() {
        if (countOfDouble == MAX_COUNT_OF_DOUBLE) {
            return true;
        } else {
            return false;
        }
    }

    // TODO 주사위 책임으로(?)
    private void resetDoubleCount() {
        countOfDouble = 0;
    }

    public void attemptPurchase(PropertySquare square, int price) {
        if (cash >= price) {
            square.setOwner(this);
            reduceCash(price);
        }
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

    public void gainProperty(Property property) {
        properties.add(property);
    }

    public int countRailRoadProperty() {
        int count = 0;
        for (Property property : properties) {
            if (property instanceof RailRoadProperty) {
                count++;
            }
        }
        return count;
    }

    public int countUtilityProperty() {
        int count = 0;
        for (Property property : properties) {
            if (property instanceof UtilityProperty) {
                count++;
            }
        }
        return count;
    }

    public int rollDiceForUtilityRent() {
        return new Die("1").roll() + new Die("2").roll();
    }
}