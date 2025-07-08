package graph_adjecencyMatrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {

    List<Node> nodes;
    int[][] matrix;

    public Graph(int size){
        matrix = new int[size][size];
        nodes = new ArrayList<>(size);
    }

    public void addNode(Node node){
        nodes.add(node);
    }

    public void addEdge(int src, int des){
        matrix[src][des] = 1;
    }

    public boolean checkEdge(int src, int des){
        return matrix[src][des] == 1;
    }

    public void printGraph(){

        System.out.print("  ");
        for (int i = 0; i < nodes.size(); i++) {
            System.out.print(nodes.get(i).data + " ");
        }
        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(nodes.get(i).data + " ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    public void depthFirstSearch(int src){

        boolean[] visited = new boolean[matrix.length];
        dfsHelper(src,visited);

    }

    private void dfsHelper(int src, boolean[] visited) {

        if(visited[src])
            return;
        else{
            visited[src] = true;
            System.out.println(nodes.get(src).data + " Visited.");
        }

        for (int i = 0; i < matrix.length; i++) {
            if(matrix[src][i] == 1){
                dfsHelper(i,visited);
            }
        }

    }

    public void breadthFirstSearch(int src) {

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[matrix.length];

        queue.offer(src);
        visited[src] = true;

        while (!queue.isEmpty()){
            int currentSrc = queue.poll();
            System.out.println(nodes.get(currentSrc).data + ": visited");
            for (int i = 0; i < matrix[currentSrc].length; i++) {
                if(matrix[currentSrc][i] == 1 && !visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }

    }
}
