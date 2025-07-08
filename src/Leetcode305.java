import java.util.*;

public class Leetcode305 {

    public static void main(String[] args){
        List<Integer> islandsAfterAddition = numIslands2(3,3,new int[][]{{0,0},{0,1},{1,2},{2,1}});
        System.out.println("Rakesh");
    }

    public static List<Integer> numIslands2(int m, int n, int[][] positions) {

        int[][] arr = new int[m][n];
        List<Integer> islandNumbers = new ArrayList<>();
        List<Integer> islandsAfterAddition = new ArrayList<>();
        int islandMarker = 1;
        for (int[] position : positions){
            islandMarker = fillUpNewLand(arr, position, islandNumbers, islandMarker);
            islandsAfterAddition.add(islandNumbers.size());
        }
        return islandsAfterAddition;
    }

    private static int fillUpNewLand(int[][] arr, int[] position, List<Integer>  islandNumbers, int islandMarker) {
        int i = position[0];
        int j = position[1];
        if(arr[i][j] == 1)
            return islandMarker;

        islandMarker = markIslands(arr, i, j, islandNumbers, islandMarker);
        return islandMarker;

    }

    private static int markIslands(int[][] arr, int i, int j, List<Integer>  islandNumbers, int islandMarker){

        Set<Integer> adjecentIslands = new HashSet<>();
        if(i-1>=0 && arr[i-1][j] != 0)
            adjecentIslands.add(arr[i-1][j]);
        if(i+1<arr.length && arr[i+1][j] != 0)
            adjecentIslands.add(arr[i+1][j]);
        if(j-1>=0 && arr[i][j-1] != 0)
            adjecentIslands.add(arr[i][j-1]);
        if(j+1<arr[0].length && arr[i][j+1] != 0)
            adjecentIslands.add(arr[i][j+1]);

        if(adjecentIslands.size()==0){
            arr[i][j] = ++islandMarker;
            islandNumbers.add(islandMarker);
            return islandMarker;
        }

        int adjecentIslandCounts = adjecentIslands.size();
        Iterator<Integer> iterator = adjecentIslands.iterator();
        int islandNameToKeep = iterator.next();
        while (iterator.hasNext()){
            int islandToRename = iterator.next();
            islandNumbers.remove((Integer) islandToRename);
            for (int k = 0; k < arr.length; k++) {
                for (int l = 0; l < arr[0].length; l++) {
                    if(arr[k][l] == islandToRename)
                        arr[k][l] = islandNameToKeep;
                }
            }
        }
        return islandMarker;

    }

}
