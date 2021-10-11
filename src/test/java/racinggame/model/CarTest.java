package racinggame.model;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @DisplayName("차에 이름을 부여하는 기능 검증")
    @ValueSource(strings = {"lsm", "fox"})
    @ParameterizedTest
    void carNameInputTest(String name) {
        Car car = new Car(name);

        assertThat(car.getName()).isEqualTo(name);
    }

    @DisplayName("입력값이 4이상이면 전진하는 기능 검증")
    @Test
    void carGo() {
        Car car = new Car("");
        assertThat(car.getDistance()).isEqualTo(0);
        car.goOrStop(MOVING_FORWARD);
        assertThat(car.getDistance()).isEqualTo(1);

        car = new Car("");
        assertThat(car.getDistance()).isEqualTo(0);
        car.goOrStop(MOVING_FORWARD);
        assertThat(car.getDistance()).isEqualTo(1);

    }

    @DisplayName("입력값이 3이하면 멈추는 기능 검증")
    @Test
    void carStop() {
        Car car = new Car("");
        assertThat(car.getDistance()).isEqualTo(0);
        car.goOrStop(STOP);
        assertThat(car.getDistance()).isEqualTo(0);

        car = new Car("");
        assertThat(car.getDistance()).isEqualTo(0);
        car.goOrStop(STOP);
        assertThat(car.getDistance()).isEqualTo(0);

    }

    @DisplayName("차의 실행 결과를 출력하는 기능")
    @Test
    void ExecutionResult() {
        Car car = new Car("lsm");
        car.goOrStop(MOVING_FORWARD);
        car.goOrStop(MOVING_FORWARD);
        car.goOrStop(MOVING_FORWARD);
        assertThat(car.toString()).isEqualTo("lsm:---");

        car = new Car("avant");
        car.goOrStop(MOVING_FORWARD);
        car.goOrStop(MOVING_FORWARD);
        assertThat(car.toString()).isEqualTo("avant:--");
    }

}
