package treesearch;
import graphsearch.Graph;
import java.util.*;

public class BreadthFirstSearchTree {
    public static void bfs(Graph graph, String start, String goal) {
        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            String node = queue.poll();
            System.out.println("Visited : " + node);

            if (node.equals(goal)) {
                System.out.println("Goal found: " + goal);
                return;
            }

            // Add all neighbors without checking for revisits
            for (String neighbor : graph.getNeighbors(node).keySet()) {
                queue.add(neighbor);
            }
        }
    }
}
