package domain.square;

import domain.player.Player;

public class LuxuryTaxSquare extends Square {
    private final int TAX = 100;

    public LuxuryTaxSquare(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void landedOn(Player player) {
        System.out.println("사치세 " + TAX + "원을 납부하세요.");
        player.reduceCash(TAX);
    }
    
}
