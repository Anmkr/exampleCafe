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
            }
            catch (NumberFormatException nfe) {
                println("Invalid number format, please enter number again.");
                print("> ");
            }
        }
        return  number;
    }


    static public int sayNumberTable() throws IOException {
        return Integer.parseInt(reader.readLine());
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
