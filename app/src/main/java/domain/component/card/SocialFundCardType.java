package domain.component.card;

public enum SocialFundCardType {
    FOWARD_TO_GO_SQUARE(0, "출발점으로 전진", 0),
    DEPOSIT_200_CASH(1, "은행에게 200원 받기", 200),
    DEPOSIT_100_CASH(2, "은행에게 100원 받기", 100),
    DEPOSIT_50_CASH(3, "은행에게 50원 받기", 50),
    DEPOSIT_25_CASH(4, "은행에게 25원 받기", 25),
    DEPOSIT_20_CASH(5, "은행에게 20원 받기", 20),
    DEPOSIT_10_CASH(6, "은행에게 10원 받기", 10),
    WITHDRAW_150_CASH(7, "은행에 150원 내기", 150),
    WITHDRAW_100_CASH(8, "은행에 100원 내기", 100),
    WITHDRAW_50_CASH(9, "은행에 50원 내기", 50),
    RECEIVE_10_CASH_FROM_OTHER_PLAYERS(10, "다른 사람에게 10원씩 받기", 10),
    GO_TO_JAIL(11, "감옥으로 가시오", 0);

    private final int index;
    private final String name;
    private final int amount;

    SocialFundCardType(int index, String name, int amount) {
        this.index = index;
        this.name = name;
        this.amount = amount;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
}