 package domain.square;

 import org.junit.jupiter.api.Test;
 import org.junit.jupiter.api.DisplayName;
 import static org.junit.jupiter.api.Assertions.*;
 import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

 public class SquareTest {
     @Test
     @DisplayName("땅 생성 테스트")
         void 생성() {
         Square square = new RegularSquare(1);
         assertThat(square).isEqualTo(new RegularSquare(1));
     }

     @Test
     @DisplayName("땅 가격 찾기 테스트")
         void findPrice() {
         RegularSquare square = new RegularSquare(1);
         assertThat(square.findPrice()).isEqualTo(5_000);
     }
 }