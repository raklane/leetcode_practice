import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode261 {

    public static void main(String[] args){

    }

    public boolean validTree(int n, int[][] edges) {

        Map<Integer, List<Integer>> edgesMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            edgesMap.put(i,new ArrayList<>());
        }
        for (int[] edge : edges){
            int i = edge[0];
            int j = edge[1];
            edgesMap.get(i).add(j);
            edgesMap.get(j).add(i);
        }

        boolean[] visitedNode = new boolean[n];
        List<Integer> nodesVisited = new ArrayList<>();

        return checkIfValidTree(n, edgesMap, visitedNode, 0, nodesVisited);

    }

    private boolean checkIfValidTree(int n, Map<Integer, List<Integer>> edgesMap, boolean[] visitedNode, int currentNode, List<Integer> nodesVisited) {

        if(currentNode>=n)
            return true;

        if(visitedNode[currentNode])
            return false;

        visitedNode[currentNode] = true;
        nodesVisited.add(currentNode);

        List<Integer> currentNeighbors = edgesMap.get(currentNode);
        List<Integer> tempList = new ArrayList<>(currentNeighbors);

        for(int neighbor : tempList){

            currentNeighbors.remove((Integer) neighbor);
            List<Integer> otherNeighborEdges = edgesMap.get(neighbor);
            otherNeighborEdges.remove((Integer) currentNode);

            if(!checkIfValidTree(n,edgesMap,visitedNode,neighbor, nodesVisited))
                return false;
        }
        if(currentNode == 0 && nodesVisited.size() != n)
            return false;
        return true;
    }

}
