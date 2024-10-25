package treesearch;
import graphsearch.Graph;
import java.util.*;

public class UniformCostSearchTree {
    public static void ucs(Graph graph, String start, String goal) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println("Visited (Tree UCS): " + current.name);

            if (current.name.equals(goal)) {
                System.out.println("Goal reached with travel time: " + current.cost + " mins");
                return;
            }

            // Enqueue all neighbors without cost tracking
            for (Map.Entry<String, Integer> neighbor : graph.getNeighbors(current.name).entrySet()) {
                queue.add(new Node(neighbor.getKey(), current.cost + neighbor.getValue()));
            }
        }
    }

    private static class Node {
        String name;
        int cost;

        Node(String name, int cost) {
            this.name = name;
            this.cost = cost;
        }
    }
}
