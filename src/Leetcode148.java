public class Leetcode148 {

    public ListNode sortList(ListNode head) {

        if(head == null)
            return head;

        ListNode sentinelNode = new ListNode(0, head);

        ListNode left = sentinelNode;
        ListNode right = sentinelNode.next;

        ListNode nodeToSort = right.next;

        while (nodeToSort != null){

            if(nodeToSort.val >= right.val){
                right = nodeToSort;
                nodeToSort = right.next;
                continue;
            }

            ListNode prev = left;
            ListNode curr = left.next;
            while (curr.val < nodeToSort.val){
                prev = curr;
                curr = curr.next;
            }
            right.next = nodeToSort.next;
            prev.next = nodeToSort;
            nodeToSort.next = curr;
            nodeToSort = right.next;

        }
        return sentinelNode.next;

    }

}
