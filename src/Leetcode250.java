import java.util.HashSet;

public class Leetcode250 {

    public static void main(String[] args){

    }

    public int countUnivalSubtrees(TreeNode root) {
        return helper(root);
    }

    public int helper(TreeNode node){

        if(node == null)
            return 0;

        if(node.left == null && node.right == null)
            return 1;

        int ans = 0;

        if(isUniValTree(node.left,node.val) && isUniValTree(node.right,node.val))
            ans = 1;

        ans += helper(node.left);
        ans += helper(node.right);
        return ans;

    }

    public boolean isUniValTree(TreeNode node, int num){
        if(node == null)
            return true;
        if(node.val != num)
            return false;
        if(node.left == null & node.right == null)
            return true;
        return (isUniValTree(node.left, num) && isUniValTree(node.right,num));
    }


}
