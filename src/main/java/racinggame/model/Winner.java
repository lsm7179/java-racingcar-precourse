package racinggame.model;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private List<Car> winnerList;

    public Winner(Cars cars) {
        winnerList = new ArrayList<>();
        selectWinner(cars);
    }

    private void selectWinner(Cars cars) {
        int maxDistance = cars.getMaxDistance();
        for (Car car : cars.getCarList()) {
            addWinner(maxDistance, car);
        }
    }

    private void addWinner(int maxDistance, Car car) {
        if (car.isMaxPosition(maxDistance)) {
            winnerList.add(car);
        }
    }

    public int getSize() {
        return winnerList.size();
    }

}
