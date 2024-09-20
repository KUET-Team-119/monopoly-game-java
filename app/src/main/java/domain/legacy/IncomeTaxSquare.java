package domain.legacy;
import java.lang.Math;

public class IncomeTaxSquare extends Square {
    private static final int TAX = 200;
    public IncomeTaxSquare(String name, int index) {
        super(name, index);
    }

    @Override
    void landedOn(Player player) {
        player.reduceCash(Math.min(player.getNetWorth(), TAX));
    }

}
