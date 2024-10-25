package runner;
import  graphsearch.GreedySearchGraph;
import java.util.*;
import graphsearch.Graph;

public class GreedyGraphRunner {
    public static void main(String[] args) {
        Graph cityMap = new Graph();
        cityMap.addRoad("Home", "Shop", 3);
        cityMap.addRoad("Home", "Church", 3);
        cityMap.addRoad("Church", "Airport", 7);
        cityMap.addRoad("Shop", "Library", 1);
        cityMap.addRoad("Library", "Airport", 9);

        Map<String, Integer> heuristic = new HashMap<>();
        heuristic.put("Home", 10);
        heuristic.put("Shop", 8);
        heuristic.put("Church", 5);
        heuristic.put("Library", 2);
        heuristic.put("Airport", 0);

        System.out.println("\nGreedy Graph Search:");
        GreedySearchGraph.greedySearch(cityMap, "Home", "Airport", heuristic);
    }
}

