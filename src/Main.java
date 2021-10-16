import ChargingStation.*;
import move.Grid;
import move.Tile;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {
       // System.out.println("Hello, World!");
      //  ChargingStation cs = new ChargingStation();
       // cs.charge();

        Grid grid = new Grid(10);
        grid.printGrid();
        System.out.println("------------Adding Sweep--------");
        Tile sweep = grid.addSweep(3, 3);
        System.out.println("---------Moving Up-----------");
        sweep = sweep.moveUp();
        grid.printGrid();
        System.out.println("----------Moving Right----------");
        sweep = sweep.moveRight();
        grid.printGrid();
        System.out.println("------------Moving Down--------");
        sweep = sweep.moveDown();
        grid.printGrid();
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");
        Vertex F = new Vertex("F");
        Vertex G = new Vertex("G");
        Vertex H = new Vertex("H");
        Vertex I = new Vertex("I");
        
        A.adjacencies = new Edge[]{ new Edge(B, 1) ,new Edge(D, 1) };
        B.adjacencies = new Edge[]{ new Edge(A, 1), new Edge(E,1),new Edge(C,1)};
        C.adjacencies = new Edge[]{ new Edge(B, 1),new Edge(F, 1)   };
        D.adjacencies = new Edge[]{ new Edge(A, 1),new Edge(E, 1),new Edge(G, 1)   };
        E.adjacencies = new Edge[]{ new Edge(B, 1),new Edge(D, 1),new Edge(F, 1),new Edge(H, 1) };
        F.adjacencies = new Edge[]{ new Edge(C, 1),new Edge(E, 1),new Edge(I, 1)  };
        G.adjacencies = new Edge[]{ new Edge(D, 1),new Edge(H, 1)  };
        H.adjacencies = new Edge[]{ new Edge(G, 1),new Edge(E, 1),new Edge(I, 1) };
        I.adjacencies = new Edge[]{ new Edge(F, 1),new Edge(H, 1) };
        ShortestPath shortestPath = new ShortestPath();
        shortestPath.computePaths(A);
        double minI = I.minDistance;
        double currentCharge = 100;
        if(minI == currentCharge){
            List<Vertex> path = shortestPath.getShortestPathTo(I);
            System.out.println("Path: " + path);
        }else{
            List<Vertex> path = shortestPath.getShortestPathTo(I);
            System.out.println("Path: " + path);
        }
       


    }
}
