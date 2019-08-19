package helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    static public void askHowManyTablesAreThere() {
        println("How many table do you have?");
    }

    public static int readNumber() throws IOException {
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

    public static void tableSelectionDialogue() {

        println("Enter table number for actions...");

    }

   public  static   void askActionOnTable() {
      println("Enter price follow by menu item name to add " +
                "to table receipt, x - clear, p to print, q - do noting ");
      print("> ");
  }

  public static void invalidFormat(){
        println("Invalid format,enter in following format"+"\n[Number][Space][Item name]");
  }

    static public void println(String line){
        System.out.println(line);
    }
    static public void print(String line){
        System.out.print(line);
    }

    static public String readln() throws IOException {
        return reader.readLine();
    }
}
