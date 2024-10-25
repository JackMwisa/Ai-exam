package runner;
import graphsearch.Graph;
import  treesearch.UniformCostSearchTree;

public class UcsTreeRunner {
    public static void main(String[] args) {
        Graph cityMap = new Graph();
        cityMap.addRoad("Home", "Shop", 3);
        cityMap.addRoad("Home", "Church", 3);
        cityMap.addRoad("Church", "Airport", 7);
        cityMap.addRoad("Shop", "Library", 1);
        cityMap.addRoad("Library", "Airport", 9);

        System.out.println("\nUCS Tree Search:");
        UniformCostSearchTree.ucs(cityMap, "Home", "Airport");
    }
}

