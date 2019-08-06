package helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    static public void askHowManyTablesAreThere() {
        println("How many table do you have?");
    }

    static public int readNumber() throws IOException {
        int number;
        print("> ");
        while (true) {
            String line = readln();
            try {
                number = Integer.valueOf(line);
                break;
            } catch (NumberFormatException nfe) {
                println("Invalid number format, please enter number again.");
                print("> ");
            }
        }
        return number;
    }

    public static Integer tableSelectionDialogue() {

        println("Enter number table for action");
        return null;
    }

    public static int selectTable(int number, int totalTables) {
        int currentTable = 0;

        currentTable = currentTable + number;

            if (currentTable < 1 || currentTable > totalTables) {
                System.out.println("There is no such table, you have only  "+totalTables);
            } else {
                System.out.println(" ");
            }

        return currentTable;

    }
     static  public void dialogOrder() {
        System.out.println("Enter price follow by menu item name to add " +
                "to table receipt, or p to print, qu to void");
    }




    static public String makeOrder() throws IOException {
        return reader.readLine();
    }

    static public void println(String line){
        System.out.println(line);
    }
    static private void print(String line){
        System.out.print(line);
    }

    static private String readln() throws IOException {
        return reader.readLine();
    }

}
