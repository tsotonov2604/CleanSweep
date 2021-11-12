package move;

public interface IMoveHelper {
     Tile moveUp();
     Tile moveDown();
     Tile moveLeft();
     Tile moveRight();
     Tile moveTo(int x,int y);
}
