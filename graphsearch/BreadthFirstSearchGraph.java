/**
 * Breadth First Search (BFS): 
 * Explores all neighboring nodes at the current level before moving on to nodes at the next level. 
 * BFS uses a queue to explore nodes in layers and guarantees finding the shortest path in an unweighted graph.
 */

package graphsearch;

import java.util.*;

public class BreadthFirstSearchGraph {
    public static void bfs(Graph graph, String start, String goal) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String node = queue.poll();
            System.out.println("Visited : " + node);

            if (node.equals(goal)) {
                System.out.println("Goal found: " + goal);
                return;
            }

            // Add only unvisited neighbors
            for (String neighbor : graph.getNeighbors(node).keySet()) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }
}

