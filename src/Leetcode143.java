public class Leetcode143 {
    public static void main(String[] args){

    }
    public void reorderList(ListNode head) {

        int left = 0;
        int right = -1;
        ListNode currentNode = head;
        while ((currentNode!=null)){
            right++;
            currentNode = currentNode.next;
        }
        ListNode leftNode = head;
        ListNode leftNodePrev = null;
        ListNode leftNodeNext;
        while (right>left+1){
            leftNodeNext = leftNode.next;
            ListNode[] rightNodes = getLastNode(leftNode);
            ListNode rightNodePrev = rightNodes[0];
            ListNode rightNode = rightNodes[1];
            ListNode rightNodeNext = rightNode.next;

            rightNodePrev.next = null;
            leftNode.next = null;

            leftNode.next = rightNode;
            rightNode.next = leftNodeNext;
            rightNodePrev.next=null;

            left++;
            right--;
            leftNodePrev=rightNode;
            leftNode = rightNode.next;
        }


    }

    private ListNode[] getLastNode(ListNode node){
        ListNode[] ans = new ListNode[2];
        ListNode rightNodePrev = null;
        ListNode rightNode = node;
        while (rightNode.next != null){
            rightNodePrev = rightNode;
            rightNode = rightNode.next;
        }
        return new ListNode[]{rightNodePrev,rightNode};
    }
}
