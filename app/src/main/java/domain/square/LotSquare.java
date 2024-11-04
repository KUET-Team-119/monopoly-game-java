package domain.square;

import domain.component.Board;
import domain.component.property.LotProperty;
import domain.player.Player;

public class LotSquare extends PropertySquare {

    private final LotProperty lotProperty;

    public LotSquare(int index, String name, int price) {
        super(index, name);
        this.lotProperty = new LotProperty(index, name, price);
        this.property = lotProperty;
    }

    @Override
    public void landedOn(Player player) {
        Player owner = property.getOwner();
        int price = property.getPrice();
        if (owner == null && player.getCashManager().hasEnoughCash(price)) {
            player.getCashManager().reduceCash(price);
            player.getPropertyManager().addProperty(property);
            setOwner(player);
            return;
        }
        if (owner == player) {
            // 보드 판 위에 있는 건물 수 (남아있는 건물 수 확인)
            if (Board.canBuildHouse() && lotProperty.canBuildHouse()) {
                // 주택 짓기
            } else if (Board.canBuildHouse() && !lotProperty.canBuildHouse()) {
                // 호텔 가능 여부 계산
                if (Board.canBuildHotel() && lotProperty.canBuildHotel()) {

                }
            }
            // 지어져 있는 건물(주택, 호텔 수) -> 주택 확인을 하고, 주택이 4개이면 못하고
            // 내 돈 확인 (건설 비용보다 크거나 같아야)
            // 건물을 추가 -> LotProperty에 해당 건물 수를 늘린다
            // Board에서 관리하는 건물 수 하나 더해야 함
            // 사용자 건설비용만큼 cash 줄이기
            return;
        }
        int rent = property.getRent();
        int amount = player.getCashManager().reduceCash(rent);
        owner.getCashManager().addCash(amount);
    }
}