import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DepthFirstSearch {

    public static void dfs(Graph graph, String start, String goal){
        Stack<String> stack = new Stack<>();
        Set<String> visited = new HashSet<>();
        stack.push(start);

        while (!stack.empty()){
            String node = stack.pop();
            if (!visited.contains(node)){
                visited.add(node);
                System.out.println("Visited" + node);

                if (node.equals(goal)){
                    System.out.println("I have reached, I have found the goal: " + goal);
                    return;
                }

                for (String neighbor : graph.getNeighbors(node).keySet()){
                    if (!visited.contains(neighbor)){
                        stack.push(neighbor);
                    }
                }
            }
        }
    }
}
