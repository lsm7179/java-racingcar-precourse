package racinggame.model;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @DisplayName("차가 전진하는 기능 검증")
    @Test
    void go() {
        Car car = new Car();
        car.go();

        assertThat(car.getDistance()).isEqualTo(1);
    }
}
