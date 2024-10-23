package domain.component;

import domain.player.Player;
import domain.square.Square;
import domain.square.SquareType;

public class Piece {
    private String id;
    private Square location;
    private Player player;

    public Piece(String id, Player player) {
        this.id = id;
        this.player = player;
        this.location = Board.squares.get(SquareType.START.getIndex());  // 출발점에서 시작
    }

    public void moveForward(int numOfMove) {
        System.out.println("앞으로 " + numOfMove + "칸 이동합니다.");
        int currentLocationId = getLocation().getId();
        int destinationId = (currentLocationId + numOfMove) % Board.SQUARES_TOTAL;
        setLocation(Board.squares.get(destinationId));

        if (isPassedGoSquare(destinationId, currentLocationId)) {
            System.out.println("출발칸을 지나갔으니 월급 받으세요.");
            player.addCash(200);
        }
    }

    public Square getLocation() {
        return location;
    }

    public void setLocation(Square destination) {
        this.location = destination;
        System.out.println(location.getName() +"에 도착했습니다.");
        location.landedOn(player);
    }

    public void setLocationAndReceiveSalary(Square destination) {
        setLocation(destination);
        player.addCash(200);
    }

    private boolean isPassedGoSquare(int currentLocationId, int destinationId) {                
        return destinationId < currentLocationId && destinationId != SquareType.START.getIndex();
    }

    public int getLocationId() {
        return location.getId();
    }

    public String getId() {
        return id;
    }
}