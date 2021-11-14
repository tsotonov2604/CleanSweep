package move;

import Barriers.FloorType;
import ChargingStation.Edge;
import ChargingStation.Vertex;
import battery.Battery;

import java.util.ArrayList;

public class Grid {

    private Tile gridHead;
    private Tile sweep;
    private Tile currentTile;
    private final ArrayList<Grid> connections = new ArrayList<>();
    //private Sweep sweep;
    private int xAxis,yAxis, maxAxis = 0;
    private final ArrayList<Tile> rowsHeads = new ArrayList<>();
    private final ArrayList<Tile> columnHeads = new ArrayList<>();
    private String name;
    private static Battery battery = new Battery();
    private int x;
    private int y;
    private FloorType type;


    public Grid(int x,int y){
        this.x = x;
        this.y = y;
        int colIndex = 0;
        int rowIndex = 0;
        gridHead = new Tile("Floor",1,rowIndex,colIndex);
        colIndex++;
        //rowIndex++;
        rowsHeads.add(gridHead);
        Tile column = gridHead;
        Tile row = gridHead;

        if(y==0){
            for(int i =1;i<x;i++) {
                    //colIndex++;
                    Tile newTile = new Tile("Floor", 1, rowIndex, colIndex);
                    column.setRight(newTile);
                    column.setLeft(newTile);
                    column = column.getRight();
                    colIndex++;
            }
        } else {
            rowIndex++;
            colIndex=0;
            while(rowIndex <= y){
                Tile newTile;
                if(rowIndex != y) {
                    newTile = new Tile("Floor", 1, rowIndex, colIndex);
                    row.setDown(newTile);
                    row.getDown().setUp(row);
                }
                initializeRows(x,row);
                row = row.getDown();
                rowIndex++;
            }
        }
        constructColumnHeads();
    }

    private void initializeRows(int x, Tile rowHead) {
        for(int i=1;i<x;i++){
            Tile newTile = new Tile("Floor",1,rowHead.getX(),i);
            rowHead.setRight(newTile);
            rowHead.getRight().setLeft(rowHead);
            rowHead = rowHead.getRight();
        }
    }



    public Grid(int size) {

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

        constructColumnHeads();
    }

    private void constructColumnHeads() {
        for(int i=0;i<maxAxis;i++){
            columnHeads.add(getSpecificTile(0,i));
        }
        System.out.println(columnHeads);
    }

//    public void disconnectColumn(int y, Edge.Direction direction){
//
//        Tile column = columnHeads.get(y);
//        Tile column2 = columnHeads.get(y+1);
//        while(column != null){
//            System.out.println(column.toString());
//            switch (direction){
//                case UP: column.disconnectUp();column2.disconnectUp();break;
//                case DOWN: column.disconnectDown(); column2.disconnectDown(); break;
//                case LEFT: column.disconnectLeft(); column2.disconnectRight(); break;
//                case RIGHT: column.disconnectRight(); column2.disconnectLeft(); break;
//            }
//            column = column.getDown();
//            column2 = column2.getDown();
//        }
//
//    }
//
//    public void disconnectRow(int x, Edge.Direction direction){
//        Tile row = rowsHeads.get(x);
//        Tile row2 = rowsHeads.get(x+1);
//        while(row != null){
//            System.out.println(row.toString());
//            switch (direction){
//                case UP: row.disconnectUp();row2.disconnectDown();break;
//                case DOWN: row.disconnectDown(); row2.disconnectUp(); break;
//                case LEFT: row.disconnectLeft(); row2.disconnectRight(); break;
//                case RIGHT: row.disconnectRight(); row2.disconnectLeft(); break;
//            }
//            row = row.getRight();
//            row2 = row.getRight();
//        }
//    }

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

    public String getGridStructure(){

        Tile temp = gridHead;
        Tile currentRow = gridHead;
        StringBuilder strBldr = new StringBuilder("");

        while(currentRow != null) {
            while (temp != null) {
                strBldr.append(temp.getX() + ""+temp.getY()+ " : ");
                temp = temp.getRight();
            }
            strBldr.append("\n");
            temp = currentRow.getDown();
            currentRow = temp;
        }

        return strBldr.toString();
    }

    public String printClean() {
        Tile temp = gridHead;
        Tile currentRow = gridHead;
        StringBuilder strBldr = new StringBuilder("");
        while (currentRow != null) {
            while (temp != null) {
                strBldr.append(temp.getDirt());
                temp = temp.getRight();
            }
            strBldr.append("\n");
            temp = currentRow.getDown();
            currentRow = temp;
        }
        return strBldr.toString();
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
        setX(x);
        setY(y);
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
        for (Vertex v : path) {
            Tile t = grid.getSpecificTile(v.x, v.y);
            tPaths.add(t);
        }

        return tPaths;
    }

    public Tile removeSweep(int x,int y) {
               
        Tile currentNode = gridHead;

        for(int i=0;i<x;i++) {
            currentNode = currentNode.getRight();
        }
        for(int i=0;i<y;i++) {
            currentNode = currentNode.getDown();
        }

        currentNode.setData("Sweep");
        currentNode.setDirt(1);
        printGrid();
        sweep = currentNode;
        setX(x);
        setY(y);
        return sweep;
    }

    
    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void configureSubGrids(int startX,int endX, int startY, int endY,int dirt){
        for(int i=startX;i<endX;i++){
            for(int j=startY;j<endY;j++){
                Tile t = getSpecificTile(i,j);
                t.setDirt(dirt);
            }
        }
    }

    public void addConnection(Grid grid){
        connections.add(grid);
    }

    public ArrayList<Grid> getConnections(){
        return connections;
    }

    @Override
    public String toString() {
        return "\n Grid : \n"+getGridStructure();
    }
}
