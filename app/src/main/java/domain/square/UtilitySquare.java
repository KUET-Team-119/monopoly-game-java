package domain.square;

public class UtilitySquare extends PropertySquare {
    
    public UtilitySquare(int index, String name, int price) {
        super(index, name, price);
    }

    @Override
    public int getRent() {
        int count = owner.getSquareManager().countUtilitySquares();
        int faceValue = owner.getDiceRollingManager().rollDice();
        if (count == 1) {
            return faceValue * 4;
        }
        return faceValue * 10;
    }

    @Override
    public void manageSquare() {
        System.out.println(name + "을 둘러봅니다.");
    }
}