package domain.square;

import domain.player.Player;

public class IncomeTaxSquare extends Square {
    private final int TAX = 200;

    public IncomeTaxSquare(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void landedOn(Player player) {
        System.out.println("소득세 " + TAX + "원을 납부하세요.");
        player.reduceCash(TAX);
    }
    
}
