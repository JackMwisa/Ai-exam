package treesearch;
import graphsearch.Graph;
import java.util.*;

public class GreedySearchTree {
    public static void greedySearch(Graph graph, String start, String goal, Map<String, Integer> heuristic) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.heuristic));
        queue.add(new Node(start, heuristic.getOrDefault(start, 0)));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println("Visited (Tree Greedy): " + current.name);

            if (current.name.equals(goal)) {
                System.out.println("Goal found: " + goal);
                return;
            }

            for (String neighbor : graph.getNeighbors(current.name).keySet()) {
                queue.add(new Node(neighbor, heuristic.getOrDefault(neighbor, 0)));
            }
        }
    }

    private static class Node {
        String name;
        int heuristic;

        Node(String name, int heuristic) {
            this.name = name;
            this.heuristic = heuristic;
        }
    }
}
