import ChargingStation.*;
import move.Grid;
import move.Tile;

public class Main {
    public static void main(String[] args) throws Exception {
       // System.out.println("Hello, World!");
      //  ChargingStation cs = new ChargingStation();
       // cs.charge();

        Grid grid = new Grid(10);
        grid.printGrid();
        System.out.println("------------Adding Sweep--------");
        Tile sweep = grid.addSweep(3, 3);
        System.out.println("---------Moving Up-----------");
        sweep = sweep.moveUp();
        grid.printGrid();
        System.out.println("----------Moving Right----------");
        sweep = sweep.moveRight();
        grid.printGrid();
        System.out.println("------------Moving Down--------");
        sweep = sweep.moveDown();
        grid.printGrid();

    }
}
