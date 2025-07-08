import java.util.*;

public class Leetcode685 {

    public static void main(String[] args){
        findRedundantDirectedConnection(new int[][]{{1,2},{2,3},{3,4},{4,1},{1,5}});
    }

    public static int[] findRedundantDirectedConnection(int[][] edges) {

        HashMap<Integer, List<Integer>> childParentMap = new HashMap<>();
        HashMap<Integer, List<Integer>> parentChildMap = new HashMap<>();

        for(int[] edge : edges){
            List<Integer> childParentList = childParentMap.get(edge[1]);
            if(childParentList == null)
                childParentList = new ArrayList<>();
            childParentList.add(edge[0]);
            childParentMap.put(edge[1],childParentList);

            List<Integer> parentChildList = parentChildMap.get(edge[0]);
            if(parentChildList == null)
                parentChildList = new ArrayList<>();
            parentChildList.add(edge[1]);
            parentChildMap.put(edge[0],parentChildList);
        }

        //check if any node has multiple parents
        for(int key : childParentMap.keySet()){
            List<Integer> value = childParentMap.get(key);
            if(value.size()>1){
                return new int[]{value.getLast(),key};
            }
        }

        //check if any parent with multiple childs are there
        for(int key : parentChildMap.keySet()){
            List<Integer> value = parentChildMap.get(key);
            if(value.size() > 1) {
                for(int childKey : childParentMap.keySet()){
                    if(childKey == key){
                        return new int[]{childParentMap.get(key).getLast(),key};
                    }
                }
            }
        }

        return edges[edges.length-1];

    }


}
