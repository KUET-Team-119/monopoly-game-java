package domain.legacy;

public abstract class Square {
    private String name;
    private Square nextSquare;
    private int index;

    public Square(String name, int index) {
        this.name = name;
        this.index = index;
    }

    abstract void landedOn(Player player);

    public void setNextSquare(Square square) {
        nextSquare = square;
    }

    public Square getNextSquare() {
        return nextSquare;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }
}
