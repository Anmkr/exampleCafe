import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Barmen {
    private Map<String, Integer> orders = new HashMap<String, Integer>();
    private int reservTable;
    private int numberTable;

    public int getNumberTable() {
        return numberTable;
    }

    public  void sayNumberTable() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        numberTable = Integer.parseInt(reader.readLine());
    }



    public void dialog2() {
        System.out.println(" There is no such table, you have only   " + numberTable);
        System.out.println(" Enter number for actions");
    }

    public boolean checkTable(int tableNumber) {
        return tableNumber > 0 && tableNumber <= numberTable ? true : false;
    }

    public void reservTable(int tableNumber) {
        reservTable = tableNumber;

    }

    public boolean checkOrder(String order){
        return order.matches("^([1-9][0-9]*) [A-z]*");

    }


    public void dialogOrder() {
        System.out.println("Enter price follow by menu item name to add " +
                "to table receipt, or p to print, x to void");
    }

    public void makeOrderMenu(String menu) {
        String[] arr = menu.split(" ");
        int price = Integer.parseInt(arr[0]);
        String name = arr[1];
        if (orders.containsKey(name.toLowerCase())) {
            int total = orders.get(name.toLowerCase());
            total = total + price;
            orders.replace(name.toLowerCase(),total);
            return;
        }else{
            orders.put(name.toLowerCase(),price);
        }

    }


    public void printReceipt() {
        for (Map.Entry<String, Integer> map : orders.entrySet()) {
            System.out.println("     Table  " + reservTable + "\n" +
                    "    " +  map.getKey() + "  " + map.getValue());
        }
    }
}
