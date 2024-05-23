package wiprotraining;
import java.util.*;

class Dijkstra {
    static class Edge {
        int targetNode;
        int weight;

        Edge(int targetNode, int weight) {
            this.targetNode = targetNode;
            this.weight = weight;
        }
    }

    public static void dijkstra(List<List<Edge>> graph, int startNode) {
        int numNodes = graph.size();
        int[] distances = new int[numNodes];
        boolean[] visited = new boolean[numNodes];

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startNode] = 0;

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
        priorityQueue.add(new Edge(startNode, 0));

        while (!priorityQueue.isEmpty()) {
            Edge current = priorityQueue.poll();
            int currentNode = current.targetNode;

            if (visited[currentNode]) continue;
            visited[currentNode] = true;

            for (Edge edge : graph.get(currentNode)) {
                int neighbor = edge.targetNode;
                int newDist = distances[currentNode] + edge.weight;

                if (newDist < distances[neighbor]) {
                    distances[neighbor] = newDist;
                    priorityQueue.add(new Edge(neighbor, newDist));
                }
            }
        }

        System.out.println("Shortest distances from node " + startNode + ":");
        for (int i = 0; i < numNodes; i++) {
            System.out.println("To node " + i + ": " + distances[i]);
        }
    }

    public static void main(String[] args) {
        int numNodes = 5;
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < numNodes; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges (example graph)
        graph.get(0).add(new Edge(1, 10));
        graph.get(0).add(new Edge(4, 3));
        graph.get(1).add(new Edge(2, 2));
        graph.get(2).add(new Edge(3, 9));
        graph.get(3).add(new Edge(2, 7));
        graph.get(4).add(new Edge(1, 1));
        graph.get(4).add(new Edge(2, 8));
        graph.get(4).add(new Edge(3, 2));

        int startNode = 0;
        dijkstra(graph, startNode);
    }
}
