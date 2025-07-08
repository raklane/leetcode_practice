import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class LRUCache {

    class ListNode{
        int key;
        int val;
        ListNode prev;
        ListNode next;
        ListNode(int key, int value){
            this.key = key;
            this.val = value;
        }
    }

    ListNode head;
    ListNode tail;
    int capacity;
    int size;
    Map<Integer, ListNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        ListNode sentinelNode1 = new ListNode(-1,-1);
        ListNode sentinelNode2 = new ListNode(-1,-1);
        map = new HashMap<>();
        head = sentinelNode1;
        tail = sentinelNode2;
        head.prev = tail;
        tail.next = head;
    }

    private void add(ListNode node){
        ListNode lastNode = tail.next;
        tail.next = node;
        node.next = lastNode;
        node.prev = tail;
        lastNode.prev = node;
        size++;
    }

    private void remove(ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public int get(int key) {
        if(!map.containsKey(key))
            return -1;

        ListNode node = map.get(key);
        remove(node);
        add(node);
        return node.val;
    }

    public void put(int key, int value) {

        if(map.containsKey(key)){
            ListNode nodeToRemove = map.get(key);
            remove(nodeToRemove);
        }

        if(size == capacity){
            ListNode nodeToRemove = head.prev;
            remove(nodeToRemove);
            map.remove(nodeToRemove);
        }

        ListNode node = new ListNode(key,value);
        map.put(key, node);
        add(node);

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */