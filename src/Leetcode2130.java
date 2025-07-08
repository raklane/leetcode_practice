import java.util.ArrayList;
import java.util.List;

public class Leetcode2130 {

    public int pairSum(ListNode head) {

        ListNode slow = new ListNode(0);
        slow.next = head;
        ListNode fast = new ListNode(0);
        fast.next = head;
        List<Integer> listOfNodesInFirstHalf = new ArrayList<>();
        while (fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            listOfNodesInFirstHalf.add(slow.val);
        }
        slow = slow.next;
        int maxTwinSum = 0;
        int i = 0;
        int size = listOfNodesInFirstHalf.size();
        while (slow!=null){
            maxTwinSum = Math.max(maxTwinSum, listOfNodesInFirstHalf.get(size-i-1)+slow.val);
            i++;
            slow = slow.next;
        }
        return maxTwinSum;

    }

}
