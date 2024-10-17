package domain.component.card;

public class SocialFundCardFactory {
    private static int indexCounter = -1;

    public static SocialFundCard createSquare(SocialFundCardType socialFundCardType) {
        int index = ++indexCounter;

        switch (socialFundCardType) {
            case DEPOSIT_200_CASH:
            case DEPOSIT_100_CASH:
            case DEPOSIT_50_CASH:
            case DEPOSIT_25_CASH:
            case DEPOSIT_20_CASH:
            case DEPOSIT_10_CASH:
                return new DepositSocialFundCard(index, socialFundCardType.getName(), socialFundCardType.getAmount());
            case WITHDRAW_150_CASH:
            case WITHDRAW_100_CASH:
            case WITHDRAW_50_CASH:
                return new WithdrawSocialFundCard(index, socialFundCardType.getName(), socialFundCardType.getAmount());
            case FOWARD_TO_GO_SQUARE:
                return new FowardToStartSocialFundCard(index, socialFundCardType.getName());
            case RECEIVE_10_CASH_FROM_OTHER_PLAYERS:
                return new ReceiveFromOtherPlayersSocialFundCard(index, socialFundCardType.getName(), socialFundCardType.getAmount());
            case GO_TO_JAIL:
                return new GoToJailSocialFundCard(index, socialFundCardType.getName());
            default:
                throw new IllegalArgumentException("Unknown socialFundCard type: " + socialFundCardType);
        }
    }
}
