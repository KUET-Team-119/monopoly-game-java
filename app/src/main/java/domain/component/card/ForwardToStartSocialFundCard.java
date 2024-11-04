package domain.component.card;

import domain.player.Player;
import domain.square.SquareType;

public class ForwardToStartSocialFundCard extends SocialFundCard {
    
    ForwardToStartSocialFundCard(int index, String name) {
        this.index = index;
        this.name = name;
    }

    @Override
    public void takeEffect(Player player) {
        player.getPieceMovingManager().warpToSquareType(SquareType.START);
    }
    
}
