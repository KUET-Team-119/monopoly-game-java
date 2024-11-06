package domain.component.building;

public class House extends Building {
    public final int MAX_COUNT_OF_HOUSE = 4;

    public House(int price) {
        super((int) Math.round(price * 0.1));
    }

    @Override
    public boolean canBuild() {
        return count < MAX_COUNT_OF_HOUSE;
    }
}
