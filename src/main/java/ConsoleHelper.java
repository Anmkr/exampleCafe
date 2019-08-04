import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public void dialog1() {
        System.out.println("How many table do you have?");
    }

    public int sayNumberTable() throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    public String makeOrder() throws IOException {
        return reader.readLine();
    }
}
