package supermarket;

public class Customer {
    private final int numberOfItems;

    public Customer(int numberOfItems){

        this.numberOfItems = numberOfItems;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }
}
