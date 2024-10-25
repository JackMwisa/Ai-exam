package graphsearch;

import java.util.*;


public class AStarSearchGraph {
    public static void aStarSearch(Graph graph, String start, String goal, Map<String, Integer> heuristic) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost + n.heuristic));
        Map<String, Integer> costs = new HashMap<>();
        Set<String> visited = new HashSet<>();

        queue.add(new Node(start, 0, heuristic.getOrDefault(start, 0)));
        costs.put(start, 0);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // Check if node has been visited
            if (visited.contains(current.name)) {
                continue;
            }
            visited.add(current.name);
            System.out.println("Visited: " + current.name);

            // Check if goal is reached
            if (current.name.equals(goal)) {
                System.out.println("Path found with cost: " + current.cost);
                return;
            }

            // Explore neighbors
            for (Map.Entry<String, Integer> neighbor : graph.getNeighbors(current.name).entrySet()) {
                int newCost = current.cost + neighbor.getValue();
                if (newCost < costs.getOrDefault(neighbor.getKey(), Integer.MAX_VALUE)) {
                    costs.put(neighbor.getKey(), newCost);
                    queue.add(new Node(neighbor.getKey(), newCost, heuristic.getOrDefault(neighbor.getKey(), 0)));
                }
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

