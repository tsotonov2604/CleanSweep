package move;

import java.util.HashMap;

public class Simulation {

    public static final HashMap<String,Grid> floor = new HashMap<>();
    public static final Grid FULL_GRID = new Grid(10);



    public static void createFloor(){




//        floor.put(FloorPlan.StructureType.Closet+"1",createStructure(2,0));
//        floor.put(FloorPlan.StructureType.Closet+"2",createStructure(2,0));
//        floor.put(FloorPlan.StructureType.Closet+"3",createStructure(4,0));
//        floor.put(FloorPlan.StructureType.Closet+"4",createStructure(2,3));
//        floor.put(FloorPlan.StructureType.Hallway+"",createStructure(2,9));
//        floor.put(FloorPlan.StructureType.GuestBedroom+"B",createStructure(4,3));
//        floor.put(FloorPlan.StructureType.GuestBedroom+"A",createStructure(4,5));
//        floor.put(FloorPlan.StructureType.Bathroom+"1",createStructure(4,0));
//        floor.put(FloorPlan.StructureType.Bathroom+"2",createStructure(2,0));
//        floor.put(FloorPlan.StructureType.MasterBedroom+"1",createStructure(2,2));
//        floor.put(FloorPlan.StructureType.MasterBedroom+"2",createStructure(4,7));
//
//        connect(floor.get(FloorPlan.StructureType.GuestBedroom+"B"),floor.get(FloorPlan.StructureType.Closet+"1"));
//        connect(floor.get(FloorPlan.StructureType.GuestBedroom+"B"),floor.get(FloorPlan.StructureType.Hallway+""));
//        connect(floor.get(FloorPlan.StructureType.Hallway+""),floor.get(FloorPlan.StructureType.Bathroom+"2"));
//        connect(floor.get(FloorPlan.StructureType.Hallway+""),floor.get(FloorPlan.StructureType.MasterBedroom+"1"));
//        connect(floor.get(FloorPlan.StructureType.MasterBedroom+"1"),floor.get(FloorPlan.StructureType.MasterBedroom+"2"));
//        connect(floor.get(FloorPlan.StructureType.MasterBedroom+"1"),floor.get(FloorPlan.StructureType.Closet+"4"));
//        connect(floor.get(FloorPlan.StructureType.MasterBedroom+"1"),floor.get(FloorPlan.StructureType.Bathroom+"1"));
//        connect(floor.get(FloorPlan.StructureType.Hallway+""),floor.get(FloorPlan.StructureType.GuestBedroom+"A"));
//        connect(floor.get(FloorPlan.StructureType.GuestBedroom+"A"),floor.get(FloorPlan.StructureType.Closet+"3"));
//        connect(floor.get(FloorPlan.StructureType.Hallway+""),floor.get(FloorPlan.StructureType.Closet+"2"));
//
//
//        System.out.println(floor.get(FloorPlan.StructureType.GuestBedroom+"B").getConnections());
//        System.out.println(floor.get(FloorPlan.StructureType.Hallway+"").getConnections());


    }

    public static void startSimulation(){
        FULL_GRID.configureSubGrids(0,3,0,4,2);
        FULL_GRID.configureSubGrids(5,10,0,4,2);
        FULL_GRID.configureSubGrids(5,9,7,9,3);
        FULL_GRID.printClean();
        Sweep sweep = new Sweep(0,9,FULL_GRID);
        sweep.cleanArea(0,3,5,9);
        FULL_GRID.printClean();
        System.out.println(sweep.getBattery().getBatteryPercentage()+"");
    }

    private static void connect(Grid grid, Grid grid1) {
        grid.addConnection(grid1);
        grid1.addConnection(grid);
    }


    public static Grid createStructure(int x,int y){
        Grid g = new Grid(x,y);
        g.printGrid();
        System.out.println("---------------------");
        return g;
    }


}
