import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraSearch {

    public DijkstraSearch(WeightedGraph<String> weightedGraph, String almaty) {
    }

    static class HeapNode<V extends Vertex> implements Comparable<HeapNode<V>> {
        V vertex;
        double priority;

        public HeapNode(V vertex, double priority) {
            this.vertex = vertex;
            this.priority = priority;
        }
        @Override
        public int compareTo(HeapNode<V> other) {
            return Double.compare(this.priority, other.priority);
        }
    }

    private static <V extends Vertex> Map<V, Double> initDistances(WeightedGraph<V> graph, V start) {
        Map<V, Double> distances = new HashMap<>();
        for (V vertex : graph.getVertices()) {
            distances.put(vertex, Double.POSITIVE_INFINITY);
        }
        distances.put(start, 0.0);
        return distances;
    }

    public static <V extends Vertex> Map<V, Double> dijkstra(WeightedGraph<V> graph, V startV) {
        Map<V, Double> distances = initDistances(graph, startV);

        PriorityQueue<HeapNode<V>> pq = new PriorityQueue<>();
        pq.add(new HeapNode<>(startV, 0.0));

        while (!pq.isEmpty()) {
            HeapNode<V> minNode = pq.poll();
            V current = minNode.vertex;

            for (Edge edge : graph.adjacencyList(current)) {
                Vertex neighbor = (Vertex) edge.getDestination();
                double currentDist = distances.getOrDefault(current, Double.POSITIVE_INFINITY);
                double edgeWeight = (double) edge.getWeight();
                double newDist = currentDist + edgeWeight;

                if (newDist < distances.getOrDefault(neighbor, Double.POSITIVE_INFINITY)) {
                    distances.put((V) neighbor, newDist);
                    pq.add((HeapNode<V>) new HeapNode<>(neighbor, newDist));
                }
            }
        }
        return distances;
    }
}
