package stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeysAndRooms {
    public static void main(String[] args) {
        KeysAndRooms obj = new KeysAndRooms();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(3);
        List<Integer> list4 = new ArrayList<>();

        List<List<Integer>> mainList = new ArrayList<>();
        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);
        mainList.add(list4);

        boolean res = obj.canVisitAllRooms(mainList);
        System.out.println(res);
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        return Recursive(rooms, new HashSet<>(), 0);
    }

    public boolean Recursive(List<List<Integer>> rooms, Set<Integer> visited, int curr) {
        if(visited.contains(curr))
            return false;
        visited.add(curr);
        if(visited.size() == rooms.size())
            return true;
        boolean result = false;
        for(int x : rooms.get(curr)) {
            if(!visited.contains(x))
                result = Recursive(rooms, visited, x);
            if(result)
                return true;
        }
        return false;
    }
}
