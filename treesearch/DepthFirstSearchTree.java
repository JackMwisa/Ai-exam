package treesearch;
import graphsearch.Graph;

import java.util.*;

public class DepthFirstSearchTree {
    public static void dfs(Graph graph, String start, String goal) {
        Stack<String> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            String node = stack.pop();
            System.out.println("Visited (Tree DFS): " + node);

            if (node.equals(goal)) {
                System.out.println("Goal found: " + goal);
                return;
            }

            // Explore all neighbors without checking for cycles
            for (String neighbor : graph.getNeighbors(node).keySet()) {
                stack.push(neighbor);
            }
        }
    }
}

