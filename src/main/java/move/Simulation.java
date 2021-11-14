package move;

import java.util.HashMap;

public class Simulation {

    public static final HashMap<String,Grid> floor = new HashMap<>();
    private static Simulation simulation;
    private final Grid FULL_GRID;
    private Sweep sweep;

    private Simulation(){
        FULL_GRID =  new Grid(10);
    }


    public static Simulation createInstance(){
        if(simulation == null){
            simulation = new Simulation();
        }
        return simulation;
    }

    public  void createFloor(){

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

    public  String startSimulation(){
        FULL_GRID.configureSubGrids(0,3,0,4,2);
        FULL_GRID.configureSubGrids(5,10,0,4,2);
        FULL_GRID.configureSubGrids(5,9,7,9,3);
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("\n"+FULL_GRID.printClean());
        //Sweep sweep = new Sweep(0,9,FULL_GRID);
//        sweep.cleanArea(0,3,5,9);
//        stringBuilder.append(FULL_GRID.printClean());
        System.out.println(sweep.getBattery().getBatteryPercentage()+"");
        System.out.println(sweep.dirtSensor.Capacity+"");
//        sweep.charge();
//        sweep.cleanArea(4,5,2,9);
//        sweep.cleanArea(0,3,4,4);
//        sweep.cleanArea(0,3,0,2);
//        sweep.cleanArea(0,1,3,3);
//        sweep.cleanArea(2,3,3,3);
//        stringBuilder.append(FULL_GRID.printClean());
//        System.out.println(sweep.getBattery().getBatteryPercentage()+"");
//        System.out.println(sweep.dirtSensor.Capacity+"");
//        sweep.charge();
//        sweep.cleanArea(6,7,1,2);
//        stringBuilder.append(FULL_GRID.printClean());
//        System.out.println(sweep.getBattery().getBatteryPercentage()+"");
//        System.out.println(sweep.dirtSensor.Capacity+"");
//        sweep.cleanArea(6,9,3,9);
//        stringBuilder.append(FULL_GRID.printClean());
//        System.out.println(sweep.getBattery().getBatteryPercentage()+"");
//        System.out.println(sweep.dirtSensor.Capacity+"");
//        sweep.cleanArea(4,7,0,0);
//        stringBuilder.append(FULL_GRID.printClean());
//        sweep.cleanArea(8,9,0,2);
//        stringBuilder.append(FULL_GRID.printClean());
//        System.out.println(sweep.getBattery().getBatteryPercentage()+"");
//        System.out.println(sweep.dirtSensor.Capacity+"");
//        sweep.cleanArea(4,5,1,1);
//        stringBuilder.append(FULL_GRID.printClean());
//        sweep.charge();

        return stringBuilder.toString();

    }

    private  void connect(Grid grid, Grid grid1) {
        grid.addConnection(grid1);
        grid1.addConnection(grid);
    }


    public  Grid createStructure(int x,int y){
        Grid g = new Grid(x,y);
        g.printGrid();
        System.out.println("---------------------");
        return g;
    }

    public void addSweep(Sweep sweep){
        this.sweep = sweep;
    }

    public Grid getGrid(){
        return FULL_GRID;
    }

    public String cleanAreaOne(){
        System.out.println("AreaOne");
        StringBuilder stringBuilder = new StringBuilder("");
        sweep.cleanArea(0,3,5,9);
        stringBuilder.append(FULL_GRID.printClean());
        return stringBuilder.toString();
    }

    public String cleanAreaTwo(){
        System.out.println("AreaTwo");
        StringBuilder stringBuilder = new StringBuilder("");
        sweep.cleanArea(4,5,2,9);
        sweep.cleanArea(0,3,4,4);
        sweep.cleanArea(0,3,0,2);
        sweep.cleanArea(0,1,3,3);
        sweep.cleanArea(2,3,3,3);
        sweep.cleanArea(6,7,1,2);
        sweep.cleanArea(8,9,0,2);
        stringBuilder.append("\n"+FULL_GRID.printClean());
        return stringBuilder.toString();
    }

    public String cleanAreaThree(){
        System.out.println("AreaThree");
        StringBuilder stringBuilder = new StringBuilder("");
        sweep.cleanArea(6,9,3,9);
        sweep.cleanArea(6,9,9,9);
        sweep.cleanArea(4,7,0,0);
        stringBuilder.append("\n"+FULL_GRID.printClean());
        return stringBuilder.toString();
    }

    public String cleanAreaFour(){
        System.out.println("AreaFour");
        StringBuilder stringBuilder = new StringBuilder("");
        sweep.cleanArea(8,9,0,2);
        sweep.cleanArea(4,5,1,1);
        stringBuilder.append("\n"+FULL_GRID.printClean());
        return stringBuilder.toString()+" \n --FLOOR FULLY CLEANED-- \n";
    }

}
