import java.io.IOException;
import java.util.*;

import static helpers.ConsoleHelper.*;

public class Cafe {
    static class Order {
        double price;
        String title;

        @Override
        public String toString() {
            return "Order{" +
                    "price=" + price +
                    ", title='" + title + '\'' +
                    '}';
        }

        Order(double price, String title) {
            this.price = price;
            this.title = title;
        }
    }
    private Map<Integer, List<Order>> cafeOrders = new HashMap<>();

    private void dialogQueryHowManyTableAreThere() throws IOException {
        askHowManyTablesAreThere();
        int numberOfTables = readNumber();
        for (int i = 1; i <= numberOfTables; i++) {
            cafeOrders.put(i, new ArrayList<>());
        }
        println("Ok, now we are  " + cafeOrders.size() + " tables.");
    }

    private void mainActionLoop() throws IOException {
        while (true) {
            Integer selectedTable = selectTable();
            if (selectedTable == null) {
                break;
            }
            doActionOnTable(selectedTable);
        }
    }
    private void doActionOnTable(Integer selectedTable) throws IOException {

        while (true) {
            askActionOnTable();
            String orderDescription = readln();
            if (orderDescription.equals("x")) {
                cafeOrders.get(selectedTable).clear();
                break;
            }
            if (orderDescription.equals("p")) {
                println("   Table " + selectedTable);
                println("-------------");
                double total = 0;
                for (Order order : cafeOrders.get(selectedTable)) {
                    println(order.title + "   " + order.price);
                    total += order.price;
                }
                println("-----------");
                println("Total   " + total);
                break;
            }
            if (orderDescription.equals("q")) {
                break;
            }

            if (orderDescription.matches("^([1-9][0-9]*[.]?[0-9]*) [A-z]*")) {
                String[] orderStr = orderDescription.split(" ");
                Order order = new Order(Double.parseDouble(orderStr[0]), orderStr[1]);
                cafeOrders.get(selectedTable).add(order);
                double total = 0;
                int itemCount = 0;
                for (Order o : cafeOrders.get(selectedTable)) {
                    itemCount++;
                    total += o.price;
                }
                println("Ok, table " + selectedTable + " has " + itemCount + " item total price " + total);
                return;
            } else {
                invalidFormat();

            }
        }
    }

    private Integer selectTable() throws IOException {
        tableSelectionDialogue();
        int tableNumber = readNumber();
        if (tableNumber > 0 && tableNumber <= cafeOrders.size()) {
            return tableNumber;
        }
        System.out.println("There is no such table, you have only " + cafeOrders.size()+".");
        return selectTable();
    }

    public static void main(String[] args) throws IOException {
        Cafe cafe = new Cafe();
        cafe.dialogQueryHowManyTableAreThere();
        cafe.mainActionLoop();
    }
}