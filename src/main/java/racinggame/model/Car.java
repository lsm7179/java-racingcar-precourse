package racinggame.model;

public class Car {

    private String name;
    private int distance = 0;
    private static final int MOVING_FORWARD = 4;
    private static final String DISTANCE_EXPRESSION = "-";

    public Car(String name) {
        this.name = name;
    }

    private void go() {
        distance++;
    }

    public void goOrStop(int number) {
        if (number >= MOVING_FORWARD) {
            this.go();
        }
    }

    public boolean isMaxPosition(int maxDistance) {
        return distance == maxDistance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return name + " : " + getDistanceReport();
    }

    private String getDistanceReport() {
        StringBuffer distanceResult = new StringBuffer();
        for (int i = 0; i < distance; i++) {
            distanceResult.append(DISTANCE_EXPRESSION);
        }
        return distanceResult.toString();
    }

}
