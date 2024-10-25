import java.util.*;

public class UniformCostSearch {
    public static void ucs(Graph graph, String start, String goal) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        Map<String, Integer> costs = new HashMap<>();
        costs.put(start, 0);
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println("Visited: " + current.name);

            if (current.name.equals(goal)) {
                System.out.println("Shortest travel time to " + goal + ": " + current.cost + " mins");
                return;
            }

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

