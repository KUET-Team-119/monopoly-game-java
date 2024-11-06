package domain.square;

public class RailRoadSquare extends PropertySquare {

    private final int RAILROAD_RENT = 25;

    public RailRoadSquare(int index, String name, int price) {
        super(index, name, price);
    }

    @Override
    public int getRent() {
        return RAILROAD_RENT * owner.getSquareManager().countRailRoadSquares();
    }

    @Override
    public void manageSquare() {
        System.out.println(name + "을 둘러봅니다.");
    }
}
