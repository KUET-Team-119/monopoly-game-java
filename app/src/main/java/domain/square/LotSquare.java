package domain.square;

import domain.component.Board;
import domain.component.building.Hotel;
import domain.component.building.House;

public class LotSquare extends PropertySquare {

    private final House house;
    private final Hotel hotel;

    public LotSquare(final int index, final String name, final int price) {
        super(index, name, price);
        this.house = new House(price);
        this.hotel = new Hotel(price);
    }

    @Override
    public void manageSquare() {
        if (canBuildHouse()) {
            System.out.println("주택을 짓습니다.");
            house.build();
            Board.addCountOfHouse();
            owner.getCashManager().reduceCash((house.getPrice()));
        } else if (canBuildHotel()) {
            System.out.println("호텔을 짓습니다.");
            hotel.build();
            Board.addCountOfHotel();
            owner.getCashManager().reduceCash((hotel.getPrice()));
        } else {
            System.out.println("건물을 지을 수 없습니다.");
        }
    }

    private boolean canBuildHouse() {
        return Board.canBuildHouse() &&
               house.canBuild() &&
               owner.getCashManager().hasEnoughCash(house.getPrice());
    }

    private boolean canBuildHotel() {
        return Board.canBuildHotel() &&
               !house.canBuild() &&
               hotel.canBuild() &&
               owner.getCashManager().hasEnoughCash(hotel.getPrice());
    }

    public void destroyBuilding() {
        house.destroy();
        hotel.destroy();
    }

    @Override
    public int getRent() {
        return price + house.getRent() + hotel.getRent();
    }
}