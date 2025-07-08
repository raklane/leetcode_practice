import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Leetcode295 {

    List<Integer> list;
    int size;

    public Leetcode295() {
        list = new LinkedList<>();
        size = 0;
    }

    public void addNum(int num) {
        list.add(num);
        Collections.sort(list);
        size++;
    }

    public double findMedian() {
        if(size%2==1)
            return list.get(size/2);
        int middle = size/2;
        double sumOfMiddleNumbers = list.get(middle-1) + list.get(middle);
        return sumOfMiddleNumbers/2;
    }

}
