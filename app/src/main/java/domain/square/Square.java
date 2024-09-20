package domain.square;

import java.util.Arrays;
import java.util.List;

public abstract class Square {
    // TODO 임시로 하드코딩
    public static final List<String> squareNames = Arrays.asList("출발점", "수원", "사회사업기금", "용인", "소득세", "광주역", "군산", "찬스", "익산",
            "전주", "감옥", "경주", "전력공사", "포항", "대구", "부산역", "창원", "사회사업기금", "울산", "부산", "무료 주차장", "제주", "찬스", "여수", "광주",
            "춘천역", "춘천", "강릉", "수자원공사", "원주", "감옥으로 가시오!", "청주", "천안", "사회사업기금", "대전", "서울역", "찬스", "인천", "사치세", "서울");

    int id;
    String name;

    public Square(int id) {
        this.id = id;
        name = squareNames.get(id);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}