package unionfind;

public class UnionByRank {

    private int[] root;
    private int[] rank;

    public UnionByRank(int size){
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
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
        if(rank[x] > rank[y])
            root[rootY] = rootX;
        else if(rank[x] < rank[y])
            root[rootX] = rootY;
        else {
            root[rootX] = rootY;
            rank[rootY] += 1;
        }
    }

    public boolean connected(int x, int y){
        return find(x) == find(y);
    }

    public static void main(String[] args){

        UnionByRank uf = new UnionByRank(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true

    }

}
