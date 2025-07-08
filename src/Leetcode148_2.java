import java.util.PriorityQueue;

public class Leetcode148_2 {

    public ListNode sortList(ListNode head) {

        if(head == null)
            return head;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(
                (a,b) -> a.val - b.val
        );

        ListNode next = head;
        while (next != null){

            ListNode curr = next;
            next = next.next;
            curr.next = null;
            queue.offer(curr);

        }

        ListNode newHead = queue.poll();
        ListNode curr = newHead;
        while (!queue.isEmpty()){
            ListNode top = queue.poll();
            curr.next = top;
            curr = top;
        }

        return newHead;

    }

}
