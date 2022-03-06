/**
 * author: Kristian Skibrek
 * date: 23/02/22
 */
package supermarket;

import supermarket.Events.Event;
import supermarket.Events.EventComparator;

import java.util.ArrayList;
import java.util.Collections;

/**
 * main executive routine:
 * http://personal.denison.edu/~bressoud/cs-173/desslides.pdf
 * 1. set clock = 0
 * 2. set cumulative statistics to 0
 * 3. define initial system state (queue empty)
 * 4. generate the occurrence time of the first arrival and place in event list
 * 5. select the next event on the event list (arrival or checkout event)
 * 6. advance simulation clock to time of next event
 * 7. process this event (execute the corresponding event routine)
 * 8. if not end of simulation go to step 5
 */
public class SuperMarket {

    private int clock;
    private CheckoutPoint checkoutPoint;
    private int checkoutTime;
    private int nuPeopleCheckedOut;

    private final int averageItems = 5;
    private final int checkOutTimePerItem = 3;
    private final int arrivalRate = 3;
    private final int runtime = 300;
    /**
     * event types:
     * 1. customer enters queue
     * 2. customer checks out
     *
     * a type 1 event will cause a type 2 event to happen some time later (when all previous checkouts has happened)
     */
    private ArrayList<Event> eventList = new ArrayList<>();

    /**
     * step 1 - 4
     * starts loop
     */
    public void runSimulation(){
        nuPeopleCheckedOut = 0;
        checkoutPoint = new CheckoutPoint();
        clock = 0;
        checkoutTime = 0;
        checkoutPoint.emptyQueue();
        setUpEventList();
        simulationLoop();
    }

    //adds a customerEnters event every
    private void setUpEventList(){
        for (int i = 0; i < runtime; i += arrivalRate) {
            eventList.add(new Event(i, 1));
        }
    }

    /**
     * step 5 - 8
     * runs main loop
     */
    private void simulationLoop(){
        boolean running = true;

        while (running){
            Collections.sort(eventList, new EventComparator());
            doNextEvent(clock);
            if(clock >= runtime || eventList.size() == 0){
                running = false;
            }
        }
    }

    private void doNextEvent(int time){
        doEvent(eventList.get(0), time);
    }

    private void doEvent(Event event, int time){
        switch (event.getIdentifier()){
            case 1: customerEntersQueue(time);
                    removeFirstEventFromEvenList();
                    break;
            case 2: customerChecksOut(time);
                    removeFirstEventFromEvenList();
                    break;
            default: System.out.println("invalid event number");
                    break;
        }
    }

    //event1
    private void customerEntersQueue(int time){
        Customer customer = new Customer(averageItems);
        checkoutPoint.addCustomer(customer);
        eventList.add(new Event(checkoutTime, 2));
        printEventHappened("Customer entered queue");
    }

    //event2
    private void customerChecksOut(int time){
        int numberOfItems = checkoutPoint.getCustomerFromLine(0).getNumberOfItems();
        clock += numberOfItems * checkOutTimePerItem;
        checkoutTime += numberOfItems * checkOutTimePerItem;
        checkoutPoint.removeCustomer();
        nuPeopleCheckedOut++;
        printEventHappened("Customer checked out");
    }

    private void removeFirstEventFromEvenList(){
        eventList.remove(0);
    }

    private void printEventHappened(String event){
        System.out.println("****** Event happened! ******");
        System.out.println(event);
        printStatus();
    }

    private void printStatus(){
        System.out.println("----- Status: ------");
        System.out.print("Number of people in queue: " + checkoutPoint.getQueueLength());
        System.out.print(", " + nuPeopleCheckedOut + " customers have checked out. ");
        System.out.println(" Clock is: " + clock);
        System.out.println("---------------------\n");
    }
}
