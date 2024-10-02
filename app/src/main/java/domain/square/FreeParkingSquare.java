package domain.square;

import domain.player.Player;

public class FreeParkingSquare extends Square{

    public FreeParkingSquare(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void landedOn(Player player) {
        System.out.println("무료 주차장입니다.");
    }
    
}
