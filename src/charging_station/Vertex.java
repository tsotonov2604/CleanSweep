package ChargingStation;

import move.Tile;

public class Vertex implements Comparable<Vertex>{
    public final String name;
    public int x, y;
    public Edge[] adjacencies;
    public Tile tile;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
    public Vertex(String argName) { name = argName; }
    public String toString() { return name; }
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }
}
