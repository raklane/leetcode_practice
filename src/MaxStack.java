import java.util.*;

public class MaxStack {

    int currentTop;
    Map<Integer, Integer> map;
    Map<Integer, List<Integer>> indexMap;
    PriorityQueue<Integer> queue;

    public MaxStack() {
        currentTop = -1;
        map = new HashMap<>();
        indexMap = new HashMap<>();
        queue = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void push(int x) {
        System.out.println("push " + currentTop);
        map.put(++currentTop, x);
        List<Integer> indexes = indexMap.getOrDefault(x, new ArrayList<>());
        indexes.add(currentTop);
        indexMap.put(x, indexes);
        queue.add(x);
    }

    public int pop() {
        System.out.println("pop " + currentTop);
        int result = map.get(currentTop);
        map.remove(currentTop);
        List<Integer> indexes = indexMap.get((Integer) result);
        indexes.remove(currentTop);
        indexMap.put(result, indexes);
        queue.remove(currentTop);
        return result;
    }

    public int top() {
        System.out.println("top " + currentTop);
        while (map.get(currentTop) == null)
            currentTop--;
        return map.get(currentTop);
    }

    public int peekMax() {
        System.out.println("peekmax " + currentTop);
        return queue.peek();
    }

    public int popMax() {
        System.out.println("popmax " + currentTop);
        int result = queue.poll();
        List<Integer> indexes = indexMap.get((Integer) result);
        int indexToRemove = indexes.removeLast();
        indexMap.put(result, indexes);
        map.remove(indexToRemove);
        return result;
    }
}