import java.util.*;

public class BreadthFirstSearch {
    public static void bfs(Graph graph, String start, String goal) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String node = queue.poll();
            System.out.println("Visited: " + node);

            if (node.equals(goal)) {
                System.out.println("Found the goal: " + goal);
                return;
            }

            for (String neighbor : graph.getNeighbors(node).keySet()) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }
}
