package domain.square;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayerTest {
    @Test
    @DisplayName("플레이어 생성 테스트")
    void 생성() {
        Player player = new Player("chori");
        assertThat(player).isEqualTo(new Player("chori"));
    }

    @Test
    @DisplayName("부지 구매 테스트")
    void 부지_구매() {
        RegularSquare square = new RegularSquare(1);
        Player player = new Player("chori");
        player.attemptPurchase(square);
        assertThat(player.getCash()).isEqualTo(1_495_000);
    }

    @Test
    @DisplayName("임대료 지불 테스트")
    void 임대료_지불() {
        System.out.println("임대료 지불");
        RegularSquare square = new RegularSquare(1);
        Player player1 = new Player("chori");
        player1.attemptPurchase(square);

        Player player2 = new Player("paka");
        player2.attemptPurchase(square);
        assertThat(player1.getCash()).isEqualTo(1_505_000);
        assertThat(player2.getCash()).isEqualTo(1_490_000);
    }

    @Test
    @DisplayName("현금 감소 테스트")
    void 현금_감소() {
        Player player = new Player("chori");
        player.reduceCash(100_000);
        assertThat(player.getCash()).isEqualTo(1_400_000);
    }

    @Test
    @DisplayName("현금 증가 테스트")
    void 현금_증가() {
        Player player = new Player("chori");
        player.addCash(100_000);
        assertThat(player.getCash()).isEqualTo(1_600_000);
    }
}