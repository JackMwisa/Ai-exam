import java.util.HashMap;
import java.util.Map;

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

public class Graph {

    private Map<String, Map<String, Integer>> aList = new HashMap<>();

    public void addRoad(String from, String to, int time){
        aList.computeIfAbsent(from, k -> new HashMap<>()).put(to, time);

        aList.computeIfAbsent(from, k -> new HashMap<>()).put(from, time);
    }

    public Map<String, Integer> getNeighbors(String node) {
        return aList.getOrDefault(node, new HashMap<>());
    }
}
