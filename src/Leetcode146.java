import java.util.HashMap;
import java.util.Map;

public class Leetcode146 {




    public static void main(String[] args){
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }

    class Node{
        Node prev, next;
        int key;
        int value;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> map;
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    int size = 0;
    int capacity = 0;

    public Leetcode146(int capacity){
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        this.size = 0;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        if(map.containsKey(key)){
            Node node = map.get(key);
            int value = node.value;
            delete(node);
            insert(node);
            map.put(key,node);
            return node.value;
        }else
            return -1;
    }

    private void insert(Node node) {
        if(size == capacity){
            delete(tail.prev);
        }
        map.put(node.key, node);
        node.next = head.next;
        head.next = node;
        node.prev = head;
        node.next.prev = node;
        size++;
    }

    private void delete(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        map.remove(node.key);
        size--;
    }

    public void put(int key, int value){
        if(map.containsKey(key)){
            delete(map.get(key));
        }
        insert(new Node(key, value));
    }


}
