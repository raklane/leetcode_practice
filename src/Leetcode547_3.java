import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode547_3 {

    public static void main(String[] args){
        System.out.println(findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
    }

    public static int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        UnionSet unionSet = new UnionSet(n*n);
        int provinceCount = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(isConnected[i][j] == 1 & unionSet.find(i) != unionSet.find(j)){
                    unionSet.union(i, j);
                    provinceCount--;
                }
            }
        }
        return provinceCount;

    }

    static class UnionSet{

        int[] root;
        int[] rank;

        public UnionSet(int size){
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int n){
            if(root[n] == n)
                return n;
            return root[n] = find(root[n]);
        }

        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY)
                return;
            if(rank[rootX] > rootY){
                root[rootY] = rootX;
            }
            else if(rank[rootX] < rank[rootY]){
                root[rootX] = rootY;
            }
            else {
                root[rootX] = rootY;
                rank[rootX]++;
            }
        }

    }
}
