package runner;
import graphsearch.Graph;
import  graphsearch.BreadthFirstSearchGraph;

public class BfsGraphRunner {
    public static void main(String[] args) {
        Graph cityMap = new Graph();
        cityMap.addRoad("Home", "Shop", 3);
        cityMap.addRoad("Home", "Church", 3);
        cityMap.addRoad("Church", "Airport", 7);
        cityMap.addRoad("Shop", "Library", 1);
        cityMap.addRoad("Library", "Airport", 9);

        

        System.out.println("\nBFS Graph Search:");
        BreadthFirstSearchGraph.bfs(cityMap, "Home", "Airport");
    }
}
