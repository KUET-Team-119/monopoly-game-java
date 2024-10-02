package domain.player;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

import domain.component.Piece;
import domain.component.property.Property;
import domain.component.property.RailRoadProperty;
import domain.component.property.UtilityProperty;
import domain.component.Board;
import domain.component.Cup;
import domain.square.PropertySquare;
import domain.square.SquareType;

public class Player {
    private static final int MAX_COUNT_OF_DOUBLE = 3;

    private String id;
    private Piece piece;
    private int cash;
    private int chanceToRoll;
    private int countOfDouble;
    private List<Property> properties;
    private int prisonTerm;

    public Player(String id) {
        this.id = id;
        this.piece = new Piece(id);
        this.cash = 1_500_000;
        this.chanceToRoll = 0;
        this.countOfDouble = 0;
        this.properties = new ArrayList<Property>();
        this.prisonTerm = 0;
    }

    public void takeTurn() {
        addChanceToRoll();
        while (chanceToRoll > 0) {
            System.out.println("플레이어 " + id + "의 차례입니다.");
            int numOfMove = rollDice();

            if (handleDouble()) {
                break; // 세 번째 더블일 경우 턴 종료
            } else {
                piece.goForward(numOfMove);
            }

            chanceToRoll--; // 기회 감소
        }
        // TODO 이동 후 액션에 관한 로직
    }

    public int rollDice() {
        Cup cup = Cup.getInstance();
        System.out.println("주사위를 굴립니다.");
        cup.roll();
        return cup.getTotal();
    }

    private boolean handleDouble() {
        if (isDouble()) {
            countOfDouble++;
            if (isThirdDouble()) {
                System.out.println("더블이 연속 3회 나왔습니다. 감옥으로 갑니다.");
                sendToJail();
                resetCountOfDouble();
                return true; // 턴 종료
            } else {
                System.out.println("더블이 나왔습니다. 한 번 더 주사위를 굴립니다.");
                addChanceToRoll();
            }
        } else {
            resetCountOfDouble();
        }
        return false;
    }

    private void sendToJail() {
        piece.setLocation(Board.squares.get(SquareType.JAIL.getIndex()));
    }

    private void addChanceToRoll() {
        chanceToRoll++;
    }

    private boolean isDouble() {
        return Cup.getInstance().isDouble();
    }

    private boolean isThirdDouble() {
        return countOfDouble == MAX_COUNT_OF_DOUBLE;
    }

    private void resetCountOfDouble() {
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

    public Piece getPiece() {
        return piece;
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

    public void setPrisonTerm(int prisonTerm) {
        this.prisonTerm = prisonTerm;
    }
}