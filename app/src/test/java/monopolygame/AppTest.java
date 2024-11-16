package monopolygame;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class AppTest {
    @Test
    void 시작() {
        App app = new App();
        assertThat(app).isEqualTo(new App());
    }
}
