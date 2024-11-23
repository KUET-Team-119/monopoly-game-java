package domain.square;

import domain.player.Player;

public class GoToJailSquare extends Square {

    public GoToJailSquare(int index, String name) {
        this.index = index;
        this.name = name;
    }

    @Override
    public void landedOn(Player player) {
        System.out.println("감옥으로 가세요.");
        player.getPieceMovingManager().warpToSquareType(SquareType.JAIL);
        player.getStateManager().becomePrisonState();
    }
    
}
