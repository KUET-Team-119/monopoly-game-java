package domain.component;

// Enum을 이용한 싱글톤
public enum Cup {
    INSTANCE;

    private Die firstDie;
    private Die secondDie;

    Cup() {
        this.firstDie = new Die();
        this.secondDie = new Die();
    }

    public int roll() {
        firstDie.roll();
        secondDie.roll();
        return firstDie.getFaceValue() + secondDie.getFaceValue();
    }

    public boolean isDouble() {
        return firstDie.getFaceValue() == secondDie.getFaceValue();
    }
}

// 정적 팩토리 메서드 지연 초기화 방식의 싱글톤
/* 
public class Cup {
    private static Cup instance;

    private Die firstDie;
    private Die secondDie;

    private Cup() {
        this.firstDie = new Die();
        this.secondDie = new Die();
    }

    public static Cup getInstance() {
        if (instance == null) {
            instance = new Cup();
        }
        return instance;
    }

    public int roll() {
        firstDie.roll();
        secondDie.roll();
        return firstDie.getFaceValue() + secondDie.getFaceValue();
    }

    public boolean isDouble() {
        return firstDie.getFaceValue() == secondDie.getFaceValue();
    }
}
*/
