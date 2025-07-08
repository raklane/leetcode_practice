import java.util.*;

public class Leetcode253 {

    public static void main(String[] args){
        int[][] intervals = {{13,15},{1,13}};
        System.out.println(minMeetingRooms(intervals));
    }

    public static int minMeetingRooms(int[][] intervals) {

        if(intervals.length==0)
            return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0])
                    return Integer.compare(o1[0], o2[0]);
                else
                    return Integer.compare(o1[1], o2[1]);
            }
        });

        int meetingRoomIndex = 0;
        Map<Integer, List<int[]>> meetingRooms = new HashMap<>();

        for(int[] interval : intervals){
            int start = interval[0];
            int end = interval[1];
            boolean free = false;
            for (int i = 0; i < meetingRoomIndex && !free; i++) {
                boolean booked = false;
                List<int[]> occupancy = meetingRooms.get(i);
                for(int[] roomTime : occupancy){
                    if((start < roomTime[1] && end > roomTime[0]) ||
                            (end >= roomTime[0] && end < roomTime[1]))   {
                        booked = true;
                        break;
                    }
                }
                if(!booked){
                    occupancy.add(interval);
                    meetingRooms.put(i, occupancy);
                    free = true;
                }
            }
            if(!free){
                List<int[]> occupancy = new ArrayList<>();
                occupancy.add(interval);
                meetingRooms.put(meetingRoomIndex++, occupancy);
            }
        }
        return meetingRooms.size();
    }

}
