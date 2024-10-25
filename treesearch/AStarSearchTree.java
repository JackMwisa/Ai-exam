package treesearch;
import graphsearch.Graph;
import java.util.*;

public class AStarSearchTree {
    public static void aStarSearch(Graph graph, String start, String goal, Map<String, Integer> heuristic) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost + n.heuristic));
        queue.add(new Node(start, 0, heuristic.getOrDefault(start, 0)));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println("Visited: " + current.name);

            // Check if goal is reached
            if (current.name.equals(goal)) {
                System.out.println("Path found with cost: " + current.cost);
                return;
            }

            // Explore neighbors
            for (Map.Entry<String, Integer> neighbor : graph.getNeighbors(current.name).entrySet()) {
                int newCost = current.cost + neighbor.getValue();
                queue.add(new Node(neighbor.getKey(), newCost, heuristic.getOrDefault(neighbor.getKey(), 0)));
            }
        }
        System.out.println("Goal not reachable.");
    }

    private static class Node {
        String name;
        int cost;
        int heuristic;

        Node(String name, int cost, int heuristic) {
            this.name = name;
            this.cost = cost;
            this.heuristic = heuristic;
        }
    }
}

