package domain.square;

public class SquareFactory {
    private static int idCounter = 0;

    public static Square createSquare(String squareType, String name, int price) {
        int id = ++idCounter;  // 고유한 ID 부여

        switch (squareType) {
            case "Lot":
                return new LotSquare(id, name, price);
            case "RailRoad":
                return new RailRoadSquare(id, name, price);
            case "Utility":
                return new UtilitySquare(id, name, price);
            case "Go":
                return new GoSquare(id, name);
            case "Jail":
                return new JailSquare(id, name);
            case "FreeParking":
                return new FreeParkingSquare(id, name);
            case "GoToJail":
                return new GoToJailSquare(id, name);
            case "IncomeTax":
                return new IncomeTaxSquare(id, name);
            case "LuxuryTax":
                return new LuxuryTaxSquare(id, name);
            case "SocialFundTax":
                return new SocialFundSquare(id, name);
            case "ChanceTax":
                return new ChanceSquare(id, name);
            default:
                throw new IllegalArgumentException("Unknown square type: " + squareType);
        }
    }
}