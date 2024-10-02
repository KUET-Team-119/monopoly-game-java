package domain.square;

import domain.player.Player;

public class JailSquare extends Square {

    public JailSquare(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void landedOn(Player player) {
        System.out.println("감옥에서 면회 중...");
    }

}
