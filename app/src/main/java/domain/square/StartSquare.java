package domain.square;

import domain.player.Player;

public class StartSquare extends Square{
    private final int SALARY = 200;

    public StartSquare(int index, String name) {
        this.index = index;
        this.name = name;
    }

    @Override
    public void landedOn(Player player) {
        System.out.println("월급 " + SALARY + "원을 받아가세요.");
        player.getCashManager().addCash(SALARY);
    }
    
}
