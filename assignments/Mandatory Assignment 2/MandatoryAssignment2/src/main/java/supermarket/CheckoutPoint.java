package supermarket;

import java.util.ArrayList;

public class CheckoutPoint {
    private ArrayList<Customer> queue = new ArrayList<>();

    public void addCustomer(Customer customer){
        queue.add(customer);
    }

    public Customer getCustomerFromLine(int index){
        return queue.get(index);
    }

    public void removeCustomer(){
        queue.remove(0);
    }

    public void emptyQueue(){
        queue.clear();
    }

    public int getQueueLength(){
        return queue.size();
    }
}
