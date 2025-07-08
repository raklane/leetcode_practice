public class Leetcode559 {

    public static void main(String[] args){

    }

    public static int maxDepth(Node root) {

        if(root == null)
            return 0;

        return getMaxDepth(root);

    }

    public static int getMaxDepth(Node node){

        if(node.children.isEmpty())
            return 1;

        int currentDepth = 1;
        for(Node subNode : node.children){
            currentDepth = Math.max(currentDepth, 1+getMaxDepth(subNode));
        }
        return currentDepth;

    }
}
