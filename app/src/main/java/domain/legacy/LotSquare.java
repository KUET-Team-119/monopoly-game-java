package domain.legacy;

public class LotSquare extends PropertySquare {
    public LotSquare(String name, int index) {
        super(name, index);
    }

    @Override
    int getRent(Player player) {
        return this.getIndex();
    }

}
