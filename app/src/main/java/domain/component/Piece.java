package domain.component;

import domain.player.Player;
import domain.square.Square;
import domain.square.SquareType;

public class Piece {
    @SuppressWarnings("unused")
    private String id;
    private Player player;
    private Square location;

    public Piece(String id, Player player) {
        this.id = id;
        this.player = player;
        this.location = Board.squares.get(SquareType.START.getIndex());  // 출발점에서 시작
    }

    // 몇 칸 앞으로 이동하는 행동
    public void moveForwardBySteps(int steps) {
        System.out.println("앞으로 " + steps + "칸 이동합니다.");
        int currentLocationId = getLocationId();
        int destinationId = (currentLocationId + steps) % Board.SQUARES_TOTAL;
        if (isPassedGoSquare(destinationId, currentLocationId)) {
            System.out.println("출발칸을 지나갔으니 월급 받으세요.");
            player.getCashManager().addCash(200);
        }
        setLocation(Board.squares.get(destinationId));
    }

    // 몇 칸 뒤로 이동하는 행동
    public void moveBackwardBySteps(int steps) {
        System.out.println("뒤로 " + steps + "칸 이동합니다.");
        int currentLocationId = getLocationId();
        if (currentLocationId >= steps) {
            setLocation(Board.squares.get(getLocationId() - steps));
        } else {
            setLocation(Board.squares.get(Board.SQUARES_TOTAL + currentLocationId - steps));
        }
    }

    // 특정 칸까지 앞으로 이동하는 행동
    public void moveFowardToSquareType(SquareType squareType) {
        int destinationId = squareType.getIndex();
        int currentLocationId = getLocationId();
        if (destinationId >= currentLocationId) {
            moveForwardBySteps(destinationId - currentLocationId);
        } else {
            moveForwardBySteps(Board.SQUARES_TOTAL - getLocationId() + squareType.getIndex());
        }
    }

    // 인자로 받은 SqaureType으로 말의 위치 변경(메서드 오버로드)
    public void setLocation(SquareType destination) {
        this.location = Board.squares.get(destination.getIndex());
        System.out.println(location.getName() +"에 도착했습니다.");
        location.landedOn(player);
    }

    // 인자로 받은 Sqaure로 말의 위치 변경(메서드 오버로드)
    public void setLocation(Square destination) {
        this.location = destination;
        System.out.println(location.getName() + "에 도착했습니다.");
        location.landedOn(player);
    }
    
    private boolean isPassedGoSquare(int currentLocationId, int destinationId) {                
        return destinationId < currentLocationId && destinationId != SquareType.START.getIndex();
    }

    public int getLocationId() {
        return location.getIndex();
    }
}