package domain.square;

import java.util.Objects;
import java.util.Random;

public class Die {
    String id;
    int faceValue;

    public Die(String id) {
        this.id = id;
    }

    public int roll(int value) {
        faceValue = value;
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