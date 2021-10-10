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

}
