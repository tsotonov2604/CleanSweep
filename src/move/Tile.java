package move;


import ChargingStation.Edge;
import ChargingStation.Vertex;

import java.util.ArrayList;

public class Tile implements IMoveHelper, Comparable<Tile> {

    Grid parentGrid;

    public void clean(ArrayList<Vertex> path,Grid g) {
        ArrayList<Tile> tilesPath = convertPath(path,g);
        System.out.println(tilesPath);
        for(Tile t : tilesPath){
            System.out.println("Moving to "+t.x+" : "+t.y);
            moveTo(t.x,t.y);
        }

        parentGrid.printClean();


    }

    private ArrayList<Tile> convertPath(ArrayList<Vertex> path,Grid grid) {

        ArrayList<Tile> tPaths = new ArrayList<>();
        for(Vertex v : path){
            Tile t = grid.getSpecificTile(v.x,v.y);
            tPaths.add(t);
        }

        return tPaths;
    }

    @Override
    public int compareTo(Tile o) {
        if((this.x == o.x) && (this.y == o.y)){
            return 0;
        }
        else {
            return -1;
        }
    }

    public enum Type{
        floor,
        sweep
    }

    Vertex vertex;
    public  ArrayList<Edge> edges = new ArrayList<>();

    String data; // will be changed to enums or make other subclasses
    private int dirt;
    private Tile up,down,right,left;
    private int x;
    private int y;
    public Tile(String data, int dirt) {
        this.data = data;
        this.dirt = dirt;
    }

    public Tile(String data, int dirt,int x,int y) {
        this.data = data;
        this.dirt = dirt;
        this.x = x;
        this.y = y;
        vertex = new Vertex(x+""+y);
        vertex.x = this.x;
        vertex.y = this.y;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getDirt() {
        return dirt;
    }

    public void setDirt(int dirt) {
        this.dirt = dirt;
    }

    public Tile getUp() {
        return up;
    }

    public void setUp(Tile up) {
        this.up = up;
    }

    public Tile getDown() {
        return down;
    }

    public void setDown(Tile down) {
        this.down = down;
    }

    public Tile getRight() {
        return right;
    }

    public void setRight(Tile right) {
        this.right = right;
    }

    public Tile getLeft() {
        return left;
    }

    public void setLeft(Tile left) {
        this.left = left;
    }

    @Override
    public Tile moveUp() {
        this.getUp().setDirt(0);
        //this.setDirt(1);
        return this.getUp();
    }

    @Override
    public Tile moveDown() {
        this.getDown().setDirt(0);
        //this.setDirt(1);
        return this.getDown();
    }

    @Override
    public Tile moveLeft() {
        this.getLeft().setDirt(0);
        //this.setDirt(1);
        return this.getLeft();
    }

    @Override
    public Tile moveRight() {
        this.getRight().setDirt(0);
        //this.setDirt(1);
        return this.getRight();
    }

    @Override
    public Tile moveTo(int x, int y) {

        try {
            if(right != null) {
                if (right.equals(parentGrid.getSpecificTile(x, y))) {
                    return this.moveRight();
                }
            }
            else if(left != null){
                if (left.equals(parentGrid.getSpecificTile(x, y)) ) {
                    return this.moveLeft();
                }
            }
            else if(up != null) {
                 if (up.equals(parentGrid.getSpecificTile(x, y))) {
                    return this.moveUp();
                }
            }
            else if(down != null) {
                if (down.equals(parentGrid.getSpecificTile(x, y))) {
                        return this.moveDown();
                    }
            }
            else {
                return this;
            }
        }
        catch (Exception e){
            System.out.println(e.getCause());
        }

        return this;


    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public Vertex getVertex() {
        return vertex;
    }

    @Override
    public String toString() {
        return "Tile{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public void initAdjacencies(){
        vertex.adjacencies =  edges.toArray(new Edge[edges.size()]);
    }

    public Grid getParentGrid() {
        return parentGrid;
    }

    public void setParentGrid(Grid parentGrid) {
        this.parentGrid = parentGrid;
    }
}
