public class Leetcode206 {

    public ListNode reverseList(ListNode head) {
        ListNode currentNode = head;
        ListNode prev = null;
        while (currentNode!= null){
            ListNode next = currentNode.next;
            currentNode.next=prev;
            prev = currentNode;
            currentNode = next;
        }
        return prev;
    }

}
