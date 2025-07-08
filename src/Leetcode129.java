public class Leetcode129 {

    int sum = 0;

    public int sumNumbers(TreeNode root) {

        dfs(root, 0);
        return sum;

    }

    private void dfs(TreeNode currentNode, int tempNum){

        if(currentNode == null)
            return;

        tempNum = tempNum*10 + currentNode.val;
        if(currentNode.left == null && currentNode.right == null){
            sum += tempNum;
            return;
        }

        dfs(currentNode.left, tempNum);
        dfs(currentNode.right, tempNum);

    }

}
