package domain.component;

import util.RandomUtil;

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

    public int getFaceValue() {
        return faceValue;
    }
}