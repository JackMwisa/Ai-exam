/**
 * Depth First Search (DFS): 
 * Explores as deeply as possible along each path before backtracking. 
 * DFS uses a stack to manage nodes, either explicitly or through recursion.
 */


package graphsearch;

import java.util.*;

public class DepthFirstSearchGraph {
    public static void dfs(Graph graph, String start, String goal) {
        Stack<String> stack = new Stack<>();
        Set<String> visited = new HashSet<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            String node = stack.pop();

            if (!visited.contains(node)) {
                System.out.println("Visited : " + node);
                visited.add(node);

                if (node.equals(goal)) {
                    System.out.println("Goal found: " + goal);
                    return;
                }

                // Only push unvisited neighbors
                for (String neighbor : graph.getNeighbors(node).keySet()) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }
}

