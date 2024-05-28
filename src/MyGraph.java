import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyGraph<Vertex> {
    private Map<Vertex, List<Vertex>> graph;

    public MyGraph(boolean isDirected) {
        this.graph = new HashMap<>();
    }

    public void addEdge(Vertex v, Vertex u) {
        if (!graph.containsKey(v)) {
            graph.put(v, new ArrayList<>());
        }
        if (!graph.containsKey(u)) {
            graph.put(u, new ArrayList<>());
        }

        graph.get(v).add(u);
    }
}

