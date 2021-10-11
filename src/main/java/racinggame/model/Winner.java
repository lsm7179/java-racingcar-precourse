package racinggame.model;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private List<String> winnerList;

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
            winnerList.add(car.getName());
        }
    }

    public int getSize() {
        return winnerList.size();
    }

    @Override
    public String toString() {
        String result = "최종 우승자는 " + String.join(",", winnerList) + " 입니다.";
        return result;
    }

}
