package domain.square;

import domain.player.Player;

public class LuxuryTaxSquare extends Square {

    public LuxuryTaxSquare(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    void landedOn(Player player) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'landedOn'");
    }
    
}
