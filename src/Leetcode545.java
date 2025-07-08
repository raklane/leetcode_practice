import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode545 {

    public static void main(String[] args){

    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        if(root.left == null && root.right == null){
            list.add(root.val);
            return list;
        }

        list.add(root.val);
        findLeftBoundary(list,root.left);
        findLeafs(list,root);
        Stack<Integer> stack = new Stack<>();
        findRightBoundary(list,root.right,stack);
        while (!stack.isEmpty())
            list.add(stack.pop());
        return list;
    }

    public void findRightBoundary(List<Integer> list, TreeNode node, Stack<Integer> rightBoundary){
        if(node == null)
            return;
        if(node.left==null && node.right == null)
            return;
        rightBoundary.push(node.val);
        if(node.right != null)
            findRightBoundary(list,node.right,rightBoundary);
        else
            findRightBoundary(list,node.left,rightBoundary);
    }

    public void findLeafs(List<Integer> list, TreeNode node){

        if(node == null)
            return;
        if(node.left == null && node.right == null){
            list.add(node.val);
            return;
        }
        findLeafs(list,node.left);
        findLeafs(list,node.right);
    }

    public void findLeftBoundary(List<Integer> list, TreeNode node){
        if(node == null)
            return;
        if(node.left==null && node.right == null)
            return;
        list.add(node.val);
        if(node.left != null)
            findLeftBoundary(list,node.left);
        else
            findLeftBoundary(list,node.right);
    }


}
