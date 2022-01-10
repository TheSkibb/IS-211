import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Author: Kristian Skibrek
 * Date: 01/08/2022
 * Class purpose: starting the program and main loop
 */

public class Main {

    private static final ArrayList<String> commands = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("\n** Welcome to the Euclid Algorithm program **");
        loadCommands();
        mainLoop();
    }

    private static void loadCommands(){
        commands.add("quit - quit the program");
        commands.add("help - open help menu");
        commands.add("euclid - perform the euclid algorithm. After entering, the program will prompt you to enter the two integers you want to find GCD for");
    }

    private static String enterInput(){
        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        // Reading data using readLine
        try{
            System.out.print(">");
            return reader.readLine();

        }
        catch(Exception e){
            System.out.println("Something went wrong please try again");
            enterInput();
            return "error";
        }
        // Printing the read line
    }

    private static void mainLoop(){
        boolean running = true;
        while (running){
            String input = enterInput();
            if(input.equals("quit")){
                System.out.println("Thanks for now");
                running = false;
            }
            else if(input.equals("help")){
                printCommands();
            }
            else if(input.equals("euclid")){
                performEuclid();
            }
            else{
                System.out.println("Command not recognized, please enter \"help\" to see valid command");
            }
        }
    }

    private static void printCommands(){
        for (String command:commands){
            System.out.println(command);
        }
    }

    private static boolean checkIfInt(String input){
        try {
            Integer.parseInt(input);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    private static int enterInteger(){
        boolean stopped = false;
        String input = null;
        while (!stopped){
            System.out.print("integer");
            input = enterInput();
            stopped = checkIfInt(input);
            if (!stopped){
                System.out.println("Input is not recognized as an integer");
            }
        }
        return Integer.parseInt(input);
    }

    private static void performEuclid(){
        EuclidCalculator calculator = new EuclidCalculator();

        System.out.println("please enter the first integer");
        int m = enterInteger();

        System.out.println("please enter the second integer");
        int n = enterInteger();

        if(n > m){
            System.out.println(calculator.euclidAlgorithm(m, n));
        }
        else if(m > n){
            System.out.println(calculator.euclidAlgorithm(m, n));
        }

    }

}