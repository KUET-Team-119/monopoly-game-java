package domain.component;

import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import domain.square.LotSquare;
import domain.square.Square;

public class Board {
    public static final int SQUARES_TOTAL = 40;
    public final List<String> squareNames = Arrays.asList("출발점", "수원", "사회사업기금", "용인", "소득세", "광주역", "군산", "찬스", "익산",
            "전주", "감옥", "경주", "전력공사", "포항", "대구", "부산역", "창원", "사회사업기금", "울산", "부산", "무료 주차장", "제주", "찬스", "여수", "광주",
            "춘천역", "춘천", "강릉", "수자원공사", "원주", "감옥으로 가시오!", "청주", "천안", "사회사업기금", "대전", "서울역", "찬스", "인천", "사치세", "서울");

    private Map<Integer, Square> squares;

    public Board() {
        squares = new HashMap<>();
        build();
    }

    private void build() {
        for (int i = 0; i < 40; i++) {
            squares.put(i, new LotSquare(i, squareNames.get(i)));
        }
    }
}