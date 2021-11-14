package move;

import java.util.ArrayList;
import java.util.HashMap;

public class FloorPlan {

    public enum StructureType{
        GuestBedroom,
        Closet,
        MasterBedroom,
        Bathroom,
        Hallway
    }


    private final HashMap<StructureType,Tile> structure = new HashMap<>();


    public void createGrid(int x, int y, String name){
//        Grid g1 = new Grid(x,y);
//        g1.setName(name);
//        structure.add(g1);
//        return g1;
    }


}
