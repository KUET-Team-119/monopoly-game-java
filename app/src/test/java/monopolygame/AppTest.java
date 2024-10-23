package monopolygame;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AppTest {
    @Test
    void 시작() {
        App app = new App();
        assertThat(app).isEqualTo(new App());
    }
}
