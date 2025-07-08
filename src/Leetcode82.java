public class Leetcode82 {

    public static void main(String[] args){
        ListNode listNode = new ListNode(new int[]{1,2,3,3,4,4,5});
        System.out.println(deleteDuplicates(listNode).val);
    }

    public static ListNode deleteDuplicates(ListNode head) {

        ListNode sentinelNode = new ListNode(0, head);

        ListNode currentNode = sentinelNode.next;
        ListNode previousNode = sentinelNode;

        while (currentNode!= null){

            if(currentNode.next != null && currentNode.val == currentNode.next.val){

                while (currentNode.next != null && currentNode.val == currentNode.next.val){
                    currentNode = currentNode.next;
                }
                currentNode = currentNode.next;

            }else {
                previousNode.next = currentNode;
                previousNode = currentNode;
                currentNode = currentNode.next;
            }

        }
        previousNode.next = currentNode;
        return sentinelNode.next;

    }

}
