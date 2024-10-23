package domain.square;

import domain.player.Player;

public class JailSquare extends Square {

    public JailSquare(int index, String name) {
        this.index = index;
        this.name = name;
    }

    @Override
    public void landedOn(Player player) {
        System.out.println("감옥에서 면회 중...");
    }

}
