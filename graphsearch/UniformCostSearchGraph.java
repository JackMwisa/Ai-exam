/**
 * Uniform Cost Search (UCS): Expands the node with the least cumulative path cost. 
 * This algorithm, using a priority queue, finds the lowest-cost path to the goal in weighted graphs.
 */

package graphsearch;

import java.util.*;

public class UniformCostSearchGraph {
    public static void ucs(Graph graph, String start, String goal) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        Map<String, Integer> costs = new HashMap<>();
        costs.put(start, 0);
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println("Visited : " + current.name);

            if (current.name.equals(goal)) {
                System.out.println("Goal reached with minimum travel time: " + current.cost + " mins");
                return;
            }

            // Enqueue neighbors with cost tracking
            for (Map.Entry<String, Integer> neighbor : graph.getNeighbors(current.name).entrySet()) {
                int newCost = current.cost + neighbor.getValue();
                if (newCost < costs.getOrDefault(neighbor.getKey(), Integer.MAX_VALUE)) {
                    costs.put(neighbor.getKey(), newCost);
                    queue.add(new Node(neighbor.getKey(), newCost));
                }
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
