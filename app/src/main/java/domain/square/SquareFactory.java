package domain.square;

public class SquareFactory {
    private static int idCounter = -1;  // idCounter 초기값을 -1로 설정

    public static Square createSquare(SquareType squareType) {
        int id = ++idCounter;  // 고유한 ID 부여

        switch (squareType) {
            case LOT_SUWON:
            case LOT_YONGIN:
            case LOT_GUNSAN:
            case LOT_IKSAN:
            case LOT_JEONJU:
            case LOT_GYEONGJU:
            case LOT_POHANG:
            case LOT_DAEGU:
            case LOT_CHANGWON:
            case LOT_ULSAN:
            case LOT_BUSAN:
            case LOT_JEJU:
            case LOT_YEOSU:
            case LOT_GWANGJU:
            case LOT_CHUNCHEON:
            case LOT_GANGNEUNG:
            case LOT_WONJU:
            case LOT_CHEONGJU:
            case LOT_CHEONAN:
            case LOT_DAEJEON:
            case LOT_INCHEON:
            case LOT_SEOUL:
                return new LotSquare(id, squareType.getName(), squareType.getPrice());
            case RAILROAD_GWANGJU:
            case RAILROAD_BUSAN:
            case RAILROAD_CHUNCHEON:
            case RAILROAD_SEOUL:
                return new RailRoadSquare(id, squareType.getName(), squareType.getPrice());
            case UTILITY_ELECTRIC:
            case UTILITY_WATER:
                return new UtilitySquare(id, squareType.getName(), squareType.getPrice());
            case GO:
                return new StartSquare(id, squareType.getName());
            case JAIL:
                return new JailSquare(id, squareType.getName());
            case FREE_PARKING:
                return new FreeParkingSquare(id, squareType.getName());
            case GO_TO_JAIL:
                return new GoToJailSquare(id, squareType.getName());
            case INCOME_TAX:
                return new IncomeTaxSquare(id, squareType.getName());
            case LUXURY_TAX:
                return new LuxuryTaxSquare(id, squareType.getName());
            case SOCIAL_FUND_2:
            case SOCIAL_FUND_17:
            case SOCIAL_FUND_33:
                return new SocialFundSquare(id, squareType.getName());
            case CHANCE_7:
            case CHANCE_22:
            case CHANCE_36:
                return new ChanceSquare(id, squareType.getName());
            default:
                throw new IllegalArgumentException("Unknown square type: " + squareType);
        }
    }
}