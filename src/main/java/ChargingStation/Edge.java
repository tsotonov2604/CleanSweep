package ChargingStation;

public class Edge {

        public enum Direction {
            RIGHT,
            LEFT,
            UP,
            DOWN
        }

        public final Vertex target;
        public final double weight;
        public final Direction direction;
        public Edge(Vertex argTarget, double argWeight, Direction dir)
        {
            target = argTarget;
            weight = argWeight;
            this.direction = dir;
        }


    @Override
    public String toString() {
        return "Edge{" +
                "target=" + target +
                ", weight=" + weight +
                ", direction=" + direction +
                '}';
    }
}

