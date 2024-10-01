package domain.component;

import java.util.Objects;

import domain.square.Square;

public class Piece {
    String name;
    Square location;

    public Piece(String name) {
        this.name = name;
        this.location = Board.squares.get(0);  // 출발점에서 시작
    }

    public void goForward(int numOfMove) {
        System.out.println("앞으로 " + numOfMove + "칸 이동합니다.");
        int currentLocationId = getLocation().getId();
        int destinationId = (currentLocationId + numOfMove) % Board.SQUARES_TOTAL;
        setLocation(Board.squares.get(destinationId));
        System.out.println(location.getName() +"에 도착했습니다.");
    }

    public Square getLocation() {
        return this.location;
    }

    public void setLocation(Square destination) {
        this.location = destination;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (!(object instanceof Piece piece))
            return false;
        return Objects.equals(name, piece.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}