

public class Main {

    public static void main(String[] args) {

        Graph cityMap = new Graph();
        cityMap.addRoad("Home", "Shop", 3);
        cityMap.addRoad("Church", "Airport", 7);
        cityMap.addRoad("School", "Field", 6);

        String start = "Home";
        String goal = "Airport";

        System.out.println("DepthFirstSearch: ");
        System.out.println(" ");
        DepthFirstSearch.dfs(cityMap, start, goal);




    }

}
