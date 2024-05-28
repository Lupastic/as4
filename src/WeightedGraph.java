import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Set;

public class WeightedGraph<S> {
    private Map<S, List<Edge<S>>> adjacencyList;

    public WeightedGraph() {
        this.adjacencyList = new HashMap<>();
    }

    public WeightedGraph(boolean b) {
    }

    public void addVertex(S vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(S source, S destination, double weight) {
        if (!adjacencyList.containsKey(source)) {
            addVertex(source);
        }
        if (!adjacencyList.containsKey(destination)) {
            addVertex(destination);
        }

        Edge<S> newEdge = new Edge<>(source, destination, weight);
        adjacencyList.get(source).add(newEdge);
    }

    public List<Edge<S>> adjacencyList(S vertex) {
        return adjacencyList.getOrDefault(vertex, new ArrayList<>());
    }

    public Set<S> getVertices() {
        return adjacencyList.keySet();
    }
}
