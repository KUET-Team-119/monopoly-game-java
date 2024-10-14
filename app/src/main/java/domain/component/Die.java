package domain.component;

// import java.util.Objects;

import domain.util.RandomUtil;

public class Die {
    private int faceValue;
    private RandomUtil randomUtil;

    public Die() {
        this.randomUtil = new RandomUtil();
    }

    public void roll() {
        faceValue = randomUtil.generateRandomNum();
        System.out.println("주사위의 눈: " + faceValue);
    }

//    public int getFaceValue() {
//        return faceValue;
//    }

    public int calculateTotal(Die firstDie, Die secondDie) {
        return firstDie.faceValue + secondDie.faceValue;
    }

    public boolean isSameFaceValue(Die firstDie, Die secondDie) {
        return firstDie.faceValue == secondDie.faceValue;
    }

    // @Override
    // public boolean equals(Object o) {
    //     if (this == o)
    //         return true;
    //     if (!(o instanceof Die die))
    //         return false;
    //     return Objects.equals(id, die.id);
    // }

    // @Override
    // public int hashCode() {
    //     return Objects.hash(id);
    // }
}