package racinggame.model;

public class Car {

    private String name;
    private int distance = 0;
    private final int possibleGoNumber = 4;

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

    public void goOrStop(int number) {
        if(number>=possibleGoNumber){
            this.go();
        }
    }
}
