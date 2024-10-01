package domain.square;

import domain.player.Player;

public class ChanceSquare extends Square {

    public ChanceSquare(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    void landedOn(Player player) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'landedOn'");
    }
    
}
