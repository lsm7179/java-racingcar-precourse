package racinggame.model;

public class Car {

    private String name;
    private int distance = 0;
    private static final int MOVING_FORWARD = 4;

    public Car(String name) {
        this.name = name;
    }

    private void go() {
        distance++;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void goOrStop(int number) {
        if(number>= MOVING_FORWARD){
            this.go();
        }
    }

}
