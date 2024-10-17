package domain.square;

import domain.component.property.Property;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PropertyTest {
    @Test
    @DisplayName("권리증 생성 테스트")
    void 생성() {
        Property property = new Property(1, "서울");
        assertThat(property).isEqualTo(new Property(1, "서울"));
    }

    @Test
    @DisplayName("땅 가격 반환 테스트")
    void getPrice() {
        Property property = new Property(1, "서울", 100_000);
        assertThat(property.getPrice()).isEqualTo(100_000);
    }
}