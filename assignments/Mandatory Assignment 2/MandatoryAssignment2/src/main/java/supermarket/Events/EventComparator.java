package supermarket.Events;

import java.util.Comparator;

/**
 * events are sorted by their time,
 */
public class EventComparator implements Comparator<Event> {

    public int compare(Event event1, Event event2){
        return event1.getTime() - event2.getTime();
    }
}
