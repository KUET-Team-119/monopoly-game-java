 package domain.square;

 import domain.component.Piece;
 import domain.player.Player;
 import org.junit.jupiter.api.Test;
 import org.junit.jupiter.api.DisplayName;
 import static org.junit.jupiter.api.Assertions.*;
 import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

 public class PieceTest {
     @Test
     @DisplayName("Piece 생성 테스트")
     void 생성() {
         Piece piece = new Piece(1, new Player(1));
         assertThat(piece).isEqualTo(new Piece(1, new Player(1)));
     }
 }