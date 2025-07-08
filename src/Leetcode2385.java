import java.util.*;

public class Leetcode2385 {
    public static void main(String[] args){
        System.out.println((int)(Math.pow(2, 1)));
    }

    public int amountOfTime(TreeNode root, int start) {
        List<TreeNode> visited = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        findInfectedNode(root, start, stack);
        Queue<TreeNode> queue = new LinkedList<>();
        return infectOtherNodes(stack, visited, queue, root);

    }

    private int infectOtherNodes(Stack<TreeNode> stack, List<TreeNode>  visited, Queue<TreeNode> queue, TreeNode root){

        int minuteCount = 0;
        TreeNode infectedNode = stack.pop();
        visited.add(infectedNode);
        if(infectedNode.left != null)
            queue.offer(infectedNode.left);
        if(infectedNode.right != null)
            queue.offer(infectedNode.right);

        while (!queue.isEmpty() || !stack.isEmpty()){

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                visited.add(node);
                if(node.left != null)
                    if(!visited.contains(node.left))
                        queue.offer(node.left);
                if(node.right != null)
                    if(!visited.contains(node.right))
                        queue.offer(node.right);
            }

            if (!stack.isEmpty()){
                TreeNode node = stack.pop();
                visited.add(node);
                if(node.left != null)
                    if(!visited.contains(node.left))
                        queue.offer(node.left);
                if(node.right != null)
                    if(!visited.contains(node.right))
                        queue.offer(node.right);
            }
            minuteCount++;

        }
        return minuteCount;

    }

    private boolean findInfectedNode(TreeNode node, int infectedNodeValue, Stack<TreeNode> stack){

        if(node == null)
            return false;
        stack.push(node);
        if(node.val == infectedNodeValue)
            return true;
        if(findInfectedNode(node.left, infectedNodeValue, stack) || findInfectedNode(node.right, infectedNodeValue, stack))
            return true;
        stack.pop();
        return false;
    }
}
