package domain.square;

import domain.player.Player;

public class FreeParkingSquare extends Square{

    public FreeParkingSquare(int index, String name) {
        this.index = index;
        this.name = name;
    }

    @Override
    public void landedOn(Player player) {
        System.out.println("무료 주차장입니다.");
    }
    
}
