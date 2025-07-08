package unionfind;

public class NumberOfProvinces {

    private int[] root;
    private int[] rank;

    public NumberOfProvinces(int n){
        root = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x){
        if(root[x] == x)
            return x;
        return root[x] = find(root[x]);
    }

    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY)
            return;
        if(rank[rootX] > rank[rootY])
            root[rootY] = rootX;
        else if (rank[rootX] < rank[rootY])
            root[rootX] = rootY;
        else {
            root[rootX] = rootY;
            rank[rootY]++;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;;
        NumberOfProvinces numberOfProvinces = new NumberOfProvinces(n);
        int provinceCount = n;

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if(isConnected[i][j] == 1 && find(i) != find(j)){
                    provinceCount--;
                    union(i,j);
                }
            }
        }
        return provinceCount;
    }

}
