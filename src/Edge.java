public class Edge<Vertex> {
    private Vertex source;
    private Vertex destination;
    private Double weight;

    public Edge(Vertex source, Vertex destination, Double weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Vertex getDestination() {
        return destination;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

    public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }
}
