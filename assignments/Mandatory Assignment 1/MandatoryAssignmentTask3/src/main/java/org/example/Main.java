package org.example;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        Structure structure = new Structure();
        System.out.println("********** program start ********\n");
        System.out.println("put:");
        for (int i = 1; i <= 104; i++) {
            structure.put(i);
        }
        structure.printStatus();
        System.out.println("get:");
        for (int i = 1; i <= 105; i++) {
            System.out.println(" get no " + i + " = " + structure.get());
        }
        System.out.println("\n********* program end ***********");
    }
}
