public class Leetcode124 {

    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        dfs(root);
        return maxPathSum;

    }

    private int dfs(TreeNode node){

        if(node == null)
            return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);
        int leftGain = left > 0 ? left : 0;
        int rightGain = right > 0 ? right : 0;

        maxPathSum = Math.max(maxPathSum, leftGain+rightGain+node.val);

        return Math.max(node.val + leftGain , node.val + rightGain);

    }

}
