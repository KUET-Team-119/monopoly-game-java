package domain.square;

import domain.player.Player;

public class ChanceSquare extends Square {

    public ChanceSquare(int index, String name) {
        this.index = index;
        this.name = name;
    }

    @Override
    public void landedOn(Player player) {
        System.out.println("찬스 칸에 도착했습니다.");
    }
    
}
