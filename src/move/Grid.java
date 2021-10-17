package move;

public class Grid {

    private Tile gridHead;
    private Tile sweep;

    public Grid(int size) { // right now only works with squares

        gridHead = new Tile("Floor",1);
        Tile column = gridHead;
        Tile row = gridHead;

        for(int i=0;i<size-1;i++){ // got rid of the temp pointer more efficient like that

            column.setRight(new Tile("Floor",1));
            column.getRight().setLeft(column);
            column = column.getRight();

        }

        for( int i =0;i<size-1;i++) { // no need for a temp pointer since all has links
            row.setDown(new Tile("Floor",1));
            row.getDown().setUp(row);
            row = row.getDown();
            column = row;

            for(int j=0;j<size-1;j++) {

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
        return sweep;
    }

}
