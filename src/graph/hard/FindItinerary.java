package graph.hard;

import java.util.*;

public class FindItinerary {

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(List.of("JFK", "KUL"));
        tickets.add(List.of("JFK", "NRT"));
        tickets.add(List.of("NRT", "JFK"));
        System.out.println(findItinerary(tickets));
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adjList = new HashMap<>();

        for(var ticket : tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            adjList.computeIfAbsent(from, k -> new PriorityQueue<>()).add(to);
        }

        int n = tickets.size();

        List<String> itinerary = new ArrayList<>();

        itinerary.add("JFK");
        dfs("JFK", adjList, itinerary, n);

        return itinerary;
    }

    static boolean dfs(String currAirport, Map<String, PriorityQueue<String>> adjList, List<String> itinerary, int n){

        if (itinerary.size() == n + 1)
            return true;

        List<String> temp = new ArrayList<>(adjList.getOrDefault(currAirport, new PriorityQueue<>()));

        for(String dest : temp){
            itinerary.add(dest);
            adjList.get(currAirport).remove(dest);
            if (dfs(dest, adjList, itinerary, n)) return true;
            adjList.get(currAirport).add(dest);
            itinerary.remove(itinerary.size() - 1);
        }

        return false;
    }


}
