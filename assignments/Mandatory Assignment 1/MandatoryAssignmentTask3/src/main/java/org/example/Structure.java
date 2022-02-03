/**
 * Author: Kristian Skibrek
 * date: 28/01/2022
 */

package org.example;

public class Structure{
    private final int N = 100;
    private int[] buf = new int[N];

    private int end = 0;
    private int start = 0;

    public void put(int item){
        buf[end] = item;
        end = end + 1;
        end = end % N;
    }

    public int get(){
        int item = buf[start];
        start = start + 1;
        start = start % N;

        return item;
    }

    public void printStatus(){

        System.out.println("*** The array now looks like this: ***");

        System.out.println("[");
        for (int i = 0; i < buf.length; i++) {
            System.out.print(buf[i] + ", ");
        }
        System.out.println("]");
        System.out.println();
    }
}