package graph_adjecencyList;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    List<List<Node>> list;

    public Graph(int size){
        list = new ArrayList<>();
    }

    public void addNode(Node node){
        List<Node> currentList = new ArrayList<>();
        currentList.add(node);
        list.add(currentList);
    }

    public void addEdge(int src, int des){

        List<Node> srcList = list.get(src);
        Node desNode = list.get(des).get(0);
        srcList.add(desNode);
    }

    public boolean checkEdge(int src, int des){
        List<Node> srcList = list.get(src);
        Node desNode = list.get(des).get(0);
        for(Node node : srcList){
            if(node == desNode)
                return true;
        }
        return false;
    }

    public void printGraph(){

        for (int i = 0; i < list.size(); i++) {
            List<Node> currentList = list.get(i);
            for(Node node : currentList)
                System.out.print(node.data + " -> ");
            System.out.println();
        }

    }

}
