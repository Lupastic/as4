import java.util.Objects;

public class Edge<Vertex, V, Double> {
    private Vertex source;
    private Vertex destination;
    private Double weight;

    public Edge( Vertex source,Vertex destination,Double weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public Vertex getDestination() {
        return destination;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge<?, V, Number> edge = (Edge<?, V, Number>) o;
        return source.equals(edge.source) && destination.equals(edge.destination) && weight.equals(edge.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination, weight);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "source=" + source +
                ", destination=" + destination +
                ", weight=" + weight +
                '}';
    }
}
