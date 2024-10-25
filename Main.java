

public class Main {

    public static void main(String[] args) {

        Graph cityMap = new Graph();
        cityMap.addRoad("Home", "Shop", 3);
        cityMap.addRoad("Home", "Church", 3);
        cityMap.addRoad("Church", "Airport", 7);
        cityMap.addRoad("School", "Field", 6);
        cityMap.addRoad("School", "Library", 1);
        cityMap.addRoad("Library", "Airport", 9);
        cityMap.addRoad("Home", "Airport", 20);

        String start = "Home";
        String goal = "Airport";

        System.out.println("\nDepth-First Search (DFS):");
        DepthFirstSearch.dfs(cityMap, start, goal);





    }

}
