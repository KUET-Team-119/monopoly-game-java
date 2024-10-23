package domain.component.property;

public class RailRoadProperty extends Property {

    private final int RAILROAD_RENT = 25;

    public RailRoadProperty(int index, String name, int price) {
        super(index, name, price);
    }

    @Override
    public int getRent() {
        return RAILROAD_RENT * owner.countRailRoadProperty();
    }
}
