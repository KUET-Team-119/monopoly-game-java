package domain.square;

import domain.player.Player;

public class GoSquare extends Square{
    private final int SALARY = 200;

    public GoSquare(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    void landedOn(Player player) {
        System.out.println("월급 " + SALARY + "원을 받아가세요.");
        player.addCash(SALARY);
    }
    
}
