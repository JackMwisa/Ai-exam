package graphsearch;

import java.util.*;

public class Graph {
    private final Map<String, Map<String, Integer>> adjList = new HashMap<>();

    public void addRoad(String from, String to, int cost) {
        adjList.putIfAbsent(from, new HashMap<>());
        adjList.get(from).put(to, cost);
    }

    public Map<String, Integer> getNeighbors(String node) {
        return adjList.getOrDefault(node, Collections.emptyMap());
    }
}

