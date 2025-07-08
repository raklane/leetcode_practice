public class Leetcode513 {

    public static void main(String[] args){

    }

    public int findBottomLeftValue(TreeNode root) {
        int[] leftMostValue = new int[2];
        leftMostValueFinder(root, leftMostValue, 0);
        return leftMostValue[1];
    }

    private void leftMostValueFinder(TreeNode node, int[] leftMostValue, int currentLevel) {

        if(node==null)
            return;
        currentLevel++;
        if(node.left == null && node.right == null){
            if(currentLevel>leftMostValue[0]){
                leftMostValue[0] = currentLevel;
                leftMostValue[1] = node.val;
            }
            return;
        }
        leftMostValueFinder(node.left,leftMostValue,currentLevel);
        leftMostValueFinder(node.right,leftMostValue,currentLevel);

    }


}
