import com.sun.source.tree.Tree;

public class Leetcode437 {

    public int pathSum(TreeNode root, int targetSum) {

        if(root == null)
            return 0;

        return dfs(root, targetSum, 0, root);

    }

    private int dfs(TreeNode currentNode, int targetSum, int currentSum, TreeNode root){

        if(currentNode == null)
            return 0;

        int count = 0;
        currentSum += currentNode.val;
        if(currentSum == targetSum)
            count++;

        int left = dfs(currentNode.left, targetSum, currentSum, root);
        int right = dfs(currentNode.right, targetSum, currentSum, root);
        int leftOrigin = 0;
        int rightOrigin = 0;
        leftOrigin = dfs(currentNode.left, targetSum, 0, root);
        rightOrigin = dfs(currentNode.right, targetSum, 0, root);

        count += left+right+leftOrigin+rightOrigin;
        return count;

    }

}
