import java.util.*;

public class AStarSearch {

    public static void aStarSearch(Graph graph, String start, String goal, Map<String, Integer> heuristic) {
        // Priority Queue for selecting the path with the lowest cost + heuristic
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost + n.heuristic));

        // To track the minimal cost to reach each node
        Map<String, Integer> costs = new HashMap<>();
        costs.put(start, 0);

        // Add the start node to the queue
        queue.add(new Node(start, 0, heuristic.getOrDefault(start, 0)));

        // Track the path to reconstruct the route if needed
        Map<String, String> cameFrom = new HashMap<>();
        cameFrom.put(start, null);

        // A* Search begins
        while (!queue.isEmpty()) {
            Node current = queue.poll();  // Get the node with the smallest cost + heuristic
            System.out.println("Visited: " + current.name);

            // Check if goal is reached
            if (current.name.equals(goal)) {
                System.out.println("Shortest route to " + goal + ": " + current.cost + " mins");
                printPath(cameFrom, start, goal);  // Print the path
                return;
            }

            // Explore neighbors
            for (Map.Entry<String, Integer> neighbor : graph.getNeighbors(current.name).entrySet()) {
                int newCost = current.cost + neighbor.getValue(); // Total cost to reach the neighbor

                // If newCost is less than the previous cost recorded, update it
                if (newCost < costs.getOrDefault(neighbor.getKey(), Integer.MAX_VALUE)) {
                    costs.put(neighbor.getKey(), newCost);
                    queue.add(new Node(neighbor.getKey(), newCost, heuristic.getOrDefault(neighbor.getKey(), 0)));
                    cameFrom.put(neighbor.getKey(), current.name);  // Track the path
                }
            }
        }

        System.out.println("No path found to " + goal);
    }

    // Method to print the path from start to goal
    private static void printPath(Map<String, String> cameFrom, String start, String goal) {
        List<String> path = new ArrayList<>();
        for (String at = goal; at != null; at = cameFrom.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        System.out.println("Path: " + String.join(" -> ", path));
    }

    // Node class representing each location in the city map
    private static class Node {
        String name; // Name of the location (e.g., "Home", "Airport")
        int cost; // Actual cost to reach this node from the start
        int heuristic; // Estimated cost to reach the goal from this node

        Node(String name, int cost, int heuristic) {
            this.name = name;
            this.cost = cost;
            this.heuristic = heuristic;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Node node = (Node) obj;
            return Objects.equals(name, node.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
}
