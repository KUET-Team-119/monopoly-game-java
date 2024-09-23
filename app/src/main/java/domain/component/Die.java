package domain.component;

import java.util.Objects;

import domain.util.RandomUtil;

public class Die {
    String id;
    int faceValue;
    RandomUtil randomUtil;

    public Die(String id) {
        this.id = id;
        randomUtil = new RandomUtil();
    }

    public int roll() {
        faceValue = randomUtil.generateRandomNum();
        return faceValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Die die))
            return false;
        return Objects.equals(id, die.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}