package domain.square;

import domain.player.Player;
import domain.legacy.RegularSquare;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
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
        PropertySquare square = new LotSquare(1, "수원", 60);
        Player player = new Player(1);
        square.landedOn(player);

        assertThat(player.getCash()).isEqualTo(1_499_940);
    }

    @Test
    @DisplayName("임대료 지불 테스트")
    void 임대료_지불() {
        PropertySquare square = new LotSquare(1, "수원", 60);
        Player player1 = new Player(1);
        square.landedOn(player1);

        Player player2 = new Player(2);
        square.landedOn(player2);

        assertThat(player1.getCash()).isEqualTo(1_500_000);
        assertThat(player2.getCash()).isEqualTo(1_499_940);
    }

    @Test
    @DisplayName("현금 감소 테스트")
    void 현금_감소() {
        Player player = new Player(1);
        player.reduceCash(100_000);
        assertThat(player.getCash()).isEqualTo(1_400_000);
    }

    @Test
    @DisplayName("현금 증가 테스트")
    void 현금_증가() {
        Player player = new Player(1);
        player.addCash(100_000);
        assertThat(player.getCash()).isEqualTo(1_600_000);
    }
}