import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static helpers.ConsoleHelper.*;


public class Cafe {

    static class Order {
        double price;
        String title;
    }

    private Map<Integer, List<Order>> cafeOrders;


    Barmen barmen = new Barmen();

    public void dialogQueryHowManyTableAreThere() throws IOException {
        askHowManyTablesAreThere();

        int numberOfTables = readNumber();
        for (int i = 1; i <= numberOfTables; i++) {
            cafeOrders.put(i, new ArrayList<Order>());
        }

        println("Ok now we are  " + cafeOrders.size() + " tables");
    }

    public void dialogForOrderMenu() throws IOException {
        while (true) {
            // which table? (table selection dialogue) // while loop
            int currentTbale = 0;
            // while loop for table actions
            barmen.dialogOrder();
            String order = makeOrder();
            if (barmen.checkOrder(order)) {
                barmen.makeOrderMenu(order);
                System.out.println("Ok, table " + barmen.getNumberTable() + " has " + order);
                barmen.dialogOrder();

                while (true) {
                    String newOrder = makeOrder();
                    if (newOrder.equals("x")) {
                        System.exit(0);
                    }
                    if (newOrder.equals("p")) {
                        barmen.printReceipt();
                        barmen.dialogOrder();
                        continue;
                    }

                    barmen.makeOrderMenu(newOrder);
                }
            } else {
                System.out.println("Invalid format,enter in following format[Number][Space][Item name]");


            }

        }
    }

    public static void main(String[] args) throws IOException {
        Cafe cafe = new Cafe();
        cafe.dialogQueryHowManyTableAreThere();
        cafe.dialogForOrderMenu();
    }
}