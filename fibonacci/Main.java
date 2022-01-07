import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.sound.midi.Sequence;

public class Main {

    private static ArrayList<String> commands = new ArrayList<>();

    public static void main(String args[]){

    loadCommands();
    System.out.println("** Welcome to theSkibbs fibonacci program **");
    mainMenu(enterInput());
        
    }

    private static void loadCommands(){
        commands.add("quit - close the program, will not work when entering numbers. Sometimes has to be written twice. alternatively use ^c");
        commands.add("help - show list of commands");
        commands.add("nonRecursive - uses a non recursive method to calculate your fibonacci number");
        commands.add("recursive - uses a recursive method to calculate your fibonacci number, will be very slow at higher numbers");
        commands.add("recursiveMemo - uses a recursive method with memoization to calculate your fibonacci number");
    }

    private static String enterInput(){
        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
        // Reading data using readLine
        try{
        System.out.print(">");
        String entered = reader.readLine();

        return(entered);
        }
        catch(Exception e){
            System.out.println("Something went wrong please try again");
            enterInput();
        }
        return "error";
        // Printing the read line
    }

    
    private static void mainMenu(String message){
        if(message.equals("error")){
            System.out.println("something went wrong, please open the program again");
        }
        else if(message.equals("quit")){

        }
        else if(message.equals("help")){
            printCommands();
            enterInput();
        }
        else if(message.equals("nonRecursive") || message.equals("recursive") || message.equals("recursiveMemo")){
            System.out.print(message);
            fibonacci(enterInput(), message); 
            mainMenu(enterInput());
        }
        else{
            System.out.println("command not recognized, please type \"help\" to see available commands");
            mainMenu(enterInput());
        }
    }

    //takes in a certain number and uses one of the different fibonacci algorithms to 
    private static void fibonacci(String inputNumber, String algorithm){


        try {
            BigInteger number = new BigInteger(inputNumber);
            if(algorithm.equals("nonRecursive")){
                System.out.println(fibNR(number.intValue()));
            }
            else if(algorithm.equals("recursive")){
                System.out.println(fibR(number));
            }
            else if(algorithm.equals("recursiveMemo")){
                System.out.println(fibRM(number));
            }
        } 
        catch (Exception e) {
            System.out.println("Please enter an integer");
            System.out.print(algorithm);
            fibonacci(enterInput(), algorithm);
        }
        
    }

    private static void printCommands(){
	System.out.println("** help **");
        System.out.println("command - explanation");
        for(String command : commands){
            System.out.println(command);
        }
	System.out.println("*********");
        mainMenu(enterInput());
    }

    // NR = not recursive 
    private static BigInteger fibNR(int n) {

        BigInteger n1 = BigInteger.valueOf(1);
        BigInteger n2 = BigInteger.valueOf(1);
        BigInteger n3 = BigInteger.valueOf(0);

        for (int i = 2; i < n; i++) {
            n3 = n1.add(n2);
            n1 = n2;
            n2 = n3;
        }

        return n3;
    }

    //R = recursive 
    //O(2**n)
    public static BigInteger fibR (BigInteger n){

        if(n.compareTo(BigInteger.TWO) <= 0){
            return (BigInteger.ONE);
        }
        else{
            return fibR(n.subtract(BigInteger.ONE)).add(fibR(n.subtract(BigInteger.TWO)));
        }
    }

    //recursive improved
    //stores already calculated fib numbers (duplicated branches on the tree)
    //dynamic programming with memoization
    //memoization or memoisation is an optimization technique used primarily to speed up computer programs by storing the results of expensive function calls and returning the cached result when the same inputs occur again. --wikipedia


    //create memo object (hashmap)
    private static HashMap<BigInteger, BigInteger> memo = new HashMap<BigInteger, BigInteger>();

    public static BigInteger fibRM(BigInteger n){
        if(memo.get(n) != null){
            return memo.get(n);
        }

        if(n.compareTo(BigInteger.TWO) <= 0){
            return (BigInteger.ONE);
        }
        else{
            memo.put(n, fibRM(n.subtract(BigInteger.ONE)).add(fibRM(n.subtract(BigInteger.TWO))));
        return memo.get(n);
        }
        
    }


}
