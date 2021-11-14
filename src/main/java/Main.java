import Barriers.Floor;
import ChargingStation.*;
import move.*;
import schedule.Schedule;
import ChargingStation.ChargingStation;
import Power.OnOffButton;
import battery.*;
import ChargingStation.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import DirtCapacity.*;
import GUI.*;



public class Main {

    public static void main(String[] args) throws Exception {

    //   Simulation.createFloor();
        Simulation sim = Simulation.createInstance();
        sim.startSimulation();

//     Grid grid = new Grid(4,4);
//     grid.printGrid();
//
//        Grid grid = new Grid(10);
//        grid.printGrid();
//       // grid.printGrid();
//        grid.configureSubGrids(0,3,0,4,2);
////        System.out.println();
//        grid.printClean();
//        grid.configureSubGrids(5,10,0,4,2);
//        grid.printClean();
//        grid.configureSubGrids(5,9,7,9,3);
//        grid.printClean();
//
//        Tile tDoor1 = grid.getSpecificTile(0,2);
//        tDoor1.creatDoor();
//        Tile tDoor2 = grid.getSpecificTile(3,2);
//        tDoor2.creatDoor();
//        Tile tDoor3 = grid.getSpecificTile(3,3);
//        tDoor3.creatDoor();
//        Tile tDoor4 = grid.getSpecificTile(1,5);
//        tDoor4.creatDoor();
//        Tile tDoor5 = grid.getSpecificTile(4,1);
//        tDoor5.creatDoor();
//        Tile tDoor6 = grid.getSpecificTile(6,1);
//        tDoor6.creatDoor();
//        Tile tDoor7 = grid.getSpecificTile(6,2);
//        tDoor7.creatDoor();
//        Tile tDoor8 = grid.getSpecificTile(8,1);
//        tDoor8.creatDoor();
//
//        System.out.println(grid.getSpecificTile(0,2).toString());
//        System.out.println(grid.getSpecificTile(3,2).toString());
//        System.out.println(grid.getSpecificTile(3,3).toString());
//        System.out.println(grid.getSpecificTile(1,5).toString());
//        System.out.println(grid.getSpecificTile(4,1).toString());
//        System.out.println(grid.getSpecificTile(6,1).toString());
//        System.out.println(grid.getSpecificTile(6,2).toString());
//        System.out.println(grid.getSpecificTile(8,1).toString());
//
//
//        grid.initEdges();
//        grid.castEdges();
//        System.out.println(grid.getGridHead().getRight().getDown().edges.toString());
//        ShortestPath  shortestPath = new ShortestPath();
//        shortestPath.computePaths(grid.getGridHead().getVertex());
//        Vertex I = grid.getSpecificTile(3,2).getVertex();
//        double minI = I.minDistance;
//        double currentCharge = 100;
//        ArrayList<Vertex> path;
//        if(minI == currentCharge){
//            path = (ArrayList<Vertex>) shortestPath.getShortestPathTo(I);
//            System.out.println("Path: " + path);
//        }else {
//            path = (ArrayList<Vertex>) shortestPath.getShortestPathTo(I);
//            System.out.println("Path: " + path);
//        }
//        System.out.println(grid.getSpecificTile(5,5).toString());




//
//        grid.printRow(7);
//        grid.initEdges();
//        grid.castEdges();
//        System.out.println(grid.getGridHead().getRight().getDown().edges.toString());
//        ShortestPath  shortestPath = new ShortestPath();
//        shortestPath.computePaths(grid.getGridHead().getVertex());
//        Vertex I = grid.getSpecificTile(3,3).getVertex();
//
//        double minI = I.minDistance;
//        double currentCharge = 100;
//        ArrayList<Vertex> path;
//        if(minI == currentCharge){
//            path = (ArrayList<Vertex>) shortestPath.getShortestPathTo(I);
//            System.out.println("Path: " + path);
//        }else {
//            path = (ArrayList<Vertex>) shortestPath.getShortestPathTo(I);
//            System.out.println("Path: " + path);
//        }
//
//        Sweep sweepObj = new Sweep(0,0,grid);
//        Grid.clean(sweepObj,path);
//
//
//        System.out.println("------------CHARGING STATION------------");
//        ChargingStation cs = new ChargingStation();
//        cs.setCurrentLocation(grid.getX(),grid.getY()); //current location of Sweep as set in grid addSweep 3,3
//        System.out.println("Sweep is located at point: " + cs.getCurrentLocation());
//        // cs.setChargingStationLocation(grid); //sets the location of the charging station on the Grid -i.e position 0,0
//
//
//        //DirtCapacityOfSweeper
//        DirtCapacityOfSweeper info= new DirtCapacityOfSweeper();
//        info.dirtCapacity();
//
//        //DirtSensor
//        DirtSensor war= new DirtSensor();
//        war.FullBag();
//        //war.EmptyBag();
//
//        //schedule
//        JLabel label = new JLabel("Selected Date:");
//        final JTextField text = new JTextField(20);
//        JButton b = new JButton("popup");
//        JPanel p = new JPanel();
//        p.add(label);
//        p.add(text);
//        p.add(b);
//        final JFrame f = new JFrame();
//        f.getContentPane().add(p);
//        f.pack();
//        f.setVisible(true);
//        b.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent ae) {
//                text.setText(new Schedule(f).setPickedDate());
//            }
//        });
//
//        //GUI
//        JFrame loginScreenFrame = new JFrame("Login");
//        User user = new User();
//        LoginScreen gui = new LoginScreen(loginScreenFrame, sweepObj,user );
//        gui.createLoginScreen();
//
//        //Battery
//        Battery lowWar= new Battery();
//        lowWar.LowBatteryWar();
//        lowWar.fullBatteryInfo();


        // SweepMain Layout
        //SweepMainPage.createPage();




    }
}