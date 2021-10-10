package racinggame.model;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class WinnerTest {
    private final int MOVING_FORWARD = 4;
    private final int STOP = 3;
    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(Arrays.asList("lsm", "test"));
    }

    @DisplayName("우승자 고르기 검증")
    @Test
    void selectWinner() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(MOVING_FORWARD,STOP,MOVING_FORWARD,STOP);

            cars.move();
            cars.move();

            Winner winner = new Winner(cars);
            assertThat(winner.getSize()).isEqualTo(1);
        }
    }

    @DisplayName("우승자 출력")
    @Test
    void winnerReport() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(MOVING_FORWARD,STOP,STOP,MOVING_FORWARD);

            cars.move();
            Winner winner = new Winner(cars);
            assertThat(winner.toString()).isEqualTo("최종 우승자는 lsm입니다.");

            cars.move();
            winner = new Winner(cars);
            assertThat(winner.toString()).isEqualTo("최종 우승자는 lsm,test입니다.");
        }
    }

}
