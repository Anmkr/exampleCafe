import org.omg.PortableInterceptor.INACTIVE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static helpers.ConsoleHelper.*;


public class Cafe {

    static class Order {
        double price;
        String title;
    }

    private Map<Integer, List<Order>> cafeOrders = new HashMap<Integer, List<Order>>();

    public void dialogQueryHowManyTableAreThere() throws IOException {
        askHowManyTablesAreThere();

        int numberOfTables = readNumber();
        for (int i = 1; i <= numberOfTables; i++) {
            cafeOrders.put(i, new ArrayList<Order>());
        }

        println("Ok now we are  " + cafeOrders.size() + " tables");
    }

    public void mainActionLoop() {
        while (true) {
             Integer selectedTable = selectTable() ;
            if (selectedTable == null) {
                break;
            }
            doActionOnTable(selectedTable) ;
        }
    }

    /**
     *
     * 1. promts for action x - clear, p - print, q - do noting,  [number] [good name] to add to table orders
     *
     * @param selectedTable table for which actions are done
     */
    private void doActionOnTable(Integer selectedTable) {
        // TODO
    }

    /**
     *
     * @return table number or null if q is selected
     */
    private Integer selectTable() {
        return null; // TODO
    }

    public static void main(String[] args) throws IOException {
        Cafe cafe = new Cafe();
        cafe.dialogQueryHowManyTableAreThere();
        cafe.mainActionLoop();
    }
}