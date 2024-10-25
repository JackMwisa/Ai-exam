/**
 * 
 * Greedy Search: Selects nodes based solely on a 
 * heuristic that estimates the remaining distance to the goal, 
 * aiming for the most promising path. However, it doesn’t guarantee an optimal path.
 */

package graphsearch;

import java.util.*;

public class GreedySearchGraph {
    public static void greedySearch(Graph graph, String start, String goal, Map<String, Integer> heuristic) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.heuristic));
        Set<String> visited = new HashSet<>();
        queue.add(new Node(start, heuristic.getOrDefault(start, 0)));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (visited.contains(current.name)) continue;
            System.out.println("Visited: " + current.name);

            if (current.name.equals(goal)) {
                System.out.println("Goal found: " + goal);
                return;
            }

            visited.add(current.name);
            for (String neighbor : graph.getNeighbors(current.name).keySet()) {
                if (!visited.contains(neighbor)) {
                    queue.add(new Node(neighbor, heuristic.getOrDefault(neighbor, 0)));
                }
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
