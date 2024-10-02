package domain.square;

import domain.player.Player;

public class SocialFundSquare extends Square {

    public SocialFundSquare(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void landedOn(Player player) {
        // TODO Auto-generated method stub
        System.out.println("사회사업기금 칸에 도착했습니다.");
    }
    
}
