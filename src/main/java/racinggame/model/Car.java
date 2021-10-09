package racinggame.model;

public class Car {

    private String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public void go() {
        distance++;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

}
