package domain.square;

import domain.player.Player;

public class IncomeTaxSquare extends Square {
    private final int TAX = 200;

    public IncomeTaxSquare(int index, String name) {
        this.index = index;
        this.name = name;
    }

    @Override
    public void landedOn(Player player) {
        System.out.println("소득세 " + TAX + "원을 납부하세요.");
        player.reduceCash(TAX);
    }
    
}
