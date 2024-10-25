import java.util.HashMap;
import java.util.Map;

public class GreedyTester {

    public static void main(String[] args) {
        Graph cityMap = new Graph();
        cityMap.addRoad("Home", "Shop", 3);
        cityMap.addRoad("Home", "Church", 3);
        cityMap.addRoad("School", "Field", 6);
        cityMap.addRoad("School", "Library", 1);
        cityMap.addRoad("Library", "Airport", 9);
        cityMap.addRoad("Church", "Airport", 19);


        String start = "Home";
        String goal = "Airport";

        Map<String, Integer> heuristic = new HashMap<>();
        heuristic.put("Home", 10);
        heuristic.put("Shop", 8);
        heuristic.put("Church", 5);
        heuristic.put("School", 7);
        heuristic.put("Field", 3);
        heuristic.put("Library", 2);
        heuristic.put("Airport", 0);

        System.out.println("\nGreedy Search:");
        GreedySearch.greedySearch(cityMap, start, goal, heuristic);
    }
}
