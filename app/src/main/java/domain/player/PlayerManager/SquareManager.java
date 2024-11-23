package domain.player.PlayerManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.square.RailRoadSquare;
import domain.square.UtilitySquare;
import domain.square.LotSquare;
import domain.square.PropertySquare;

public class SquareManager {
    private Map<Integer, PropertySquare> propertySquares;

    public SquareManager() {
        this.propertySquares = new HashMap<Integer, PropertySquare>();
    }

    public void addPropertySquare(int index, PropertySquare square) {
        propertySquares.put(index, square);
    }

    public int countRailRoadSquares() {
        int count = 0;
        for (PropertySquare propertySquare : propertySquares.values()) {
            if (propertySquare instanceof RailRoadSquare) {
                count++;
            }
        }
        return count;
    }

    public int countUtilitySquares() {
        int count = 0;
        for (PropertySquare propertySquare : propertySquares.values()) {
            if (propertySquare instanceof UtilitySquare) {
                count++;
            }
        }
        return count;
    }

    public Map<Integer, PropertySquare> getPropertySquares() {
        return propertySquares;
    }

    // 특정 부지를 맵에서 제거
    public void removePropertySquare(int index) {
        PropertySquare propertySquare = propertySquares.get(index);
        if (propertySquare != null) {
            // 부지가 LotSquare라면 집이나 호텔을 제거하는 추가 작업 수행
            if (propertySquare instanceof LotSquare) {
                LotSquare lotSquare = (LotSquare) propertySquare;

                // 부지에 집이나 호텔이 있다면 이를 먼저 처리
                lotSquare.destroyBuilding();
            }

            // 부지를 Map에서 제거
            propertySquares.remove(index);
        }
    }

    // 부지의 가치를 기준으로 propertySquares 정렬
    public List<PropertySquare> getSortedPropertySquare() {
        List<PropertySquare> sortedPropertySquares = propertySquares.values().stream()
                .sorted((p1, p2) -> Integer.compare(p2.getRent(), p1.getRent()))
                .toList();
        return sortedPropertySquares;
    }
}