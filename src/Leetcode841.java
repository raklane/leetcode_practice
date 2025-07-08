import java.util.ArrayList;
import java.util.List;

public class Leetcode841 {

    public static void main(String[] args){
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        subList.add(2);
        subList.add(3);
        //{{2,3},{},{2},{1,3}}
        System.out.println();
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] visited = new boolean[rooms.size()];
        List<Integer> roomsVisited = new ArrayList<>();
        return visitAllRooms(rooms,visited,roomsVisited, 0);

    }

    private static boolean visitAllRooms(List<List<Integer>> rooms, boolean[] visited, List<Integer>  roomsVisited, int currentRoom){

        if(currentRoom >= rooms.size())
            return false;
        if(visited[currentRoom])
            return false;
        visited[currentRoom] = true;
        roomsVisited.add(currentRoom);
        if(roomsVisited.size() == rooms.size())
            return true;

        List<Integer> keys = rooms.get(currentRoom);
        for(int key : keys){
            if(key == currentRoom)
                continue;
            if(visitAllRooms(rooms,visited,roomsVisited,key))
                return true;
        }
        return false;

    }

}
