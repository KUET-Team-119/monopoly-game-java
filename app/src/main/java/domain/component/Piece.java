package domain.component;

import java.util.Objects;

import domain.square.LotSquare;
import domain.square.Square;

public class Piece {
    String name;
    Square location;

    public Piece(String name) {
        this.name = name;
        // TODO LotSquare 생성이 이상함
        this.location = new LotSquare(0, "시작");
    }

    public void move(int numOfMove) {
        System.out.println("앞으로 " + numOfMove + "칸 이동합니다.");
        int currentLocationId = getLocation().getId();
        int destinationId = (currentLocationId + numOfMove) % Board.SQUARES_TOTAL;
        // TODO LotSquare 생성이 이상함
        this.location = new LotSquare(destinationId, "시작");
        System.out.println(location.getName() +"에 도착했습니다.");
    }

    public Square getLocation() {
        return this.location;
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