package org.example;

public class Customer {
    private int checkOutTime;
    private int numberOfItems;

    public Customer(int numberOfItems){
        this.numberOfItems = numberOfItems;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems){
        this.numberOfItems = numberOfItems;
    }
}
