import java.util.ArrayList;
import java.util.List;

public class Leetcode234 {

    public boolean isPalindrome(ListNode head) {
        if(head== null || head.next==null)
            return true;
        ListNode currentNode = head;
        boolean oddNumberOfNodes = false;
        while (currentNode!=null) {
            oddNumberOfNodes = !oddNumberOfNodes;
            currentNode = currentNode.next;
        }
        List<Integer> list = new ArrayList<>();
        ListNode slow = new ListNode(0);
        ListNode fast = new ListNode(0);
        slow.next = head;
        fast.next = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            list.add(slow.val);
        }
        slow=slow.next;
        if(oddNumberOfNodes)
            list.removeLast();
        int size = list.size();
        int i = 0;
        while (slow != null){
            if(slow.val != list.get(size-i-1))
                return false;
            slow = slow.next;
            i++;
        }
        return true;
    }

}
