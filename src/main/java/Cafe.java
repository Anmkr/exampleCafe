import java.io.IOException;

public class Cafe {
    Barmen barmen = new Barmen();
    ConsoleHelper consoleHelper = new ConsoleHelper();

    public void dialogReservTable() throws IOException {
        consoleHelper.dialog1();
        barmen.sayNumberTable();
        System.out.println("Ok now we are  " + barmen.getNumberTable() + " tables");
        System.out.println("Enter number for actions");
        while (true) {
            int numberTable = consoleHelper.sayNumberTable();
            if (barmen.checkTable(numberTable)) {
                barmen.reservTable(numberTable);
                break;
            } else {
                barmen.dialog2();
                continue;
            }
        }
    }

    public void dialogForOrderMenu() throws IOException {
        while (true) {
            barmen.dialogOrder();
            String order = consoleHelper.makeOrder();
            if (barmen.checkOrder(order)) {
                barmen.makeOrderMenu(order);
                System.out.println("Ok, table " + barmen.getNumberTable() + " has " + order);
                barmen.dialogOrder();

                while (true) {
                    String newOrder = consoleHelper.makeOrder();
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
        cafe.dialogReservTable();
        cafe.dialogForOrderMenu();
    }
}