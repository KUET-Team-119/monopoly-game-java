package domain.component.property;

import domain.component.Board;

public class LotProperty extends Property {

    private final int MAX_COUNT_OF_HOUSE = 4;
    private final int MAX_COUNT_OF_HOTEL = 1;

    private int defaultRent;
    private int numOfHouse;
    private int numOfHotel;
    private int housePrice;
    private int hotelPrice;

    public LotProperty(int index, String name, int price) {
        super(index, name, price);
    }

    private int getHouseRent() {
        return numOfHouse * housePrice;
    }

    private int getHotelRent() {
        return numOfHotel * hotelPrice;
    }

    public boolean canBuildHouse() {
        return numOfHouse < MAX_COUNT_OF_HOUSE;
    }

    public boolean canBuildHotel() {
        return numOfHotel < MAX_COUNT_OF_HOTEL;
    }

    @Override
    public int getRent() {
        return defaultRent + getHouseRent() + getHotelRent();
    }
}
