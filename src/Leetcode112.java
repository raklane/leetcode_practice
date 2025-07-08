public class Leetcode112 {

    public static void main(String[] args){

    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {

        if(root == null)
            return false;
        return dfs(root, targetSum, 0);

    }

    private static boolean dfs(TreeNode currentNode, int targetSum, int currentSum){

        if(currentNode == null)
            return false;
        currentSum += currentNode.val;

        if(currentNode.left == null && currentNode.right == null){
            if(currentSum == targetSum)
                return true;
            else return false;
        }

        if(dfs(currentNode.left, targetSum, currentSum) || dfs(currentNode.right, targetSum, currentSum))
            return true;
        return false;

    }

}
