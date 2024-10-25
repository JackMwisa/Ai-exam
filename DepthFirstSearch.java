import java.util.*;

public class DepthFirstSearch {

    public static void dfs(Graph graph, String start, String goal){
        Stack<String> stack = new Stack<>();
        Set<String> visited = new HashSet<>();
        stack.push(start);

        while (!stack.empty()){
            String node = stack.pop();
            if (!visited.contains(node)){
                visited.add(node);
                System.out.println("Visited " + node);

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

    public static class GreedySearch {
        public static void greedySearch(Graph graph, String start, String goal, Map<String, Integer> heuristic) {
            PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.heuristic));
            Set<String> visited = new HashSet<>();
            queue.add(new Node(start, heuristic.getOrDefault(start, 0)));

            while (!queue.isEmpty()) {
                Node current = queue.poll();
                System.out.println("Visited: " + current.name);

                if (current.name.equals(goal)) {
                    System.out.println("Found the goal: " + goal);
                    return;
                }

                visited.add(current.name);

                for (String neighbor : graph.getNeighbors(current.name).keySet()) {
                    if (!visited.contains(neighbor)) {
                        queue.add(new Node(neighbor, heuristic.getOrDefault(neighbor, 0)));
                    }
                }
            }
        }

        private static class Node {
            String name;
            int heuristic;

            Node(String name, int heuristic) {
                this.name = name;
                this.heuristic = heuristic;
            }
        }
    }
}
