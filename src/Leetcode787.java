import java.util.*;

public class Leetcode787 {
    public static void main(String[] args){
        System.out.println(findCheapestPrice(5, new int[][]{{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}}, 0, 2, 2));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        boolean[] citiesVisited = new boolean[n];
        Map<Integer, List<int[]>> flightsFromCities = new HashMap<>();
        for (int[] flight : flights){
            List<int[]> flightFromThisCity = flightsFromCities.get(flight[0]);
            if(flightFromThisCity == null)
                flightFromThisCity = new ArrayList<>();
            flightFromThisCity.add(new int[]{flight[1], flight[2]});
            flightsFromCities.put(flight[0], flightFromThisCity);
        }

        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        int price = traverseAndFindThePrice(flightsFromCities, src, dst, k, 0, 0, citiesVisited,Integer.MAX_VALUE, memo);
        return price == Integer.MAX_VALUE ? -1 : price;

    }

    public static int traverseAndFindThePrice(Map<Integer, List<int[]>> flightsFromCities, int src, int des, int k, int currentNumberOfStops,
                                              int priceForThisRoute, boolean[] citiesVisited, int maxPriceToReachUntilNow, int[] memo){


        if(citiesVisited[src])
            return Integer.MAX_VALUE;

        if(src == des)
            return priceForThisRoute;

        if(currentNumberOfStops > k)
            return Integer.MAX_VALUE;

        if(memo[src] != -1)
            return priceForThisRoute+memo[src];

        citiesVisited[src] = true;

        List<int[]> flightsFromThisCity = flightsFromCities.get(src);
        if(flightsFromThisCity == null)
            return Integer.MAX_VALUE;
        int price = Integer.MAX_VALUE;
        for(int[] routes : flightsFromThisCity){
            if(priceForThisRoute + routes[1] > maxPriceToReachUntilNow)
                continue;
            price = Math.min(price, traverseAndFindThePrice(flightsFromCities, routes[0], des, k,
                    currentNumberOfStops+1, routes[1], citiesVisited, maxPriceToReachUntilNow, memo));
            if(price != Integer.MAX_VALUE)
                maxPriceToReachUntilNow = Math.min(maxPriceToReachUntilNow, priceForThisRoute+price);
        }

        citiesVisited[src] = false;

        if(price == Integer.MAX_VALUE)
            return price;
        memo[src] = price;
        return priceForThisRoute + price;

    }

}

/*
traverse each path
if number of stops become greater than k then abandon that path
if we reach the source then return the price
if we have seen a city before this path then abandon that path
 */
