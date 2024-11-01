import java.io.*;
import java.net.*;

public class Client1 {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 2000);
        BufferedReader keyboard = new  BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream out = new PrintStream(socket.getOutputStream());

        String message;

        do
        {
            message = keyboard.readLine();
            out.println(message);
            message = in.readLine();
            System.out.println("From Server: " + message);
        } while (!message.equals("end"));
        socket.close();
    }
}
