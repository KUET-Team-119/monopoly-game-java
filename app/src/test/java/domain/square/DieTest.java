// package domain.square;

// import org.junit.jupiter.api.Test;

// import domain.component.Die;

// import org.junit.jupiter.api.DisplayName;
// import static org.junit.jupiter.api.Assertions.*;
// import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

// public class DieTest {
//     @Test
//     @DisplayName("주사위 생성")
//     void 생성() {
//         Die die = new Die("1");
//         assertThat(die).isEqualTo(new Die("1"));
//     }

//     @Test
//     @DisplayName("주사위 굴리기")
//     void roll() {
//         Die die = new Die("1");
//         assertThat(die.roll(6)).isEqualTo(6);
//     }
// }