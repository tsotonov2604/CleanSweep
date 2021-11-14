package move;

import battery.Battery;

import java.util.UUID;

public class Sweep {
    String serialNumber;
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

    public Sweep(){
        serialNumber = UUID.randomUUID().toString();
    }

    public void clean(Tile tile){
        this.battery.decreaseBattery(tile.getDirt());
        tile.setDirt(0);
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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void cleanArea(int startX,int endX,int startY,int endY){

        System.out.println("StartX : "+startX+", EndX : "+endX);
        System.out.println("StartY : "+startY+", EndY : "+endY);
        Tile startTile = pGrid.getSpecificTile(startY,startX);

        for(int i=startY;i<=endY;i++) {
            if(!battery.LowBattery()) {
                cleanRow(startTile, startX, endX);
                startTile = startTile.getDown();
            }
            else {
                charge();
            }
        }

    }

    private void charge() {

    }

    private void cleanRow(Tile startTile,int startX, int endX) {
        for(int i=startX;i<=endX;i++){
            clean(startTile);
            startTile=startTile.getRight();
        }
    }


}
