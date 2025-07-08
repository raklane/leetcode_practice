import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode305_2 {

    public static void main(String[] args){
        System.out.println(numIslands2(3, 3, new int[][]{{0,0},{0,1},{1,2},{2,1}}));
    }

    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        UnionFind unionFind = new UnionFind(m*n);
        int[][] grid = new int[m][n];
        List<Integer> result = new ArrayList<>();
        for(int[] positionArray : positions){
            int position = (n*positionArray[0] + positionArray[1]);
            unionFind.union(position, grid);
            result.add(unionFind.numberOfIslands);
        }
        return result;
    }



    static class UnionFind{

        int[] root;
        int[] rank;
        int numberOfIslands;

        public UnionFind(int size){
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
            numberOfIslands = 0;
        }

        public int find(int position){
            if(root[position] == position)
                return position;
            return root[position] = find(root[position]);
        }

        public void union(int position, int[][] grid){
            int row = position/grid[0].length;
            int col = position%grid[0].length;
            if(grid[row][col] == 1)
                return;
            grid[row][col] = 1;
            List<Integer> neighbors = new ArrayList<>();
            if(col != 0 && grid[row][col-1] == 1)
                neighbors.add(position - 1);
            if(col != grid[0].length-1 && grid[row][col+1] == 1)
                neighbors.add(position + 1);
            if(row != 0 && grid[row-1][col] == 1)
                neighbors.add(position - grid[0].length);
            if(row != grid.length-1 && grid[row+1][col] == 1)
                neighbors.add(position + grid[0].length);

            int distinctIslands = 0;
            Set<Integer> roots = new HashSet<>();
            for (int neighbor : neighbors){
                int neighborRoot = find(neighbor);
                if(roots.contains(neighborRoot))
                    continue;
                roots.add(neighborRoot);
                distinctIslands++;
            }
            switch (distinctIslands){
                case 0:
                    numberOfIslands++;
                    break;
                case 2:
                    numberOfIslands--;
                    break;
                case 3:
                    numberOfIslands -= 2;
                    break;
                case 4:
                    numberOfIslands -= 3;
                    break;
            }

            for (int neighbor : neighbors){
                int positionRoot = find(position);
                int neighborRoot = find(neighbor);
                if(positionRoot != neighborRoot){
                    if(rank[positionRoot] > rank[neighborRoot])
                        root[neighborRoot] = positionRoot;
                    else if(rank[positionRoot] < rank[neighborRoot])
                        root[positionRoot] = neighborRoot;
                    else{
                        root[positionRoot] = neighborRoot;
                        rank[neighborRoot]++;
                    }
                }
            }
        }

    }

}
