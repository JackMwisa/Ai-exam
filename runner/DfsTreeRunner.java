package runner;
import graphsearch.Graph;
import  treesearch.DepthFirstSearchTree;


public class DfsTreeRunner {
    public static void main(String[] args) {
        Graph cityMap = new Graph();
        cityMap.addRoad("Home", "Shop", 3);
        cityMap.addRoad("Home", "Church", 3);
        cityMap.addRoad("Church", "Airport", 7);
        cityMap.addRoad("Shop", "Library", 1);
        cityMap.addRoad("Library", "Airport", 9);

        System.out.println("\nDFS Tree Search:");
        DepthFirstSearchTree.dfs(cityMap, "Home", "Airport");
    }
}

