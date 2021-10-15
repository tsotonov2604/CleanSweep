package move;

public class Grid {

    private Tile gridHead;

    public Grid(int size) { // right now only works with squares

        gridHead = new Tile("Floor",1);
        Tile column = gridHead;

        for(int i=0;i<size-1;i++){
            Tile temp = new Tile("Floor",1);
            column.setRight(temp);
            temp.setLeft(column);
            column = temp;

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

}
