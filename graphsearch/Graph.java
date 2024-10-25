/**
 * Scenario: Finding the Shortest Route in a Road Map
 * Imagine a small city with landmarks (nodes) connected by roads (edges),
 * and you want to find the shortest or fastest route from a starting point to a destination.
 */


//Tree Search ignores revisits and explores all possible paths.

//Graph Search remembers the lowest-cost path to each node, avoiding redundant revisits


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

