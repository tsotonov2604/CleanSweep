package move;

import battery.Battery;
import DirtCapacity.DirtCapacityOfSweeper;

public class Sweep {
    Battery battery;
    Grid pGrid;
    int x,y;
    Tile tile;

    public Sweep(int x,int y, Grid grid) {
        this.battery = new Battery();
        this.pGrid = grid;
        this.x = x;
        this.y = y;
        //this.tile = pGrid.getSpecificTile(x,y);
        //this.tile.parentGrid = pGrid;
    }

    public void clean(Tile tile){
        this.battery.decreaseBattery(tile.getDirt());
        tile.setDirt(0);
        DirtCapacityOfSweeper.dirtCapacity();
    }


    private void setLocation(int x,int y){
        this.x=x;
        this.y=y;
        this.clean(pGrid.getSpecificTile(x,y));
        //this.tile.setDirt(0);
        //this.tile = this.tile.moveTo(x,y);
    }

    public void moveTo(int x,int y){
        setLocation(x,y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Battery getBattery() {
        return battery;
    }

    public Grid getpGrid() {
        return pGrid;
    }

    public void setpGrid(Grid pGrid) {
        this.pGrid = pGrid;
    }


}
