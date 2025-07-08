import java.util.LinkedList;
import java.util.List;

public class Azn_LongestSegmentwithNonIncreasingOrder {

    static class Segment{
        public int segmentSize;
        public Segment next;
        public Segment(int segmentSize){
            this.segmentSize = segmentSize;
        }
    }
    static class SegmentsList{
        public Segment head;
        public void add(int size){
            Segment segment = new Segment(size);
            Segment currentNode = head;
            if(head == null) {
                head = segment;
            }else{
                while (currentNode.next != null){
                    currentNode = currentNode.next;
                }
                currentNode.next = segment;
            }
        }
    }

    public static void main(String[] args) {

        SegmentsList  segmentsList = new SegmentsList();
        segmentsList.add(2);
        segmentsList.add(5);
        segmentsList.add(4);
        segmentsList.add(4);
        segmentsList.add(5);
        segmentsList.add(4);
        segmentsList.add(3);
        segmentsList.add(1);


        List<Integer> longestSegmentWithNonIncresingOrder = longestSegmentWithNonIncreasingOrder(segmentsList, 8);
        for(int size : longestSegmentWithNonIncresingOrder){
            System.out.println(size);
        }

    }

    public static List<Integer> longestSegmentWithNonIncreasingOrder(SegmentsList segmentList, int size){

        Segment currentSegment = segmentList.head;
        int[] longestSegmentForIndexes = new int[size];
        int longestSegmentLength = 0;
        int longestSegmentIndex = -1;
        for (int i = 0; i < size; i++) {
            longestSegmentForIndexes[i] = currentSegmentLengthForIndex(currentSegment);
            currentSegment = currentSegment.next;
            if(longestSegmentForIndexes[i] > longestSegmentLength){
                longestSegmentLength = longestSegmentForIndexes[i];
                longestSegmentIndex = i;
            }
        }

        List<Integer> list = new LinkedList<>();
        currentSegment = segmentList.head;
        while (longestSegmentIndex-- > 0){
            currentSegment = currentSegment.next;
        }
        while (longestSegmentLength-- > 0){
            list.add(currentSegment.segmentSize);
            currentSegment = currentSegment.next;
        }
        return list;

    }

    public static int currentSegmentLengthForIndex(Segment segment){
        Segment currentSegment = segment;
        int currentSegmentLength = 1;
        while (currentSegment.next != null && currentSegment.segmentSize >= currentSegment.next.segmentSize){
            currentSegment = currentSegment.next;
            currentSegmentLength++;
        }
        return currentSegmentLength;
    }
}
