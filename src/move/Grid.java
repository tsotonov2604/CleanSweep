package move;

import ChargingStation.Edge;
import ChargingStation.Vertex;
import battery.Battery;

import java.util.ArrayList;

public class Grid {

    private Tile gridHead;
    private Tile sweep;
    private Tile currentTile;
    //private Sweep sweep;
    private int xAxis,yAxis, maxAxis = 0;
    private ArrayList<Tile> rowsHeads = new ArrayList<>();
    private static Battery battery = new Battery();

    public Grid(int size) { // right now only works with squares

        this.maxAxis = size;
        int colIndex = 0;
        int rowIndex = 0;
        gridHead = new Tile("Floor",1,rowIndex,colIndex);
        rowsHeads.add(gridHead);
        currentTile = gridHead;
        Tile column = gridHead;
        Tile row = gridHead;
        //rowIndex++;
        colIndex++;

        for(int i=0;i<size-1;i++){ // got rid of the temp pointer more efficient like that
            Tile newTile = new Tile("Floor",1,rowIndex, colIndex);
            column.setRight(newTile);
            column.getRight().setLeft(column);
            column = column.getRight();
            colIndex++;
        }
        rowIndex++;


        colIndex = 0;
        for( int i =0;i<size-1;i++) { // no need for a temp pointer since all has links
            Tile newTile = new Tile("Floor",1,rowIndex,colIndex++);
            row.setDown(newTile);
            //row.edges.add(new Edge(newTile.getVertex(),1.0));
            rowsHeads.add(newTile);
            row.getDown().setUp(row);
            row = row.getDown();
            column = row;
            for(int j=0;j<size-1;j++) {

                Tile newTilee = new Tile("Floor", 1, rowIndex, colIndex);
                column.setRight(newTilee);
                column.getRight().setLeft(column);
                column.getRight().setUp(column.getUp().getRight());
                column.getRight().getUp().setDown(column.getRight());
                column = column.getRight();
                colIndex++;
            }
            colIndex=0;
            rowIndex++;
        }


    }


    public void printGrid(){

        Tile temp = gridHead;
        Tile currentRow = gridHead;

        while(currentRow != null) {
            while (temp != null) {
                System.out.print(temp.getX() + ""+temp.getY()+ " : ");
                temp = temp.getRight();
            }
            System.out.println();
            temp = currentRow.getDown();
            currentRow = temp;
        }
    }

    public void printClean(){
        Tile temp = gridHead;
        Tile currentRow = gridHead;

        while(currentRow != null) {
            while (temp != null) {
                System.out.print(temp.getDirt());
                temp = temp.getRight();
            }
            System.out.println();
            temp = currentRow.getDown();
            currentRow = temp;
        }
    }


    public Tile addSweep(int x,int y) {

        Tile currentNode = gridHead;

        for(int i=0;i<x;i++) {
            currentNode = currentNode.getRight();
        }
        for(int i=0;i<y;i++) {
            currentNode = currentNode.getDown();
        }

        currentNode.setData("Sweep");
        currentNode.setDirt(0);
        printGrid();
        sweep = currentNode;
        return sweep;
    }



    public Tile getGridHead() {
        return gridHead;
    }

    public void setGridHead(Tile gridHead) {
        this.gridHead = gridHead;
    }

    public int getMaxAxis() {
        return maxAxis;
    }

    public void setMaxAxis(int maxAxis) {
        this.maxAxis = maxAxis;
    }

    public ArrayList<Tile> getRowsHeads() {
        return rowsHeads;
    }

    public void printRow(int x){
        Tile row = rowsHeads.get(x);
        for(int i=0;i<maxAxis;i++){
           System.out.print(row.getX()+""+row.getY()+" : ");
           row = row.getRight();
        }

        System.out.println();
    }

    public Tile getSpecificTile(int x, int y){
        Tile returnTile = rowsHeads.get(x);
        for(int i = 0;i<y;i++){
            returnTile = returnTile.getRight();
        }
        System.out.println(returnTile.toString());
        return returnTile;
    }

    public void initEdges(){

        Tile current = gridHead;
        Tile temp = gridHead;


        while(current != null) {

            while (temp != null) {

                if (temp.getRight() != null) {
                    temp.edges.add(new Edge(temp.getRight().getVertex(), 1.0, Edge.Direction.RIGHT));
                }

                if (temp.getUp() != null) {
                    temp.edges.add(new Edge(temp.getUp().getVertex(), 1.0, Edge.Direction.UP));
                }

                if (temp.getDown() != null) {
                    temp.edges.add(new Edge(temp.getDown().getVertex(), 1.0, Edge.Direction.DOWN));
                }

                if (temp.getLeft() != null) {
                    temp.edges.add(new Edge(temp.getLeft().getVertex(), 1.0, Edge.Direction.LEFT));
                }

                temp = temp.getRight();

            }
            temp = current.getDown();
            current = temp;
        }



        System.out.println("DONE W/ EDGES!!");


    }

    public void castEdges(){

        Tile current = gridHead;
        Tile temp = gridHead;


        while(current != null) {

            while (temp != null) {
                temp.initAdjacencies();
                temp = temp.getRight();
            }
            temp = current.getDown();
            current = temp;
        }

    }

    public static void clean(Sweep sweep , ArrayList<Vertex> path){


        try {
            ArrayList<Tile> tilePath = convertPath(path, sweep.getpGrid());
            System.out.println(tilePath);
            for (Tile t : tilePath) {
                System.out.println("Moving to "+t.getX()+" : "+t.getY());
                sweep.moveTo(t.getX(), t.getY());
                System.out.println("Sweep At "+sweep.getX()+" "+sweep.getY());
            }
            sweep.pGrid.printClean();
            System.out.println("Battery after cleaning...");
            System.out.println(sweep.getBattery().getBatteryPercentage());
        }
        catch (Exception e){
            e.printStackTrace();
        }



    }

    private static  ArrayList<Tile> convertPath(ArrayList<Vertex> path,Grid grid) {

        ArrayList<Tile> tPaths = new ArrayList<>();
        for(Vertex v : path){
            Tile t = grid.getSpecificTile(v.x,v.y);
            tPaths.add(t);
        }

        return tPaths;
    }

}
