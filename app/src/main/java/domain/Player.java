package domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private Piece piece;
    private Board board;
    private Square location;
    private Cup cup;
    private int cash;
    private List<Square> ownSquare = new ArrayList<>();

    public Player(String name, Board board) {
        this.name = name;
        this.board = board;
        piece = new Piece(board.getStartSquare());
    }

    public void takeTurn() {
        cup.roll();
        int rollTotal = cup.getTotal();

        Square newLocation = board.getSquare(getLocation(), rollTotal);
        setLocation(newLocation);
    }

    public Square getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public void setLocation(Square location) {
        this.location = location;
    }

    public int getNetWorth() {
        return cash;
    }

    public void addCash(int cash) {
        this.cash += cash;
    }

    public void reduceCash(int min) {
        this.cash -= cash;
    }

    public void attemptPurchase(PropertySquare propertySquare) {
        int price = propertySquare.getPrice();
        if (cash >= price) {
            propertySquare.setOwner(this);
            ownSquare.add(propertySquare);
            reduceCash(price);
        }
    }

    public int getRailroadCount() {
        int count = 0;
        for (Square square : ownSquare) {
            count += isRailroadSquare(square);
        }
        return count;
    }

    private int isRailroadSquare(Square square) {
        if (square.getClass() == RailroadSquare.class) {
            return 1;
        }
        return 0;
    }
}
