package barriers;

public class Stairs implements Environment{

    public boolean isBlocking() {
        return true;
    }

    public boolean isFloor() {
        return false;
    }
}
