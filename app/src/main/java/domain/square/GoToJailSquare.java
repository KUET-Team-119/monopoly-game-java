package domain.square;

import domain.component.Board;
import domain.player.Player;

public class GoToJailSquare extends Square {
    private final Square JAIL_SQUARE = Board.squares.get(SquareType.JAIL.getIndex());
    private final int PRISON_TERM = 3;

    public GoToJailSquare(int index, String name) {
        this.index = index;
        this.name = name;
    }

    @Override
    public void landedOn(Player player) {
        System.out.println("감옥으로 가세요.");
        System.out.println(PRISON_TERM + "회 동안 수감됩니다.");
        player.getPiece().setLocation(JAIL_SQUARE);
        player.setPrisonTerm(PRISON_TERM);
    }
    
}
