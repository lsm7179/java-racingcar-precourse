package racinggame.model;

import java.util.List;

public class Cars {

    private List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public int getSize() {
        return carList.size();
    }

    public void move() {
        for (Car car : carList) {
            car.goOrStop(RandomNumber.makeNumber());
        }
    }

    public int getMaxDistance() {
        int result = 0;
        for (Car car : carList) {
            result = Integer.max(car.getDistance(), result);
        }
        return result;
    }

    public List<Car> getCarList() {
        return carList;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        for (Car car : carList) {
            result.append(car.toString() + "\n");
        }
        return result.toString();
    }

}
