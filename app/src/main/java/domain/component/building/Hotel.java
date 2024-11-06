package domain.component.building;

public class Hotel extends Building {
    private final int MAX_COUNT_OF_HOTEL = 1;

    public Hotel(int price) {
        super((int) Math.round(price * 0.4));
    }

    @Override
    public boolean canBuild() {
        return count < MAX_COUNT_OF_HOTEL;
    }
}
