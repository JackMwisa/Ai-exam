package graphsearch;

import java.util.*;

public class GreedySearchGraph {
    public static void greedySearch(Graph graph, String start, String goal, Map<String, Integer> heuristic) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.heuristic));
        Set<String> visited = new HashSet<>();
        queue.add(new Node(start, heuristic.getOrDefault(start, 0)));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (visited.contains(current.name)) continue;
            System.out.println("Visited (graphsearch.GreedySearchGraph.Graph Greedy): " + current.name);

            if (current.name.equals(goal)) {
                System.out.println("Goal found: " + goal);
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

    /**
     *
     * Let us imagine a small city that has land marks (nodes)
     * The nodes are connected by roads (edges )
     * Goal
     * To find :
     *
     * the shortest or fastest route from point 0 to point 100
     *
     *
     * Node can be A location a place in a city
     *
     */

    public static class Graph {

        private Map<String, Map<String, Integer>> aList = new HashMap<>();

        public void addRoad(String from, String to, int time){
            aList.computeIfAbsent(from, k -> new HashMap<>()).put(to, time);

            aList.computeIfAbsent(from, k -> new HashMap<>()).put(from, time);
        }

        public Map<String, Integer> getNeighbors(String node) {
            return aList.getOrDefault(node, new HashMap<>());
        }

        public static class GreedySearch {

        }
    }
}

