public class Leetcode543 {

    public int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        return dfs(root);

    }

    private int dfs(TreeNode currentNode){

        if(currentNode == null)
            return 0;

        int left = dfs(currentNode.left);
        int right = dfs(currentNode.right);
        diameter = Math.max(diameter, left+right+1);
        return Math.max(left, right) + 1;

    }

}
