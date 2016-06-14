package Heap;

import java.util.*;

import static java.util.Collections.sort;

/**
 * Created by subhransumishra on 6/13/16.
 */


class Event{
    int start;
    int end;

    public Event(){
        start = 0;
        end = 0;
    }

    public Event(int start, int end){
        this.start = start;
        this.end = end;
    }
}
public class MeetingRoom {

    public static void main(String[] args){
        List<Event> events = new ArrayList<>();
        events.add(new Event(10, 30));
        events.add(new Event(0, 10));
        events.add(new Event(15, 20));

        System.out.println(events);
        //System.out.println(getRooms(events));
    }

    public int getRooms(List<Event> events){

        int[] start =new int[events.size()];
        int[] end =new int[events.size()];


        System.out.println(events);
        IntervalComparator comp = new IntervalComparator();
        Collections.sort(events, comp);



        return 0;
    }

    public class IntervalComparator implements Comparator<Event> {
        @Override
        public int compare(Event a, Event b) {
            return a.start - b.start;
        }
    }
}
