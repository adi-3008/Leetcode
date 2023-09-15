package graph;

import java.util.List;
import java.util.*;

public class SortAccordingToDependency {

    public static void main(String[] args) {
        List<List<Integer>> beforeItems = new ArrayList<>();
        beforeItems.add(Arrays.asList(3));
        beforeItems.add(Arrays.asList(6, 0));
        beforeItems.add(Arrays.asList(5));
        beforeItems.add(Arrays.asList(6));
        beforeItems.add(Arrays.asList(3, 6, 7));
        beforeItems.add(new ArrayList<>());
        beforeItems.add(new ArrayList<>());
        beforeItems.add(new ArrayList<>());

        int[] res = sortItems(8, 2, new int[]{-1,-1,1,0,0,1,0,-1}, beforeItems);
        System.out.println(Arrays.toString(res));
    }

    public static int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            if (group[i] == -1) map.computeIfAbsent(group[i] - i, k -> new ArrayList<>()).add(i);
            else map.computeIfAbsent(group[i], k -> new ArrayList<>()).add(i);
        }

        Map<Integer, List<Integer>> groupMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int item : beforeItems.get(i)){
                int offset1 = group[item];
                int offset2 = group[i];
                if (group[item] == -1) offset1 -= item;
                if (group[i] == -1) offset2 -= i;
                if(offset1 != offset2)
                    groupMap.computeIfAbsent(offset2, k-> new ArrayList<>()).add(offset1);
            }
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();

        List<Integer> res = new ArrayList<>();

        for(var entry : map.entrySet()){
            int i = entry.getKey();
            if(!visited.contains(i) && dfsGroups(i, visited, cycle, res, groupMap)) return new int[0];
        }

        visited = new HashSet<>();
        cycle = new HashSet<>();

        List<Integer> ans = new ArrayList<>();

        for(int i : res){
            for(int node : map.getOrDefault(i, new ArrayList<>())){
                if(!visited.contains(node) && dfs(node, visited, cycle, beforeItems, ans))
                    return new int[0];
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();

    }

    static boolean dfsGroups(int group, Set<Integer> visited, Set<Integer> cycle, List<Integer> res, Map<Integer, List<Integer>> groupMap){
        if(visited.contains(group))
            return false;

        if(cycle.contains(group))
            return true;

        cycle.add(group);

        for(int depGroup : groupMap.getOrDefault(group, new ArrayList<>())){
            if(dfsGroups(depGroup, visited, cycle, res, groupMap))
                return true;
        }

        cycle.remove(group);

        res.add(group);

        visited.add(group);

        return false;
    }

    static boolean dfs(int currNode, Set<Integer> visited, Set<Integer> cycle, List<List<Integer>> beforeItems, List<Integer> res){
        if(visited.contains(currNode))
            return false;

        if(cycle.contains(currNode))
            return true;

        cycle.add(currNode);

        for(int beforeNode : beforeItems.get(currNode)){
            if(dfs(beforeNode, visited, cycle, beforeItems, res))
                return true;
        }

        cycle.remove(currNode);

        res.add(currNode);

        visited.add(currNode);

        return false;
    }


}
