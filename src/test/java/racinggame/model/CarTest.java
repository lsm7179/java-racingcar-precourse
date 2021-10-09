package racinggame.model;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @DisplayName("차가 전진하는 기능 검증")
    @Test
    void go() {
        Car car = new Car("");
        car.go();

        assertThat(car.getDistance()).isEqualTo(1);
    }

    @DisplayName("차에 이름을 부여하는 기능 검증")
    @ValueSource(strings = {"lsm","fox"})
    @ParameterizedTest
    void carNameInputTest(String name) {
        Car car = new Car(name);

        assertThat(car.getName()).isEqualTo(name);
    }

    @DisplayName("입력값이 4이상이면 전진하는 기능 검증")
    @Test
    void name() {
        Car car = new Car("");
        assertThat(car.getDistance()).isEqualTo(0);
        car.goOrStop(4);
        assertThat(car.getDistance()).isEqualTo(1);

        car = new Car("");
        assertThat(car.getDistance()).isEqualTo(0);
        car.goOrStop(9);
        assertThat(car.getDistance()).isEqualTo(1);


    }
}
