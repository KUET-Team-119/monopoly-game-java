package domain.component.property;

public class UtilityProperty extends Property {
    public UtilityProperty(int index, String name, int price) {
        super(index, name, price);
    }

    @Override
    public int getRent() {
        int count = owner.countUtilityProperty();
        int faceValue = owner.rollDice();
        if (count == 1) {
            return faceValue * 4;
        }
        return faceValue * 10;
    }
}
