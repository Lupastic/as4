import java.util.*;

public class Search<V extends Vertex> {
    private Map<V, V> edgeTo;
    private Set<V> marked;
    private V source;

    public Search(WeightedGraph<V> graph, V source) {
        this.source = source;
        this.edgeTo = new HashMap<>();
        this.marked = new HashSet<>();
        bfs(graph, source);
    }

    private void bfs(WeightedGraph<V> graph, V start) {
        Queue<V> queue = new LinkedList<>();
        marked.add(start);
        queue.offer(start);

        while (!queue.isEmpty()) {
            V current = queue.poll();
            for (Edge<V> edge : graph.adjacencyList(current)) {
                V neighbor = edge.getDestination();
                if (!marked.contains(neighbor)) {
                    edgeTo.put(neighbor, current);
                    marked.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
    }

    public boolean hasPathTo(V v) {
        return marked.contains(v);
    }

    public Iterable<V> pathTo(V v) {
        if (!hasPathTo(v)) return null;
        Deque<V> path = new ArrayDeque<>();
        for (V x = v; x != source; x = edgeTo.get(x)) {
            path.push(x);
        }
        path.push(source);
        return path;
    }
}
