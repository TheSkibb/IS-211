package supermarket.Events;

public class Event {

    //time indicates the time of execution
    private final int time;

    //identifier can either be 1 or 2
    //1 = customer enters queue
    //2 = customer checkout / leaves store
    int identifier;

    public Event(int time, int identifier){
        this.time = time;
        this.identifier = identifier;
    }

    public int getIdentifier() {
        return identifier;
    }

    public int getTime() {
        return time;
    }
}
