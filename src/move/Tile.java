package move;

public class Tile implements IMoveHelper {

    String data; // will be changed to enums or make other subclasses
    private int dirt;
    private Tile up,down,right,left;

    public Tile(String data, int dirt) {
        this.data = data;
        this.dirt = dirt;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getDirt() {
        return dirt;
    }

    public void setDirt(int dirt) {
        this.dirt = dirt;
    }

    public Tile getUp() {
        return up;
    }

    public void setUp(Tile up) {
        this.up = up;
    }

    public Tile getDown() {
        return down;
    }

    public void setDown(Tile down) {
        this.down = down;
    }

    public Tile getRight() {
        return right;
    }

    public void setRight(Tile right) {
        this.right = right;
    }

    public Tile getLeft() {
        return left;
    }

    public void setLeft(Tile left) {
        this.left = left;
    }

    @Override
    public Tile moveUp() {
        this.getUp().setDirt(0);
        this.setDirt(1);
        return this.getUp();
    }

    @Override
    public Tile moveDown() {
        this.getDown().setDirt(0);
        this.setDirt(1);
        return this.getDown();
    }

    @Override
    public Tile moveLeft() {
        this.getLeft().setDirt(0);
        this.setDirt(1);
        return this.getLeft();
    }

    @Override
    public Tile moveRight() {
        this.getRight().setDirt(0);
        this.setDirt(1);
        return this.getRight();
    }
}
