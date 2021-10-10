package racinggame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    @DisplayName("자동차들을 받는 클래스 생성 검증")
    @Test
    void createCarList() {

        List<Car> carList = new ArrayList<Car>(Arrays.asList(new Car("lsm"),new Car("test")));
        Cars cars = new Cars(carList);
        assertThat(cars.getSize()).isEqualTo(2);

        carList = new ArrayList<Car>(Arrays.asList(new Car("lsm"),new Car("test"),new Car("fox")));
        cars = new Cars(carList);
        assertThat(cars.getSize()).isEqualTo(3);

    }
}
