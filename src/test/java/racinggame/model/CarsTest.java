package racinggame.model;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class CarsTest {
    private final int MOVING_FORWARD = 4;
    private final int STOP = 3;

    @DisplayName("자동차들을 받는 클래스 생성 검증")
    @Test
    void createCarList() {

        List<Car> carList = new ArrayList<>(Arrays.asList(new Car("lsm"), new Car("test")));
        Cars cars = new Cars(carList);
        assertThat(cars.getSize()).isEqualTo(2);

        carList = new ArrayList<>(Arrays.asList(new Car("lsm"), new Car("test"), new Car("fox")));
        cars = new Cars(carList);
        assertThat(cars.getSize()).isEqualTo(3);
    }

    @DisplayName("자동차들을 4이상에서 전진하는 기능 검증")
    @RepeatedTest(100)
    void moveCars() {
        List<Car> carList = new ArrayList<>(Arrays.asList(new Car("lsm"), new Car("test"), new Car("fox")));
        Cars cars = new Cars(carList);

        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(MOVING_FORWARD);
            cars.move();
            assertThat(cars.getMaxDistance()).isEqualTo(1);

            cars.move();
            assertThat(cars.getMaxDistance()).isEqualTo(2);
        }

    }

    @DisplayName("자동차들을 3이하에서 멈추는 기능 검증")
    @RepeatedTest(100)
    void stopCars() {
        List<Car> carList = new ArrayList<>(Arrays.asList(new Car("lsm"), new Car("test"), new Car("fox")));
        Cars cars = new Cars(carList);

        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(STOP);
            cars.move();
            assertThat(cars.getMaxDistance()).isEqualTo(0);

            cars.move();
            assertThat(cars.getMaxDistance()).isEqualTo(0);
        }

    }

    @DisplayName("자동차들의 실행 결과를 출력하는 기능")
    @Test
    void CarsReport() {
        List<Car> carList = new ArrayList<>(Arrays.asList(new Car("lsm"), new Car("test")));
        Cars cars = new Cars(carList);
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(MOVING_FORWARD,STOP,MOVING_FORWARD,STOP);

            cars.move();
            assertThat(cars.toString()).isEqualTo("lsm:-\ntest:\n");

            cars.move();
            assertThat(cars.toString()).isEqualTo("lsm:--\ntest:\n");
        }
    }

}
