package barriers;

public class Floor implements Environment {
    private FloorType floorType;

    public Floor() {

        this.floorType = floorType;
    }

    public FloorType getFloorType() {
        return floorType;
    }

    public boolean isBlocking() {
        return false;
    }

    public boolean isFloor() {
        return true;
    }

}
