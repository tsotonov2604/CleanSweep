package move;

public class Grid {

    private Tile gridHead;
    private Tile sweep;
    private int x;
    private int y;

    public Grid(int[][] size) { // right now only works with squares

        gridHead = new Tile("Floor",1);
        Tile column = gridHead;
        Tile row = gridHead;
       
        for(int i=0;i<size[0].length;i++){ // got rid of the temp pointer more efficient like that

            column.setRight(new Tile("Floor",1));
            column.getRight().setLeft(column);
            column = column.getRight();

        }

        for( int i =0;i<size[0].length;i++) { // no need for a temp pointer since all has links
            row.setDown(new Tile("Floor",1));
            row.getDown().setUp(row);
            row = row.getDown();
            column = row;

            for(int j=0;j<size[0].length;j++) {

                column.setRight(new Tile("Floor",1));
                column.getRight().setLeft(column);
                column.getRight().setUp(column.getUp().getRight());
                column.getRight().getUp().setDown(column.getRight());
                column = column.getRight();
            }
        }


    }


    public void printGrid(){

        Tile temp = gridHead;
        Tile currentRow = gridHead;

        while(currentRow != null) {
            while (temp != null) {
                System.out.print(temp.getDirt() + " ");
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
        setX(x);
        setY(y);
        return sweep;
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
        this.y = y;
    }

}
