public class BfsTester {

    public static void main(String[] args) {
        Graph cityMap = new Graph();
        cityMap.addRoad("Home", "Shop", 3);
        cityMap.addRoad("Home", "Church", 3);
        cityMap.addRoad("School", "Field", 6);
        cityMap.addRoad("School", "Library", 1);
        cityMap.addRoad("Library", "Airport", 9);


        String start = "Home";
        String goal = "Airport";

        System.out.println("\nBreadth-First Search (BFS):");
        BreadthFirstSearch.bfs(cityMap, start, goal);
    }
}
