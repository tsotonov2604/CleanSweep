
import ChargingStation.*;
import move.Grid;
import move.Sweep;
import move.Tile;
import ChargingStation.ChargingStation;
import Power.OnOffButton;
import battery.*;

import ChargingStation.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import DirtCapacity.*;



public class Main {

    public static void main(String[] args) throws Exception {

        Grid grid = new Grid(10);
        grid.printGrid();

        grid.printRow(7);
        grid.initEdges();
        grid.castEdges();
        System.out.println(grid.getGridHead().getRight().getDown().edges.toString());
        ShortestPath  shortestPath = new ShortestPath();
        shortestPath.computePaths(grid.getGridHead().getVertex());
        Vertex I = grid.getSpecificTile(3,3).getVertex();

        double minI = I.minDistance;
        double currentCharge = 100;
        ArrayList<Vertex> path;
        if(minI == currentCharge){
            path = (ArrayList<Vertex>) shortestPath.getShortestPathTo(I);
            System.out.println("Path: " + path);
        }else {
            path = (ArrayList<Vertex>) shortestPath.getShortestPathTo(I);
            System.out.println("Path: " + path);
        }

        Sweep sweepObj = new Sweep(0,0,grid);
        Grid.clean(sweepObj,path);

//        System.out.println("------------Adding Sweep--------");
//        Tile sweep = grid.addSweep(3, 3);
//        System.out.println("---------Moving Up-----------");
//        sweep = sweep.moveUp();
//        grid.printGrid();
//       // Thread.sleep(1000);
//        System.out.println("----------Moving Right----------");
//        sweep = sweep.moveRight();
//        grid.printGrid();
//        //Thread.sleep(1000);
//        System.out.println("------------Moving Down--------");
//        sweep = sweep.moveDown();
//        grid.printGrid();
//        System.out.println("------------Moving Left--------");
//        sweep = sweep.moveLeft();
//        grid.printGrid();



        System.out.println("------------CHARGING STATION------------");
        ChargingStation cs = new ChargingStation();
        cs.setCurrentLocation(grid.getX(),grid.getY()); //current location of Sweep as set in grid addSweep 3,3
        System.out.println("Sweep is located at point: " + cs.getCurrentLocation());
        cs.setChargingStationLocation(grid); //sets the location of the charging station on the Grid -i.e position 0,0


    }
}
