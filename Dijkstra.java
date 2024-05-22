package wiprotraining;
import java.util.*;

public class Dijkstra {
    public static int[] dijkstra(int[][] graph, int src) {
        int n = graph.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.node;
            if (visited[u]) continue;
            visited[u] = true;
            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && !visited[v]) {
                    int newDist = dist[u] + graph[u][v];
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                        pq.add(new Node(v, newDist));
                    }
                }
            }
        }

        return dist;
    }
    static class Node {
        int node;
        int distance;

        Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 10, 20, 0, 0, 0},
            {10, 0, 0, 50, 10, 0},
            {20, 0, 0, 20, 33, 0},
            {0, 50, 20, 0, 20, 2},
            {0, 10, 33, 20, 0, 1},
            {0, 0, 0, 2, 1, 0}
        };
        int src = 0;
        int[] dist = dijkstra(graph, src);

        System.out.println("Shortest distances from node " + src + ":");
        for (int i = 0; i < dist.length; i++) {
            System.out.println("To node " + i + " - Distance: " + dist[i]);
        }
    }
}
