import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class LRUCache_old {

    private HashMap<Integer,Integer> map;
    private LinkedList<Integer> cacheList;
    private HashSet<Integer> cacheSet;
    int size = 0;
    int capacity = 0;

    public LRUCache_old(int capacity) {

        map = new HashMap<Integer,Integer>(capacity);
        cacheSet = new HashSet<Integer>();
        this.capacity = capacity;

    }

    public int get(int key) {
        if(map.containsKey(key)){
            if(cacheSet.contains(key)){
                cacheSet.remove(key);
            }
            cacheSet.add(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {

        if(size == capacity){
            int keyToRemove = cacheSet.iterator().next();
            cacheSet.remove(keyToRemove);
            map.remove(keyToRemove);
            size--;
        }
        map.put(key,value);
        size++;
        if(cacheSet.contains(key)){
            cacheSet.remove(key);
        }
        cacheSet.add(key);

    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "map=" + map.toString() +
                ", cacheList=" + cacheList.toString() +
                ", cacheSet=" + cacheSet.toString() +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }
}