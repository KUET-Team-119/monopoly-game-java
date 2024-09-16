package domain;

public class UtilitySquare extends PropertySquare {

    private static final int UTILITYPRICE = 4;
    public UtilitySquare(String name, int index) {
        super(name, index);
    }

    @Override
    int getRent(Player player) {
        return new Cup().getTotal() * UTILITYPRICE;
    }

}
