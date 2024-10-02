package domain.square;

import domain.player.Player;

public class ChanceSquare extends Square {

    public ChanceSquare(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void landedOn(Player player) {
        // TODO Auto-generated method stub
        System.out.println("찬스 칸에 도착했습니다.");
    }
    
}
