package domain.square;

import domain.player.Player;

public abstract class PropertySquare extends Square {
    protected int price;
    protected boolean soldOut;
    protected Player owner;

    public PropertySquare(int index, String name, int price) {
        this.index = index;
        this.name = name;
        this.price = price;
        this.owner = null;
        this.soldOut = false;
    }

    private void setOwner(Player player) {
        soldOut = true;
        owner = player;
    }

    public void landedOn(Player player) {
        if (owner == null) {
            System.out.println("주인 없는 땅입니다.");
            if (player.getCashManager().hasEnoughCash(price)) {
                System.out.println("땅을 구매합니다.");
                player.getCashManager().reduceCash(price);
                setOwner(player);
                player.getSquareManager().addPropertySquare(this.index, this);
            } else {
                System.out.println("돈이 부족해 땅을 구입할 수 없습니다.");
            }
            return;
        }
        if (owner == player) {
            System.out.println("본인 소유의 땅입니다.");
            manageSquare();
            return;
        }
        int rent = getRent();
        System.out.println("다른 플레이어 소유의 땅입니다. " + rent + "원의 임대료를 납부해야 합니다.");
        int amount = player.getCashManager().reduceCash(rent);
        System.out.println(amount + "원을 플레이어 " + owner.getId() + "에게 줍니다.");
        owner.getCashManager().addCash(amount);
    }

    public int getPrice() {
        return price;
    } 

    public abstract void manageSquare();

    public PropertySquare isMoreExpensive(PropertySquare square) {
        if (this.getRent() > square.getRent()) {
            return this;
        }
        return square;
    }

    public abstract int getRent();
}
