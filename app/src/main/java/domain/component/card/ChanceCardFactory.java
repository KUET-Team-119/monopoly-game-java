package domain.component.card;

public class ChanceCardFactory {
    private static int indexCounter = -1;

    public static ChanceCard createChanceCards(ChanceCardType chanceCardType) {
        int index = ++indexCounter;

        switch (chanceCardType) {
            case DEPOSIT_150_CASH:
            case DEPOSIT_50_CASH:
                return new DepositChanceCard(index, chanceCardType.getName(), chanceCardType.getAmount());
            case WITHDRAW_15_CASH:
                return new WithdrawChanceCard(index, chanceCardType.getName(), chanceCardType.getAmount());
            case FORWARD_TO_START_SQUARE:
                return new ForwardToStartChanceCard(index, chanceCardType.getName());
            case FORWARD_TO_FIRST_RAILROAD_SQUARE:
                return new ForwardToFirstRailRoadChanceCard(index, chanceCardType.getName());
            case FORWARD_TO_NEAREST_RAILROAD_SQUARE:
                return new ForwardToNearestRailRoadChanceCard(index, chanceCardType.getName());
            case FORWARD_TO_NEAREST_UTILITY_SQUARE:
                return new ForwardToNearestUtilityChanceCard(index, chanceCardType.getName());
            case PAY_50_CASH_TO_OTHER_PLAYERS:
                return new PayToOtherPlayersChanceCard(index, chanceCardType.getName(), chanceCardType.getAmount());
            case GO_BACK:
                return new GoBackChanceCard(index, chanceCardType.getName());
            case GO_TO_JAIL:
                return new GoToJailChanceCard(index, chanceCardType.getName());
            default:
                throw new IllegalArgumentException("Unknown socialFundCard type: " + chanceCardType);
        }
    }
}
