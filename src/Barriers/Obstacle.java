package Barriers;

public class Obstacle implements Environment{

    public boolean isBlocking() {
        return true;
    }

    public boolean isFloor() {
        return false;
    }
}
