package domain.component.property;

public class RailRoadProperty extends Property {

    private final int RAILROAD_RENT = 25;

    public RailRoadProperty(int id, String name, int price) {
        super(id, name, price);
    }

    @Override
    public int getRent() {
        return RAILROAD_RENT * owner.countRailRoadProperty();
    }
}
