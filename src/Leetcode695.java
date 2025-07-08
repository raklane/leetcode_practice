import java.util.ArrayList;
import java.util.List;

public class Leetcode695 {

    public static void main(String[] args){
        System.out.println(maxAreaOfIsland(new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}}));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        System.out.println(grid.length + "-----" + grid[0].length);
        UnionFind unionFind = new UnionFind(grid.length * grid[0].length);
        boolean allWater = true;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0)
                    continue;
                allWater = false;
                int position = (i*grid[0].length) + j;
                List<Integer> neighbors = new ArrayList<>();
                if(j != 0 && grid[i][j-1] == 1)
                    neighbors.add(position-1);
                if( j != grid[0].length-1 && grid[i][j+1] == 1)
                    neighbors.add(position+1);
                if(i!=0 && grid[i-1][j] == 1)
                    neighbors.add(position-grid[0].length);
                if(i != grid.length-1 && grid[i+1][j] == 1)
                    neighbors.add(position + grid[0].length);

                for (int neighbor : neighbors){
                    unionFind.union(position, neighbor);
                }
            }
        }
        return allWater ? 0 : unionFind.maxIsland();
    }


    static class UnionFind{

        int[] root;
        int[] rank;
        int[] children;

        public UnionFind(int size){
            root = new int[size];
            rank = new int[size];
            children = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
                children[i] = 1;
            }
        }

        public void add(int x){
            if(children[x] == 0)
                children[x] = 1;
        }

        public int find(int n){
            if(root[n] == n)
                return n;
            return root[n] = find(root[n]);
        }

        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX != rootY){
                if(rank[rootX] > rank[rootY]){
                    root[rootY] = rootX;
                    children[rootX] += children[rootY];
                    children[rootY]=0;
                }
                else if(rank[rootX] < rank[rootY]){
                    root[rootX] = rootY;
                    children[rootY] += children[rootX];
                    children[rootX]=0;
                }
                else {
                    root[rootX] = rootY;
                    rank[rootY]++;
                    children[rootY] += children[rootX];
                    children[rootX] = 1;
                }
            }
        }

        public int maxIsland(){
            int max = 0;
            for (int i = 0; i < children.length; i++) {
                max = Math.max(max, children[i]);
            }
            return max;
        }

    }
}
