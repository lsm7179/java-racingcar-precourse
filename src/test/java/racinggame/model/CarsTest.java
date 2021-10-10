package racinggame.model;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class CarsTest {

    private final int MOVING_FORWARD = 4;
    private final int STOP = 3;
    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(Arrays.asList("lsm", "test"));
    }

    @DisplayName("자동차들을 받는 클래스 생성 검증")
    @Test
    void createCarList() {
        assertThat(cars.getSize()).isEqualTo(2);
    }

    @DisplayName("자동차들을 4이상에서 전진하는 기능 검증")
    @RepeatedTest(100)
    void moveCars() {
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
