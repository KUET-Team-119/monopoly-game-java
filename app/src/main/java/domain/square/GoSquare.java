package domain.square;

import domain.player.Player;

public class GoSquare extends Square{

    public GoSquare(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    void landedOn(Player player) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'landedOn'");
    }
    
}
