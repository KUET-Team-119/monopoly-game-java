package domain.component.property;

public class UtilityProperty extends Property {
    public UtilityProperty(int id, String name, int price) {
        super(id, name, price);
    }

    @Override
    public int getRent() {
        int count = owner.countUtilityProperty();
        int faceValue = owner.rollDiceForUtilityRent();
        if (count == 1) {
            return faceValue * 4;
        }
        return faceValue * 10;
    }
}
