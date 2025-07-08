import java.util.HashSet;
import java.util.Set;

public class Leetcode437_2 {


    public int pathSum(TreeNode root, int targetSum) {

        Set<TreeNode> nodesOriginated = new HashSet<>();
        int depthForThisDfs = 0;
        return dfs(root, targetSum, 0, nodesOriginated, depthForThisDfs);

    }

    private int dfs(TreeNode currentNode, int targetSum, long currentSum, Set<TreeNode> nodesOriginated, int depthForThisDfs){

        if(depthForThisDfs == 0) {
            if(nodesOriginated.contains(currentNode))
                return 0;
            nodesOriginated.add(currentNode);
        }


        int count = 0;
        if(currentNode == null)
            return 0;

        currentSum += currentNode.val;
        if(currentSum == targetSum)
            count++;


        int left = dfs(currentNode.left, targetSum, currentSum, nodesOriginated, depthForThisDfs+1);
        int right = dfs(currentNode.right, targetSum, currentSum, nodesOriginated, depthForThisDfs+1);

        int leftOrigin = dfs(currentNode.left, targetSum, 0, nodesOriginated, 0);
        int rightOrigin = dfs(currentNode.right, targetSum, 0, nodesOriginated, 0);

        count += leftOrigin + rightOrigin + left + right;
        return count;

    }

}
