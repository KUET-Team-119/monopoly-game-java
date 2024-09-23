package domain.component.property;

public class LotProperty extends Property {

    private int defaultRent;
    private int numOfHouse;
    private int numOfHotel;
    private int housePrice;
    private int hotelPrice;

    public LotProperty(int id, String name, int price) {
        super(id, name, price);
    }

    private int getHouseRent() {
        return numOfHouse * housePrice;
    }

    private int getHotelRent() {
        return numOfHotel * hotelPrice;
    }

    @Override
    public int getRent() {
        return defaultRent + getHouseRent() + getHotelRent();
    }
}
