package domain.component.card;

import domain.component.Board;
import domain.player.Player;
import domain.square.Square;

public abstract class ForwardToNearestChanceCard extends ChanceCard {

    public ForwardToNearestChanceCard(int index, String name) {
        this.index = index;
        this.name = name;
    }

    protected abstract Class<? extends Square> getTargetSquareClass();

    @Override
    public void takeEffect(Player player) {
        int currentLocationId = player.getPieceMovingManager().getCurrentLocationId();
        Class<? extends Square> targetSquare = getTargetSquareClass();
        
        int boardSize = Board.squares.size();
        int steps = 0; // 이동할 칸 수

        // 보드 전체를 한 번 순회하며 탐색
        for (int i = 1; i <= boardSize; i++) {
            int nextLocationId = (currentLocationId + i) % boardSize;
            Square square = Board.squares.get(nextLocationId);
            
            if (targetSquare.isInstance(square)) {
                steps = i;
                break;
            }
        }

        // 찾은 칸 수만큼 이동
        if (steps > 0) {
            player.getPieceMovingManager().moveForwardBySteps(steps);
        }
    }
}
