package domain.player;

import domain.square.Square;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

import domain.component.Piece;
import domain.component.card.Card;
import domain.component.property.Property;
import domain.component.property.RailRoadProperty;
import domain.component.property.UtilityProperty;
import domain.component.Board;
import domain.component.Cup;
import domain.square.PropertySquare;
import domain.square.SquareType;

public class Player {
    private final int MAX_COUNT_OF_DOUBLE = 3;

    private String id;
    private Piece piece;
    private int cash;
    private int chanceToRoll;
    private int countOfDouble;
    private List<Property> properties;
    private int prisonTerm;
    private PrisonManager prisonManager;

    public Player(String id) {
        this.id = id;
        this.piece = new Piece(id, this);
        this.cash = 1_500;
        this.chanceToRoll = 0;
        this.countOfDouble = 0;
        this.properties = new ArrayList<Property>();
        this.prisonTerm = 0;
        this.prisonManager = new PrisonManager(this);
    }

    public void takeTurn() {
        if (isInPrison()) {
            prisonManager.handlePrisonTurn();
        } else {
            playNormalTurn();
        }
    }

    public void playNormalTurn() {
        addChanceToRoll();
        while (chanceToRoll > 0) {
            System.out.println("플레이어 " + id + "의 차례입니다.");
            int numOfMove = rollDice();

            if (handleDouble()) {
                break; // 세 번째 더블일 경우 턴 종료
            } else {
                piece.moveForward(numOfMove);
            }

            chanceToRoll--;
        }
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
                System.out.println("더블이 나왔습니다. 한 번 더 주사위를 굴릴 수 있습니다.");
                addChanceToRoll();
            }
        } else {
            resetCountOfDouble();
        }
        return false;
    }

    private void sendToJail() {
        piece.setLocation(Board.squares.get(SquareType.JAIL.getIndex()));
        prisonTerm = 3; // 감옥에 가면 수감 기간을 3으로 설정
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

    private boolean isInPrison() {
        return prisonTerm > 0;
    }

    public void resetPrisonTerm() {
        prisonTerm = 0;
    }

    public boolean canPayBail() {
        return cash >= PrisonManager.BAIL_AMOUNT;
    }

    public void payBailAndLeavePrison(int amount) {
        reduceCash(amount);
        prisonTerm = 0;
        System.out.println("보석금을 내고 감옥에서 나갑니다.");
    }

    public int getPrisonTerm() {
        return prisonTerm;
    }

    public void setPrisonTerm(int prisonTerm) {
        this.prisonTerm = prisonTerm;
    }

    public void reducePrisonTerm() {
        prisonTerm--;
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

    public void drawCard(Queue<Card> deck) {
        Card card = deck.remove();
        card.takeEffect(this);
        deck.add(card);
    }

    public void askForMoveForward(SquareType squareType) {
        piece.moveForward(Board.SQUARES_TOTAL - getCurrentLocationId() + squareType.getIndex());
    }

    private int getCurrentLocationId() {
        return piece.getLocationId();
    }

    public void askForSetLocation(Square location) {
        piece.setLocation(location);
    }

    public void askForSetLocationAndReceiveSalary(Square location) {
        piece.setLocationAndReceiveSalary(location);
    }

    public void askForGoBack(int back) {
        piece.setLocation(Board.squares.get(getCurrentLocationId() - back));
    }
}