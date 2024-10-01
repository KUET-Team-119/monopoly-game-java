package domain.component;

import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import domain.square.Square;
import domain.square.SquareFactory;

public class Board {
    public static final int SQUARES_TOTAL = 40;
    // public final List<String> squareNames = Arrays.asList("출발점", "수원", "사회사업기금", "용인", "소득세", "광주역", "군산", "찬스", "익산",
    //         "전주", "감옥", "경주", "전력공사", "포항", "대구", "부산역", "창원", "사회사업기금", "울산", "부산", "무료 주차장", "제주", "찬스", "여수", "광주",
    //         "춘천역", "춘천", "강릉", "수자원공사", "원주", "감옥으로 가시오!", "청주", "천안", "사회사업기금", "대전", "서울역", "찬스", "인천", "사치세", "서울");

    public static Map<Integer, Square> squares;

    public Board() {
        squares = new HashMap<>();
        build();
    }

    private void build() {
        squares.put(0, SquareFactory.createSquare("Go", "출발점", 0));
        squares.put(1, SquareFactory.createSquare("Lot", "수원", 60));
        squares.put(2, SquareFactory.createSquare("SocialFund", "사회사업기금", 0));
        squares.put(3, SquareFactory.createSquare("Lot", "용인", 0));
        squares.put(4, SquareFactory.createSquare("IncomeTax", "소득세", 0));
        squares.put(5, SquareFactory.createSquare("RailRoad", "광주역", 200));
        squares.put(6, SquareFactory.createSquare("Lot", "군산", 100));
        squares.put(7, SquareFactory.createSquare("Chance", "찬스", 0));
        squares.put(8, SquareFactory.createSquare("Lot", "익산", 100));
        squares.put(9, SquareFactory.createSquare("Lot", "전주", 120));
        squares.put(10, SquareFactory.createSquare("Jail", "감옥", 0));
        squares.put(11, SquareFactory.createSquare("Lot", "경주", 140));
        squares.put(12, SquareFactory.createSquare("Utility", "전력공사", 150));
        squares.put(13, SquareFactory.createSquare("Lot", "포항", 140));
        squares.put(14, SquareFactory.createSquare("Lot", "대구", 160));
        squares.put(15, SquareFactory.createSquare("RailRoad", "부산역", 200));        
        squares.put(16, SquareFactory.createSquare("Lot", "창원", 180));
        squares.put(17, SquareFactory.createSquare("SocialFund", "사회사업기금", 0));
        squares.put(18, SquareFactory.createSquare("Lot", "울산", 180));
        squares.put(19, SquareFactory.createSquare("Lot", "부산", 200));
        squares.put(20, SquareFactory.createSquare("FreeParking", "무료 주차장", 0));
        squares.put(21, SquareFactory.createSquare("Lot", "제주", 220));
        squares.put(22, SquareFactory.createSquare("Chance", "찬스", 0));
        squares.put(23, SquareFactory.createSquare("Lot", "여수", 220));
        squares.put(24, SquareFactory.createSquare("Lot", "광주", 240));
        squares.put(25, SquareFactory.createSquare("RailRoad", "춘천역", 200));
        squares.put(26, SquareFactory.createSquare("Lot", "춘천", 260));
        squares.put(27, SquareFactory.createSquare("Lot", "강릉", 260));
        squares.put(28, SquareFactory.createSquare("Utility", "수자원공사", 150));
        squares.put(29, SquareFactory.createSquare("Lot", "원주", 280));
        squares.put(30, SquareFactory.createSquare("GoToJail", "감옥으로 가시오", 0));
        squares.put(31, SquareFactory.createSquare("Lot", "청주", 300));
        squares.put(32, SquareFactory.createSquare("Lot", "천안", 300));
        squares.put(33, SquareFactory.createSquare("SocialFund", "사회사업기금", 0));
        squares.put(34, SquareFactory.createSquare("Lot", "대전", 320));
        squares.put(35, SquareFactory.createSquare("RailRoad", "서울역", 200));
        squares.put(36, SquareFactory.createSquare("Chance", "찬스", 0));
        squares.put(37, SquareFactory.createSquare("Lot", "인천", 350));
        squares.put(38, SquareFactory.createSquare("LuxuryTax", "사치세", 0));
        squares.put(39, SquareFactory.createSquare("Lot", "서울", 400));
    }

    // private void build() {
    //     for (int i = 0; i < 40; i++) {
    //         squares.put(i, new LotSquare(i, squareNames.get(i)));
    //     }
    // }
}