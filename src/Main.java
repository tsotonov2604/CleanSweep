
import ChargingStation.*;
import move.*;
import move.ShortestPath;
import ChargingStation.ChargingStation;
import Power.OnOffButton;
import battery.Battery;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import DirtCapacity.DirtSensor;
import DirtCapacity.DirtCapacityOfSweeper;

public class Main {
    public static void main(String[] args) throws Exception {
       
        //OnOffButton
        OnOffButton OnOff = new OnOffButton();
        OnOff.setTitle("Turning a device On/Off");
        OnOff.setLayout(new FlowLayout());
        OnOff.setJToggleButton();
        OnOff.setAction();
        OnOff.setSize(300, 200);
        OnOff.setVisible(true);
        OnOff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //DirtCapacityOfSweeper
        DirtCapacityOfSweeper info= new DirtCapacityOfSweeper();
        info.dirtCapacity();

        //DirtSensor
        DirtSensor war= new DirtSensor();
        war.FullBag();
        war.EmptyBag();
      
      
      // Movement
      int mat[][] = 
      {{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
      { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
      { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
      { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
      { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
      { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
      { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
      { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
      { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};   
        Grid grid = new Grid(mat);
        Tile sweep = grid.addSweep(3, 3);
        ShortestPath.Point source = new ShortestPath.Point(3, 3);
        ShortestPath.Point dest = new ShortestPath.Point(0, 0);
        grid.printGrid();
        System.out.println("------------Adding Sweep--------");
        int dist = ShortestPath.BFS(mat, source, dest);
 
        if (dist != -1){
            System.out.println("Shortest Path is " + dist);}
        else{
            System.out.println("Shortest Path doesn't exist");
        }
 
        //System.out.println("---------Moving Up-----------");
        //sweep = sweep.moveUp();
        //grid.printGrid();
       //// Thread.sleep(1000);
        //System.out.println("----------Moving Right----------");
        //sweep = sweep.moveRight();
        //grid.printGrid();
        ////Thread.sleep(1000);
        //System.out.println("------------Moving Down--------");
        //sweep = sweep.moveDown();
        //grid.printGrid();
        //System.out.println("------------Moving Left--------");
        //sweep = sweep.moveLeft();
        //grid.printGrid();

     
        System.out.println("BATTERY");

        Battery battery = new Battery();
        battery.CurrentBatteryPercent = 10;
        System.out.println(battery.getCurrentBatteryPercent()+" Battery Percentage");

        System.out.println("------------CHARGING STATION------------");
        ChargingStation cs = new ChargingStation();
        cs.setCurrentLocation(grid.getX(),grid.getY()); //current location of Sweep as set in grid addSweep 3,3
        System.out.println("Sweep is located at point: " + cs.getCurrentLocation());
        cs.setChargingStationLocation(grid); //sets the location of the charging station on the Grid -i.e position 0,0
        if(battery.LowBattery()){
            cs.navigateToChargingStation(grid,sweep);
            cs.charge();
            grid.printGrid();
        }
//
        //System.out.println("Shortest path");
        //Vertex A = new Vertex("A"); 
        //Vertex B = new Vertex("B");
        //Vertex C = new Vertex("C");
        //Vertex D = new Vertex("D");
        //Vertex E = new Vertex("E");
        //Vertex F = new Vertex("F");
        //Vertex G = new Vertex("G");
        //Vertex H = new Vertex("H");
        //Vertex I = new Vertex("I");
//
        //A.adjacencies = new Edge[]{ new Edge(B, 1) ,new Edge(D, 1) };
        //B.adjacencies = new Edge[]{ new Edge(A, 1), new Edge(E,1),new Edge(C,1)};
        //C.adjacencies = new Edge[]{ new Edge(B, 1),new Edge(F, 1)   };
        //D.adjacencies = new Edge[]{ new Edge(A, 1),new Edge(E, 1),new Edge(G, 1)   };
        //E.adjacencies = new Edge[]{ new Edge(B, 1),new Edge(D, 1),new Edge(F, 1),new Edge(H, 1) };
        //F.adjacencies = new Edge[]{ new Edge(C, 1),new Edge(E, 1),new Edge(I, 1)  };
        //G.adjacencies = new Edge[]{ new Edge(D, 1),new Edge(H, 1)  };
        //H.adjacencies = new Edge[]{ new Edge(G, 1),new Edge(E, 1),new Edge(I, 1) };
        //I.adjacencies = new Edge[]{ new Edge(F, 1),new Edge(H, 1) };
        //ShortestPath shortestPath = new ShortestPath();
        //shortestPath.computePaths(A);
        //double minI = I.minDistance;
        //double currentCharge = 100;
        //if(minI == currentCharge){
        //    ArrayList<Vertex> path = (ArrayList<Vertex>) shortestPath.getShortestPathTo(I);
        //    System.out.println("Path: " + path);
        //}else{
        //    ArrayList<Vertex> path = (ArrayList<Vertex>)  shortestPath.getShortestPathTo(I);
        //    System.out.println("Path: " + path);
        //}
        //

    }
}
